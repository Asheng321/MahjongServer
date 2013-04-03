package com.mahjong.server.mina.server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.charset.Charset;

import org.apache.log4j.Logger;
import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mahjong.server.common.Common;
import com.mahjong.server.mina.codec.ServerMessageProtocolCodecFactory;
import com.mahjong.server.mina.handler.MinaServerHandler;

/**
 * 
 * @author Simple
 * @date 2013-3-5 上午10:59:11
 * @Description Mina服务器端
 */
@Service
public class MinaServer implements InitializingBean {

  private Logger log=Logger.getLogger(MinaServer.class);

  private NioSocketAcceptor acceptor;

  @Autowired
  private MinaServerHandler minaServerHandler;

  private void startServer() {
    acceptor=new NioSocketAcceptor();
    DefaultIoFilterChainBuilder filterChain=acceptor.getFilterChain();// 过滤链
    filterChain.addLast("serverFilter", new ProtocolCodecFilter(new ServerMessageProtocolCodecFactory(Charset.forName("utf-8"))));// 添加filter
    acceptor.setHandler(minaServerHandler);// handler
    try {
      acceptor.bind(new InetSocketAddress(Common.PORT));
    } catch(IOException e) {
      e.printStackTrace();
    }
    log.debug("MinaServer started @ " + Common.PORT);
  }

  public void afterPropertiesSet() throws Exception {
    startServer();
  }
}
