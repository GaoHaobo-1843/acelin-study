package com.gaohb.hello.study.springTest.util;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * <Description><br>
 *
 * @author acelin <br>
 * @CreateDate 2022/3/28 16:06<br>
 * @see com.gaohb.hello.study.springTest.util <br>
 * @since R9.0<br>
 */
@Component
public class SpringUtil implements ApplicationContextAware {

    private static ApplicationContext applicationContext = null;

    public SpringUtil() {
    }

    @Override
    public void setApplicationContext(ApplicationContext arg0) throws BeansException {
        if (applicationContext == null) {
            applicationContext = arg0;
        }
    }

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public static void setAppCtx(ApplicationContext webAppCtx) {
        if (webAppCtx != null) {
            applicationContext = webAppCtx;
        }
    }

    /**
     * 拿到ApplicationContext对象实例后就可以手动获取Bean的注入实例对象
     */
    public static <T> T getBean(Class<T> clazz) {
        return getApplicationContext().getBean(clazz);
    }

    public static <T> T getBean(String name, Class<T> clazz) throws ClassNotFoundException {
        return getApplicationContext().getBean(name, clazz);

    }

    public static final Object getBean(String beanName) {
        return getApplicationContext().getBean(beanName);
    }



    public static final Object getBean(String beanName, String className) throws ClassNotFoundException {
        Class<?> clz = Class.forName(className);
        return getApplicationContext().getBean(beanName, clz.getClass());
    }



    public static boolean containsBean(String name) {

        return getApplicationContext().containsBean(name);

    }



    public static boolean isSingleton(String name) throws NoSuchBeanDefinitionException {

        return getApplicationContext().isSingleton(name);

    }



    public static Class<?> getType(String name) throws NoSuchBeanDefinitionException {

        return getApplicationContext().getType(name);

    }



    public static String[] getAliases(String name) throws NoSuchBeanDefinitionException {

        return getApplicationContext().getAliases(name);

    }

}