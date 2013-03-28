package com.mahjong.server.mina.protocol;

import org.apache.mina.core.session.IoSession;

public interface IMessageProtocol {

  public void reqDecode(DataBuf buf);// 请求解码

  public void respEncode(DataBuf buf);// 响应编码

  public AbsMessageProtocol execute(IoSession session, AbsMessageProtocol req);// 执行体
}
