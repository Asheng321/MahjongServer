package com.mahjong.server.service.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Service;

import com.mahjong.server.model.Player;
import com.mahjong.server.service.OnlineService;

/**
 * 在线管理
 * 
 * @author Simple
 * @date 2013-4-2 上午10:59:07
 * @Description TODO
 */
@Service
public class OnlineServiceImpl implements OnlineService {

  // 在线玩家列表
  private List<Player> onlinePlayers=new LinkedList<Player>();

  // 用户名-玩家映射
  private Map<String, Player> username2player=new ConcurrentHashMap<String, Player>();

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
}
