package ru.kornilaev.post_processors;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import ru.kornilaev.reflection.Default;
import ru.kornilaev.reflection.ToString;

import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Set;

@Component
public class ToStringPostProcessor implements BeanPostProcessor {
    private final Set<String> beanNames = new HashSet<>();

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean.getClass().isAnnotationPresent(ToString.class)) {
            beanNames.add(beanName);
            return bean;
        }

        Field[] fields = bean.getClass().getDeclaredFields();
        for (Field f : fields) {
            if (f.isAnnotationPresent(ToString.class)) {
                beanNames.add(beanName);
                break;
            }
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (beanNames.contains(beanName)) {
            return ToStringProxy.proxy(bean);
        }
        return bean;
    }
}
