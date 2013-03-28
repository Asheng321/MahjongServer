package com.mahjong.server.common;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

/**
 * 
 * @author Simple
 * @date 2013-3-28 下午03:33:48
 * @Description TODO
 */
@Repository
public class BaseDao {

  @Resource(name="sessionFactory")
  private SessionFactory sessionFactory;

  public void setSessionFactory(SessionFactory sessionFactory) {
    this.sessionFactory=sessionFactory;
  }

  public SessionFactory getSessionFactory() {
    return sessionFactory;
  }

  protected Session getSession() {
    return sessionFactory.getCurrentSession();
  }

  protected void save(Object obj) {
    getSession().save(obj);
  }

  protected void update(Object obj) {
    getSession().update(obj);
  }

  protected void delete(Object obj) {
    getSession().delete(obj);
  }

  @SuppressWarnings("unchecked")
  protected void deleteById(Class clazz, int id) {
    getSession().delete(get(clazz, id));
  }

  @SuppressWarnings("unchecked")
  protected <T> T get(Class<T> clazz, int id) {
    return (T)getSession().get(clazz, id);
  }

  @SuppressWarnings("unchecked")
  protected <T> List<T> findAll(Class<T> clazz) {
    return getSession().createCriteria(clazz).list();
  }
}
