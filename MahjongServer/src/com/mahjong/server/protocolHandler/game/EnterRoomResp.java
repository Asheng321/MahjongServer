package com.mahjong.server.protocolHandler.game;

import com.mahjong.server.common.Common;
import com.mahjong.server.mina.protocol.DataBuf;
import com.mahjong.server.mina.protocol.MessageProtocol;
import com.mahjong.server.model.Room;

public class EnterRoomResp extends MessageProtocol {

  private static final byte TAG=Common.Resp;

  private static final short PROTOCOL_NUM=0x0008;

  private byte resultCode;

  private Room room;

  public EnterRoomResp() {
    setTag(TAG);
    setProtocolNum(PROTOCOL_NUM);
  }

  public EnterRoomResp(byte resultCode, Room room) {
    this();
    this.resultCode=resultCode;
    this.room=room;
  }

  @Override
  public void respEncode(DataBuf buf) {
    buf.put(resultCode);
    if(resultCode == 1) {
      buf.putInt(room.getId());
      buf.putString(room.getName());
      buf.putInt(room.getTotalCount());
      buf.putInt(room.getPlayerCount());
    }
  }
}
