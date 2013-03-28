package com.mahjong.server.util.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * 
 * @author Simple
 * @date 2013-3-5 上午11:00:19
 * @Description 主要功能是可以通过beanId来得到spring容器中的bean
 */
class SpringContextUtil implements ApplicationContextAware {

  private static ApplicationContext applicationContext;

  public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
    // 这个地方没有bug，可以赋值
    SpringContextUtil.applicationContext=applicationContext;
  }

  /**
   * @return ApplicationContext
   */
  public static ApplicationContext getApplicationContext() {
    return applicationContext;
  }

  public static Object getBean(String name) {
    try {
      return applicationContext.getBean(name);
    } catch(Exception e) {
      return null;
    }
  }

  public static Object getBean(String name, Class<?> requiredType) throws BeansException {
    return applicationContext.getBean(name, requiredType);
  }

  public static boolean containsBean(String name) {
    return applicationContext.containsBeanDefinition(name);
  }

  public static boolean isSingleton(String name) throws NoSuchBeanDefinitionException {
    return applicationContext.isSingleton(name);
  }

  public static Class<?> getType(String name) throws NoSuchBeanDefinitionException {
    return applicationContext.getType(name);
  }

  public static String[] getAliases(String name) throws NoSuchBeanDefinitionException {
    return applicationContext.getAliases(name);
  }
}
