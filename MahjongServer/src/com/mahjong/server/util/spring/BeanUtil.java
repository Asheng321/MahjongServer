package com.mahjong.server.util.spring;

import org.springframework.context.ApplicationContext;

import com.mahjong.server.mina.protocol.AbsMessageProtocol;

/**
 * 
 * @author Simple
 * @date 2013-3-5 上午11:00:11
 * @Description spring bean 工具
 */
public class BeanUtil {

  public static AbsMessageProtocol makeNewIProtocolHandler(String name) {
    return (AbsMessageProtocol)SpringContextUtil.getBean(name, AbsMessageProtocol.class);
  }

  public static boolean containsBean(String id) {
    return SpringContextUtil.containsBean(id);
  }

  public static ApplicationContext getContext() {
    return SpringContextUtil.getApplicationContext();
  }
}
