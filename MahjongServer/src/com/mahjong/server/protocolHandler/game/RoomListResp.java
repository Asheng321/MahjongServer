package com.mahjong.server.protocolHandler.game;

import java.util.List;

import com.mahjong.server.common.Common;
import com.mahjong.server.mina.protocol.DataBuf;
import com.mahjong.server.mina.protocol.MessageProtocol;
import com.mahjong.server.model.Room;

public class RoomListResp extends MessageProtocol {

  private static final byte TAG=Common.Resp;

  private static final short PROTOCOL_NUM=0x0006;

  private List<Room> rooms;

  public RoomListResp() {
    setTag(TAG);
    setProtocolNum(PROTOCOL_NUM);
  }

  public RoomListResp(List<Room> rooms) {
    this();
    this.rooms=rooms;
  }

  @Override
  public void respEncode(DataBuf buf) {
    buf.put((byte)rooms.size());
    for(Room room: rooms) {
      buf.putInt(room.getId());
      buf.putString(room.getName());
      buf.putInt(room.getTotalCount());
      buf.putInt(room.getPlayerCount());
    }
  }
}
