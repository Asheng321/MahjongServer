package com.mahjong.server.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mahjong.server.dao.GameDao;
import com.mahjong.server.service.GameService;

@Service
public class GameServiceImpl implements GameService {

  @Resource
  private GameDao gameDao;

  public void sitDown() {
    // TODO Auto-generated method stub
    gameDao.sitDown();
  }
}
