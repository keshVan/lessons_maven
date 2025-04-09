package ru.kornilaev.post_processors;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;

@Component
public class NamePostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        try {
            Field field = bean.getClass().getDeclaredField("name");
            if (field.getType() == String.class) {
                field.setAccessible(true);
                if (field.get(bean) == null) {
                    field.set(bean, "vasia");
                }
            }
        } catch (NoSuchFieldException _) {

        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        return bean;
    }
}
