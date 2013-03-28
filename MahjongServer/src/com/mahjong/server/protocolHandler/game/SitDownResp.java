package com.mahjong.server.protocolHandler.game;

import com.mahjong.server.common.Common;
import com.mahjong.server.mina.protocol.DataBuf;
import com.mahjong.server.mina.protocol.MessageProtocol;

public class SitDownResp extends MessageProtocol {

  private static final byte TAG=Common.Resp;

  private static final short PROTOCOL_NUM=0x0000;

  private String status;

  private String username;

  private String password;

  public SitDownResp() {
    setTag(TAG);
    setProtocolNum(PROTOCOL_NUM);
  }

  public SitDownResp(String status, String username, String password) {
    this();
    this.status=status;
    this.username=username;
    this.password=password;
  }

  @Override
  public void respEncode(DataBuf buf) {
    buf.putString(status);
    buf.putString(username);
    buf.putString(password);
  }
}
