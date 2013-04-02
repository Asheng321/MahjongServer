package com.mahjong.server.client.mina;

import org.apache.log4j.Logger;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;

import com.mahjong.server.mina.protocol.AbsMessageProtocol;
import com.mahjong.server.mina.protocol.DataBuf;

/**
 * 
 * @author Simple
 * @date 2013-3-5 上午10:58:27
 * @Description 客户端消息处理
 */
public class MinaClientHandler extends IoHandlerAdapter {

  private Logger log=Logger.getLogger(this.getClass());

  @Override
  public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
    // TODO Auto-generated method stub
    super.exceptionCaught(session, cause);
  }

  @Override
  public void messageReceived(IoSession session, Object message) throws Exception {
    AbsMessageProtocol resp=(AbsMessageProtocol)message;
    short pn=resp.getProtocolNum();
    DataBuf buf=resp.getDataBuf();
    switch(pn) {
      case 0x0002:
        byte resultCode=buf.get();
        log.debug("register结果:" + resultCode);
        break;
      case 0x0004:
        byte resultCode2=buf.get();
        log.debug("register结果:" + resultCode2);
        break;
      case 0x0006:
        int size=buf.get();
        for(int i=0; i < size; i++) {
          int id=buf.getInt();
          String name=buf.getString();
          int totalCount=buf.getInt();
          int playerCount=buf.getInt();
          System.out.println("id:" + id + ",name:" + name + "," + playerCount + "/" + totalCount);
        }
    }
  }

  @Override
  public void messageSent(IoSession session, Object message) throws Exception {
    // TODO Auto-generated method stub
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
}
