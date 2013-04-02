package com.mahjong.server.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 用户
 * 
 * @author Simple
 * @date 2013-3-13 下午04:17:37
 * @Description TODO
 */
@Entity
public class User {

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private int id;

  private String username;

  private String password;

  private String mobileNum;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id=id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username=username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password=password;
  }

  public void setMobileNum(String mobileNum) {
    this.mobileNum = mobileNum;
  }

  public String getMobileNum() {
    return mobileNum;
  }

}
