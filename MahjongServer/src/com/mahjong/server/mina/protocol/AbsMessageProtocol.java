package com.mahjong.server.mina.protocol;


public abstract class AbsMessageProtocol implements IMessageProtocol {

  /**
   * Tag
   */
  private byte tag;

  public void setTag(byte tag) {
    this.tag=tag;
  }

  public byte getTag() {
    return tag;
  }

  /**
   * Length
   */
  public abstract int getLength();

  /**
   * 协议号
   */
  private short protocolNum;

  public void setProtocolNum(short protocolNum) {
    this.protocolNum=protocolNum;
  }

  public short getProtocolNum() {
    return protocolNum;
  }

  /**
   * 数据buf
   */
  private DataBuf dataBuf;

  public void setDataBuf(DataBuf dataBuf) {
    this.dataBuf=dataBuf;
  }

  public DataBuf getDataBuf() {
    return dataBuf;
  }

  // /**
  // * 当前玩家
  // */
  // private Player player;
  //
  // public Player getPlayer() {
  // return this.player;
  // }
  //
  // public void setPlayer(Player player) {
  // this.player=player;
  // }
}
