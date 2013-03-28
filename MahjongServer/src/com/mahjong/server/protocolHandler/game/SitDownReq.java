package com.mahjong.server.protocolHandler.game;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.apache.mina.core.session.IoSession;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.mahjong.server.common.Common;
import com.mahjong.server.mina.protocol.AbsMessageProtocol;
import com.mahjong.server.mina.protocol.DataBuf;
import com.mahjong.server.mina.protocol.MessageProtocol;
import com.mahjong.server.service.GameService;

/**
 * 
 * @author Simple
 * @date 2013-3-5 上午10:59:26
 * @Description 注册用户请求
 */
@Component
@Scope("prototype")
public class SitDownReq extends MessageProtocol {

  private static final byte TAG=Common.Req;

  private static final short PROTOCOL_NUM=0x0000;

  private Logger log=Logger.getLogger(this.getClass());

  @Resource
  private GameService gameService;

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
    gameService.sitDown();
    return null;
    // return new SitDownResp("aaaaaaaaaa", "ffffffffffff", "eeeeeeeeeeeee");
  }

  @Override
  public void reqDecode(DataBuf buf) {
    log.debug(this.getClass().getSimpleName() + " decode");
    log.debug(buf.getInt());
    log.debug(buf.getString());
    log.debug(buf.getString());
  }
}
