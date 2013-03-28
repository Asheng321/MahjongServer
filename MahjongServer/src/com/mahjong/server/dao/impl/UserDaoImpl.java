package com.mahjong.server.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.mahjong.server.common.BaseDao;
import com.mahjong.server.dao.UserDao;
import com.mahjong.server.model.User;

/**
 * 
 * @author Simple
 * @date 2013-3-28 下午03:33:07
 * @Description TODO
 */
@Repository
public class UserDaoImpl extends BaseDao implements UserDao {

  @SuppressWarnings("unchecked")
  public User login(String username, String password) {
    Criteria ca=super.getSession().createCriteria(User.class);
    ca.add(Restrictions.eq("username", username));
    ca.add(Restrictions.eq("password", password));
    List<User> list=ca.list();
    return list.size() > 0 ? list.get(0) : null;
  }

  public void save(User user) {
    super.save(user);
  }
}
