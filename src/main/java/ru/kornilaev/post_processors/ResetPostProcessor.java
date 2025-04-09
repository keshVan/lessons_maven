package ru.kornilaev.post_processors;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import ru.kornilaev.reflection.Default;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

@Component
public class ResetPostProcessor implements BeanPostProcessor {
    private final ApplicationContext ctx;
    private final Set<String> beanNames = new HashSet<>();

    public ResetPostProcessor(ApplicationContext ctx) {
        this.ctx = ctx;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean.getClass().isAnnotationPresent(Default.class)) {
            beanNames.add(beanName);
            return bean;
        }

        Field[] fields = bean.getClass().getDeclaredFields();
        for (Field f : fields) {
            if (f.isAnnotationPresent(Default.class)) {
                beanNames.add(beanName);
                break;
            }
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (beanNames.contains(beanName)) {
            return ResetProxy.proxy(bean, ctx);
        }
        return bean;
    }
}
