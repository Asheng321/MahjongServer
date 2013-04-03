package com.mahjong.server.manager;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.mina.core.session.IoSession;
import org.springframework.stereotype.Component;

import com.mahjong.server.model.Player;

/**
 * 在线管理
 * 
 * @author Simple
 * @date 2013-4-2 上午10:59:07
 * @Description TODO
 */
@Component
public class OnlineManager {

  // 在线玩家列表
  public List<Player> onlinePlayers=new LinkedList<Player>();

  // 用户名-玩家映射
  public Map<String, Player> username2player=new ConcurrentHashMap<String, Player>();

  public void addOnline(Player player) {
    this.onlinePlayers.add(player);
    this.username2player.put(player.getUser().getUsername(), player);
  }

  public Player getById(int id) {
    for(Player p: this.onlinePlayers) {
      if(p.getId() == id) {
        return p;
      }
    }
    return null;
  }

  public Player getByName(String username) {
    return this.username2player.get(username);
  }

  public List<Player> getAllOnlinePlayer() {
    return this.onlinePlayers;
  }

  public void removeOnline(Player player) {
    this.onlinePlayers.remove(player);
    this.username2player.remove(player.getUser().getUsername());
  }

  public Player getBySession(IoSession session) {
    for(Player p: onlinePlayers) {
      if(p.getSession().getId() == session.getId()) {
        return p;
      }
    }
    return null;
  }
}
