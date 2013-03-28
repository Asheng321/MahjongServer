package com.mahjong.server.service;

import com.mahjong.server.model.User;
/**
 * 用户接口
 * @author Simple
 * @date 2013-3-28 下午03:31:52
 * @Description TODO
 */
public interface UserService {

  public void save(User user);

  public User login(String username, String password);
}
