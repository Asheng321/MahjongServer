package com.mahjong.server.mina.codec;

import java.nio.charset.Charset;

import org.apache.log4j.Logger;
import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolDecoderAdapter;
import org.apache.mina.filter.codec.ProtocolDecoderOutput;

import com.mahjong.server.common.Common;
import com.mahjong.server.mina.protocol.DataBuf;
import com.mahjong.server.mina.protocol.MessageProtocol;

/**
 * 
 * @author Simple
 * @date 2013-3-5 上午10:57:40
 * @Description 消息协议解码
 */
public class ServerMessageProtocolDecoder extends ProtocolDecoderAdapter {

  private Logger log=Logger.getLogger(ServerMessageProtocolDecoder.class);

  @SuppressWarnings("unused")
  private Charset charset;

  public ServerMessageProtocolDecoder(Charset charest) {
    this.charset=charest;
  }

  public void decode(IoSession session, IoBuffer buf, ProtocolDecoderOutput out) throws Exception {
    MessageProtocol mp=new MessageProtocol();
    // 获取协议tag
    byte tag=buf.get();
    // 获取协议体长度
    int length=buf.getInt();
    // 取出协议体
    byte[] bodyData=new byte[length];
    buf.get(bodyData);
    /* 为解析数据做准备 */
    // 检测协议
    IoBuffer tempBuf=IoBuffer.allocate(100).setAutoExpand(true);
    tempBuf.put(tag);
    tempBuf.putInt(length);
    tempBuf.put(bodyData);
    tempBuf.flip();
    if(!canDecode(tempBuf)) {
      return;
    }
    // 协议体buf
    IoBuffer bodyBuf=IoBuffer.allocate(100).setAutoExpand(true);
    bodyBuf.put(bodyData);
    bodyBuf.flip();
    // 整个协议buf
    IoBuffer allBuf=IoBuffer.allocate(100).setAutoExpand(true);
    allBuf.put(tag);
    allBuf.putInt(length);
    allBuf.put(bodyData);
    allBuf.flip();
    //
    if(tag == Common.Req) {
      short protocolNum=bodyBuf.getShort();// 协议编码
      mp.setProtocolNum(protocolNum);
      mp.setDataBuf(new DataBuf(1024, bodyBuf));
    } else {
      log.error("非REQ/未定义的Tag");
    }
    out.write(mp);
  }

  // 是否可以解码
  private boolean canDecode(IoBuffer buf) {
    int protocalHeadLength=7;// 协议头长度
    int remaining=buf.remaining();
    if(remaining < protocalHeadLength) {
      log.error("错误，协议不完整，协议头长度小于" + protocalHeadLength);
      return false;
    } else {
      log.debug("协议完整");
      // 获取协议tag
      byte tag=buf.get();
      if(tag == Common.Req || tag == Common.Resp) {
        log.debug("Tag=" + tag);
      } else {
        log.error("错误，未定义的Tag类型");
        return false;
      }
      // 获取协议体长度
      int length=buf.getInt();
      if(buf.remaining() < length) {
        log.error("错误，真实协议体长度小于消息头中取得的值");
        return false;
      } else {
        log.debug("真实协议体长度:" + buf.remaining() + " = 消息头中取得的值:" + length);
      }
    }
    return true;
  }
}
