package com.mahjong.server.service;

import java.util.List;

import com.mahjong.server.model.Room;

public interface GameService {

  public void sitDown();

  public List<Room> getRooms();
  
  public List<Room> getRooms(int size);
}
