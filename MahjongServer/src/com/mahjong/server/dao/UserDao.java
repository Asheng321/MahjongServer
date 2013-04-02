package com.mahjong.server.dao;

import java.util.List;

import com.mahjong.server.model.User;

/**
 * 
 * @author Simple
 * @date 2013-3-28 下午03:33:03
 * @Description TODO
 */
public interface UserDao {

  public void save(User user);

  public User login(String username, String password);
  
  public List<User> getAllUser();
}
