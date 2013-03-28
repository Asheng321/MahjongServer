package test.client.test;

import java.net.InetSocketAddress;
import java.nio.charset.Charset;

import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;
import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.transport.socket.nio.NioSocketConnector;
import org.junit.Test;

import test.client.mina.ClientMessageProtocolCodecFactory;
import test.client.mina.MinaClientHandler;

import com.mahjong.server.common.Common;
import com.mahjong.server.mina.protocol.DataBuf;
import com.mahjong.server.mina.protocol.MessageProtocol;

/**
 * 
 * @author Simple
 * @date 2013-3-5 上午10:57:11
 * @Description Mina客户端
 */
public class MinaClientTest {

  public void login(String username, String password) {
    NioSocketConnector connector=new NioSocketConnector();
    DefaultIoFilterChainBuilder filterChain=connector.getFilterChain();// 过滤链
    filterChain.addLast("clientFilter", new ProtocolCodecFilter(new ClientMessageProtocolCodecFactory(Charset.forName("UTF-8"))));// add
    // Filter
    connector.setHandler(new MinaClientHandler());// handler
    connector.setConnectTimeoutMillis(3000);
    ConnectFuture cf=connector.connect(new InetSocketAddress("localhost", Common.PORT));
    cf.awaitUninterruptibly();// 等待连接创建完成
    MessageProtocol req=new MessageProtocol();
    req.setTag(Common.Req);
    req.setProtocolNum((short)0x0003);
    DataBuf dataBuf=DataBuf.allocate(1024);
    dataBuf.putString(username);
    dataBuf.putString(password);
    dataBuf.flip();
    req.setDataBuf(dataBuf);
    cf.getSession().write(req);
    cf.getSession().getCloseFuture().awaitUninterruptibly();// 等待连接断开
    connector.dispose();
  }

  public void register(String username, String password, String mobileNum) {
    NioSocketConnector connector=new NioSocketConnector();
    DefaultIoFilterChainBuilder filterChain=connector.getFilterChain();// 过滤链
    filterChain.addLast("clientFilter", new ProtocolCodecFilter(new ClientMessageProtocolCodecFactory(Charset.forName("UTF-8"))));// add
    // Filter
    connector.setHandler(new MinaClientHandler());// handler
    connector.setConnectTimeoutMillis(3000);
    ConnectFuture cf=connector.connect(new InetSocketAddress("localhost", Common.PORT));
    cf.awaitUninterruptibly();// 等待连接创建完成
    MessageProtocol req=new MessageProtocol();
    req.setTag(Common.Req);
    req.setProtocolNum((short)0x0001);
    DataBuf dataBuf=DataBuf.allocate(1024);
    dataBuf.putString(username);
    dataBuf.putString(password);
    dataBuf.putString(mobileNum);
    dataBuf.flip();
    req.setDataBuf(dataBuf);
    cf.getSession().write(req);
    cf.getSession().getCloseFuture().awaitUninterruptibly();// 等待连接断开
    connector.dispose();
  }

  //   @Test
  public void testLogin() {
    login("test", "test");
  }

  @Test
  public void testRegister() {
    register("test3", "test2", "1234567890222");
  }
}
