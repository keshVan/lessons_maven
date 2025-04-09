package ru.kornilaev.post_processors;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.kornilaev.spring.RandomConfig;

import java.util.Random;

@Component
public class RandomBeanRegister implements BeanFactoryPostProcessor {
    private final static Random random = new Random();

    /*private static class RandomConfig {
        @Bean
        @Scope("prototype")
        public Integer random() {
            return random.nextInt(101);
        }
    }*/

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        if (!beanFactory.containsBean("random")) {

            BeanDefinitionRegistry register = (BeanDefinitionRegistry) beanFactory;

            GenericBeanDefinition bd = new GenericBeanDefinition();
            bd.setBeanClass(Integer.class);
            bd.setScope("prototype");
            bd.setInstanceSupplier(() -> random.nextInt(101));
            register.registerBeanDefinition("random", bd);
        }
    }
}
