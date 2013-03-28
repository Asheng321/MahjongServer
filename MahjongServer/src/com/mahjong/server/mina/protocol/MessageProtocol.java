package com.mahjong.server.mina.protocol;

import org.apache.mina.core.session.IoSession;

/**
 * 
 * @author Simple
 * @date 2013-3-5 上午10:56:27
 * @Description 消息协议-请求
 */
public class MessageProtocol extends AbsMessageProtocol {

  // tag
  // length
  // 协议编号
  // dataBuf
  public int getLength() {
    return 2 + (getDataBuf() == null ? 0 : getDataBuf().getBuf().limit());
  }

  public void reqDecode(DataBuf buf) {
    // TODO Auto-generated method stub
  }

  public void respEncode(DataBuf buf) {
    // TODO Auto-generated method stub
  }

  public AbsMessageProtocol execute(IoSession session, AbsMessageProtocol req) {
    // TODO Auto-generated method stub
    return null;
  }
}
