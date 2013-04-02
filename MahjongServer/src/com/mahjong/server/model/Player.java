package com.mahjong.server.model;

import java.util.LinkedList;
import java.util.List;

import org.apache.mina.core.session.IoSession;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * 玩家类，把User封装为一个Player，可看做是一个客户端，可进行交互
 * 
 * @author Simple
 * @date 2013-3-13 下午04:40:06
 * @Description TODO
 */
@Component(value="player")
@Scope("prototype")
public class Player {

  private int id;

  private User user;

  private int roomId;// 房间id

  private int status;// 状态

  private int position;// 位置

  // @Transient声明，相当于临时变量，不参与入库
  private List<Integer> mjData=new LinkedList<Integer>();// 麻将数据

  private IoSession session;// sessionId;

  public Player() {
    // TODO Auto-generated constructor stub
  }

  public Player(IoSession session) {
    this.setSession(session);
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id=id;
  }

  public int getRoomId() {
    return roomId;
  }

  public void setRoomId(int roomId) {
    this.roomId=roomId;
  }

  public int getStatus() {
    return status;
  }

  public void setStatus(int status) {
    this.status=status;
  }

  public int getPosition() {
    return position;
  }

  public void setPosition(int position) {
    this.position=position;
  }

  public List<Integer> getMjData() {
    return mjData;
  }

  public void setMjData(List<Integer> mjData) {
    this.mjData=mjData;
  }

  public void setSession(IoSession session) {
    this.session=session;
  }

  public IoSession getSession() {
    return session;
  }

  public void setUser(User user) {
    this.user=user;
  }

  public User getUser() {
    return user;
  }
}
