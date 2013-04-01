package com.mahjong.server.protocolHandler.game;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.apache.mina.core.session.IoSession;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.mahjong.server.common.Common;
import com.mahjong.server.mina.protocol.AbsMessageProtocol;
import com.mahjong.server.mina.protocol.DataBuf;
import com.mahjong.server.mina.protocol.MessageProtocol;
import com.mahjong.server.model.Room;
import com.mahjong.server.service.GameService;

/**
 * 房间列表
 * 
 * @author Simple
 * @date 2013-3-5 上午10:59:26
 * @Description 注册用户请求
 */
@Component
@Scope("prototype")
public class RoomListReq extends MessageProtocol {

  private static final byte TAG=Common.Req;

  private static final short PROTOCOL_NUM=0x0005;

  private Logger log=Logger.getLogger(this.getClass());

  @Resource
  private GameService gameService;

  private int size;

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
    List<Room> list=gameService.getRooms(size);
    return new RoomListResp(list);
  }

  @Override
  public void reqDecode(DataBuf buf) {
    log.debug(this.getClass().getSimpleName() + " decode");
    size=buf.getInt();
  }
}
