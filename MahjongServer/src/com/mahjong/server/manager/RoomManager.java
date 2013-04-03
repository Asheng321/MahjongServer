package com.mahjong.server.manager;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import com.mahjong.server.model.Room;

/**
 * 游戏管理
 * @author Simple
 * @date 2013-4-3 下午03:55:04
 * @Description TODO
 */
@Component
public class RoomManager implements InitializingBean {

  private Logger log=Logger.getLogger(this.getClass());

  // 房间id
  private static int roomId;

  // 所有房间列表
  public static List<Room> rooms=new LinkedList<Room>();

  // id-Room
  public static Map<Integer, Room> id2room=new ConcurrentHashMap<Integer, Room>();

  /**
   * 初始化房间
   */
  public void initRooms() {
    log.debug("init ROOMS");
    for(int i=0; i < 50; i++) {
      Room room=new Room();
      room.setId(roomId++);
      room.setName("computer" + (i + 1));
      room.setStatus(0);
      room.setTotalCount(4);
      rooms.add(room);
      id2room.put(room.getId(), room);
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

  public Room getRoomById(int id) {
    return id2room.get(id);
  }
}
