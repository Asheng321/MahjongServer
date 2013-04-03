package com.mahjong.server.protocolHandler.game;

import org.apache.log4j.Logger;
import org.apache.mina.core.session.IoSession;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.mahjong.server.common.Common;
import com.mahjong.server.mina.protocol.AbsMessageProtocol;
import com.mahjong.server.mina.protocol.DataBuf;
import com.mahjong.server.mina.protocol.MessageProtocol;
import com.mahjong.server.model.Player;
import com.mahjong.server.model.Room;

/**
 * 进入房间
 * 
 * @author Simple
 * @date 2013-4-3 下午02:06:06
 * @Description TODO
 */
@Component
@Scope("prototype")
public class EnterRoomReq extends MessageProtocol {

  private static final byte TAG=Common.Req;

  private static final short PROTOCOL_NUM=0x0007;

  private Logger log=Logger.getLogger(this.getClass());

  private int roomId;

  @Override
  public short getProtocolNum() {
    return PROTOCOL_NUM;
  }

  @Override
  public byte getTag() {
    return TAG;
  }

  @Override
  public AbsMessageProtocol execute(IoSession session, AbsMessageProtocol req) {
    log.debug(this.getClass().getSimpleName() + " execute");
    Room room=roomManager.getRoomById(roomId);
    Player me=onlineManager.getBySession(session);
    if(null != room && null != me) {
      int currentNum=room.getPlayers().size();
      if(currentNum < room.getTotalCount()) {
        room.getPlayers().add(me);
        room.setPlayerCount(currentNum + 1);
        me.setRoomId(room.getId());
        me.setPosition(me.getPosition() + 1);
        me.setStatus(1);
        return new EnterRoomResp((byte)1, room);
      }
    }
    return new EnterRoomResp((byte)0, null);
  }

  @Override
  public void reqDecode(DataBuf buf) {
    log.debug(this.getClass().getSimpleName() + " decode");
    roomId=buf.getInt();
  }
}
