package com.mahjong.server.model;

import java.util.LinkedList;
import java.util.List;

/**
 * 房间类，对一个房间的玩家进行封装，以便各个玩家之间数据交互
 * 
 * @author Simple
 * @date 2013-3-13 下午04:15:51
 * @Description TODO
 */
public class Room {

  private int id;

  private List<Player> players=new LinkedList<Player>();// 玩家
  
  private String name;// 房间名
  
  private String password;// 房间密码
  
  private int playerCount;// 玩家人数
  
  private int totalCount;// 总人数
  
  private int status;// 本桌状态

  private List<Integer> mj=new LinkedList<Integer>();// 一盒麻将

  public Room() {
    for(int i=0; i < 136; i++) {
      mj.add(i);
    }
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id=id;
  }

  public List<Player> getPlayers() {
    return players;
  }

  public void setPlayers(List<Player> players) {
    this.players=players;
  }

  public int getStatus() {
    return status;
  }

  public void setStatus(int status) {
    this.status=status;
  }

  public int getPlayerCount() {
    return playerCount;
  }

  public void setPlayerCount(int playerCount) {
    this.playerCount=playerCount;
  }

  public void setMj(List<Integer> mj) {
    this.mj=mj;
  }

  public List<Integer> getMj() {
    return mj;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getPassword() {
    return password;
  }

  public void setTotalCount(int totalCount) {
    this.totalCount = totalCount;
  }

  public int getTotalCount() {
    return totalCount;
  }
}
