package test.client.mina;

import java.nio.charset.Charset;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolEncoderAdapter;
import org.apache.mina.filter.codec.ProtocolEncoderOutput;

import com.mahjong.server.mina.protocol.MessageProtocol;

/**
 * 
 * @author Simple
 * @date 2013-3-5 上午10:57:48
 * @Description 消息协议编码
 */
public class ClientMessageProtocolEncoder extends ProtocolEncoderAdapter {

  @SuppressWarnings("unused")
  private Charset charset;

  public ClientMessageProtocolEncoder(Charset charest) {
    this.charset=charest;
  }

  public void encode(IoSession session, Object object, ProtocolEncoderOutput out) throws Exception {
    IoBuffer buf=IoBuffer.allocate(2048).setAutoExpand(true);
    MessageProtocol mp=(MessageProtocol)object;
    buf.put(mp.getTag());// tag
    buf.putInt(mp.getLength());// length
    buf.putShort(mp.getProtocolNum());// num
    buf.put(mp.getDataBuf().getBuf());// dataBuf
    buf.flip();
    out.write(buf);
  }
}