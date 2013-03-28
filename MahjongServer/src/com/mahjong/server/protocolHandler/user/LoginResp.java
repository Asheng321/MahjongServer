package com.mahjong.server.protocolHandler.user;

import com.mahjong.server.common.Common;
import com.mahjong.server.mina.protocol.DataBuf;
import com.mahjong.server.mina.protocol.MessageProtocol;

public class LoginResp extends MessageProtocol {

  private static final byte TAG=Common.Resp;

  private static final short PROTOCOL_NUM=0x0004;

  private byte resultCode;

  public LoginResp() {
    setTag(TAG);
    setProtocolNum(PROTOCOL_NUM);
  }

  public LoginResp(byte resultCode) {
    this();
    this.resultCode=resultCode;
  }

  @Override
  public void respEncode(DataBuf buf) {
    buf.put(resultCode);
  }
}
