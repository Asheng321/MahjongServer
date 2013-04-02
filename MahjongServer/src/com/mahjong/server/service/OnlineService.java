package com.mahjong.server.service;

import java.util.List;

import com.mahjong.server.model.Player;

public interface OnlineService {

  /**
   * 加入在线列表
   */
  public void addOnline(Player player);

  /**
   * 从在线列表移除
   */
  public void removeOnline(Player player);

  /**
   * 获取所有在线玩家
   */
  public List<Player> getAllOnlinePlayer();

  public Player getByName(String username);

  public Player getById(int id);
}
