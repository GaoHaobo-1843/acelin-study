package com.gaohb.hello.study.springTest.common.util;

import java.util.Map;
import java.util.Objects;
import java.util.function.Supplier;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * Spring工具类
 * @author Admin
 */
@Component
public class SpringUtils implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    private static Environment environment;

    /**
     * 设置上下文
     * @param applicationContext
     * @throws BeansException
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        initApplicationContext(applicationContext);
    }

    /**
     * 初始化上下文
     * @param applicationContext
     */
    private static void initApplicationContext(ApplicationContext applicationContext) {
        SpringUtils.applicationContext = applicationContext;
    }

    /**
     * 返回上下文
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T extends ApplicationContext> T getApplicationContext() {
        return (T) applicationContext;
    }

    /**
     * 根据bean的name返回bean实例
     * @param name
     * @return
     * @throws BeansException
     */
    @SuppressWarnings("unchecked")
    public static <T> T getBean(String name) throws BeansException {
        return (T) applicationContext.getBean(name);
    }

    /**
     * 根据bean的name和class类型返回bean实例
     * @param name
     * @param requiredType
     * @return
     * @throws BeansException
     */
    public static <T> T getBean(String name, Class<T> requiredType) throws BeansException {
        return applicationContext.getBean(name, requiredType);
    }

    /**
     * 根据class类型返回bean实例
     * @param requiredType
     * @return
     * @throws BeansException
     */
    public static <T> T getBean(Class<T> requiredType) throws BeansException {
        return applicationContext.getBean(requiredType);
    }

    /**
     * BeanFactory是否包含此name的实例
     * @param name
     * @return
     */
    public static boolean containsBean(String name) {
        return applicationContext.containsBean(name);
    }

    /**
     * 根据bean的name判断该bean是否单例
     * @param name
     * @return
     * @throws NoSuchBeanDefinitionException
     */
    public static boolean isSingleton(String name) throws NoSuchBeanDefinitionException {
        return applicationContext.isSingleton(name);
    }

    /**
     * 根据bean的name判断该bean是否多例
     * @param name
     * @return
     * @throws NoSuchBeanDefinitionException
     */
    public static boolean isPrototype(String name) throws NoSuchBeanDefinitionException {
        return applicationContext.isPrototype(name);
    }

    /**
     * 根据bean的name判断该bean是否实现了class类型接口
     * @param name
     * @param targetType
     * @return
     * @throws NoSuchBeanDefinitionException
     */
    public static boolean isTypeMatch(String name, Class<?> targetType) throws NoSuchBeanDefinitionException {
        return applicationContext.isTypeMatch(name, targetType);
    }

    /**
     * 根据bean的name返回该bean的class类型
     * @param name
     * @return
     * @throws NoSuchBeanDefinitionException
     */
    public static Class<?> getType(String name) throws NoSuchBeanDefinitionException {
        return applicationContext.getType(name);
    }

    /**
     * 根据bean的name返回该bean的别名
     * @param name
     * @return
     */
    public static String[] getAliases(String name) {
        return applicationContext.getAliases(name);
    }

    /**
     * 从spring中取bean，没有就注册一个
     * @param name
     * @param requiredType
     * @return
     */
    public static <T> T getOrRegisterBean(String name, Class<T> requiredType) {
        if (Objects.isNull(requiredType)) {
            return null;
        }

        ConfigurableApplicationContext appContext = getApplicationContext();
        T bean = null;
        try {
            bean = appContext.getBean(name, requiredType);
        }
        catch (NoSuchBeanDefinitionException e) {
            // ignore
        }

        if (Objects.isNull(bean)) {
            DefaultListableBeanFactory beanFactory = (DefaultListableBeanFactory) appContext.getBeanFactory();
            BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(requiredType);
            beanFactory.registerBeanDefinition(name, beanDefinitionBuilder.getRawBeanDefinition());

            bean = appContext.getBean(name, requiredType);
        }

        return bean;
    }

    /**
     * 从spring中取bean，没有就注册一个，bean的name是类名(首字母小写)
     * @param requiredType
     * @return
     */
    public static <T> T getOrRegisterBean(Class<T> requiredType) {
        if (Objects.isNull(requiredType)) {
            return null;
        }

        // 首字母小写
        String name = StringUtils.uncapitalize(requiredType.getSimpleName());
        return getOrRegisterBean(name, requiredType);
    }

    /**
     * 获取同一个类的所有Bean(可以通过接口类型获取所有实现类)
     * @param type
     * @return
     */
    public static <T> Map<String, T> getBeansOfType(Class<T> type) {
        return applicationContext.getBeansOfType(type);
    }

    /**
     * 设置Spring环境属性
     * @param environment
     */
    public static void setEnvironment(Environment environment) {
        SpringUtils.environment = environment;
    }

    /**
     * 获取Spring环境属性
     * @return
     */
    public static Environment getEnvironment() {
        if (Objects.isNull(environment)) {
            environment = applicationContext.getEnvironment();
        }
        return environment;
    }


    /**
     * 根据类型获取 bean 实例，如果不存在 bean, 返回自定义的实例
     *
     * @param beanClass bean 类型
     * @param supplier 不存在 bean 时生成自定义实例的提供者
     * @param <T> bean 类型
     * @return Bean 实例
     * @throws BeansException bean 不存在，或者有多个 bean 且优先级相同
     */
    public static <T> T getBean(Class<T> beanClass, Supplier<T> supplier) {
        try {
            return applicationContext.getBean(beanClass);
        }
        catch (NoSuchBeanDefinitionException e) {
            return supplier.get();
        }
    }
}
