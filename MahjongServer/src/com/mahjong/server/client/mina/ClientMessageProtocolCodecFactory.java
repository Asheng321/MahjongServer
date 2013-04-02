package com.mahjong.server.client.mina;

import java.nio.charset.Charset;

import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFactory;
import org.apache.mina.filter.codec.ProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolEncoder;

/**
 * 
 * @author Simple
 * @date 2013-3-5 上午10:57:29
 * @Description 消息协议编码解码工厂
 */
public class ClientMessageProtocolCodecFactory implements ProtocolCodecFactory {

  private final ClientMessageProtocolDecoder decoder;

  private final ClientMessageProtocolEncoder encoder;

  public ClientMessageProtocolCodecFactory(Charset charset) {
    this.decoder=new ClientMessageProtocolDecoder(charset);
    this.encoder=new ClientMessageProtocolEncoder(charset);
  }

  public ProtocolDecoder getDecoder(IoSession paramIoSession) throws Exception {
    return decoder;
  }

  public ProtocolEncoder getEncoder(IoSession paramIoSession) throws Exception {
    return encoder;
  }
}
