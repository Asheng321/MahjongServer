package com.mahjong.server.mina.handler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import com.mahjong.server.mina.protocol.AbsMessageProtocol;
import com.mahjong.server.mina.protocol.DataBuf;
import com.mahjong.server.util.spring.BeanUtil;

/**
 * 
 * @author Simple
 * @date 2013-3-5 上午10:58:35
 * @Description 服务器消息处理
 */
@Component
public class MinaServerHandler extends IoHandlerAdapter implements InitializingBean {

  private Logger log=Logger.getLogger(MinaServerHandler.class);

  @Resource
  private List<AbsMessageProtocol> messageProtocols;

  // 注册[协议编码-协议处理类]
  private Map<Short, String> protocolHandlerMap=new HashMap<Short, String>();

  private void register() {
    for(AbsMessageProtocol messageProtocol: messageProtocols) {
      // 获取协议处理类的类名
      char[] name=messageProtocol.getClass().getSimpleName().toCharArray();
      name[0]=Character.toLowerCase(name[0]);
      String className=String.valueOf(name);
      // 把协议号+类名放入map中
      if(protocolHandlerMap.containsKey(messageProtocol.getProtocolNum())) {
        log.debug(name.toString() + "类的PROTOCOL_NUM已存在!");
      } else {
        protocolHandlerMap.put(messageProtocol.getProtocolNum(), className);
        log.debug("注册协议编码:" + messageProtocol.getProtocolNum() + "-" + className);
      }
    }
  }

  @Override
  public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
    log.debug("异常了！！！");
    cause.printStackTrace();
  }

  @Override
  public void messageReceived(IoSession session, Object message) throws Exception {
    AbsMessageProtocol returnMP=null;
    AbsMessageProtocol mp=(AbsMessageProtocol)message;
    // 获得协议编码
    short protocolNum=mp.getProtocolNum();
    // 获得协议处理类类名
    String protocolHandlerClassName=protocolHandlerMap.get(protocolNum);
    // 获取相应协议处理类的bean
    AbsMessageProtocol protocolHandler=BeanUtil.makeNewIProtocolHandler(protocolHandlerClassName);
    if(null != protocolHandler) {
      protocolHandler.reqDecode(mp.getDataBuf());// 请求解码
      returnMP=protocolHandler.execute(session, returnMP);// 请求执行体
      returnMP.setDataBuf(DataBuf.allocate(1024));
      returnMP.respEncode(returnMP.getDataBuf());
      returnMP.getDataBuf().flip();
    }
    session.write(returnMP);
  }

  @Override
  public void messageSent(IoSession session, Object message) throws Exception {
    // TODO Auto-generated method stub
    log.debug("服务器发送消息至" + session.getId());
    super.messageSent(session, message);
  }

  @Override
  public void sessionClosed(IoSession session) throws Exception {
    // TODO Auto-generated method stub
    super.sessionClosed(session);
  }

  @Override
  public void sessionCreated(IoSession session) throws Exception {
    // TODO Auto-generated method stub
    super.sessionCreated(session);
  }

  @Override
  public void sessionIdle(IoSession session, IdleStatus status) throws Exception {
    // TODO Auto-generated method stub
    super.sessionIdle(session, status);
  }

  @Override
  public void sessionOpened(IoSession session) throws Exception {
    // TODO Auto-generated method stub
    super.sessionOpened(session);
  }

  public void afterPropertiesSet() throws Exception {
    register();
  }
}
