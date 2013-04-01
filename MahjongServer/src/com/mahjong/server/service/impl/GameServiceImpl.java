package com.mahjong.server.service.impl;

import java.util.LinkedList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import com.mahjong.server.dao.GameDao;
import com.mahjong.server.model.Room;
import com.mahjong.server.service.GameService;

@Service
public class GameServiceImpl implements GameService, InitializingBean {

  private Logger log=Logger.getLogger(this.getClass());

  @Resource
  private GameDao gameDao;

  private static List<Room> rooms=new LinkedList<Room>();

  public void sitDown() {
    // TODO Auto-generated method stub
    gameDao.sitDown();
  }

  /**
   * 初始化房间
   */
  public void initRooms() {
    log.debug("init ROOMS");
    for(int i=0; i < 50; i++) {
      Room room=new Room();
      room.setName("computer" + (i + 1));
      room.setStatus(0);
      room.setTotalCount(4);
      rooms.add(room);
    }
  }

  public List<Room> getRooms() {
    return rooms;
  }

  public void afterPropertiesSet() throws Exception {
    initRooms();
  }

  public List<Room> getRooms(int size) {
    List<Room> temp=new LinkedList<Room>();
    for(int i=0; i < size; i++) {
      temp.add(rooms.get(i));
    }
    return temp;
  }
}
