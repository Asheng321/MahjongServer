package com.mahjong.server.mina.protocol;

public abstract class AbsMessageProtocol implements IMessageProtocol {

  private byte tag;// tag

  public void setTag(byte tag) {
    this.tag=tag;
  }

  public byte getTag() {
    return tag;
  }

  public abstract int getLength();// length

  private short protocolNum;// 协议号

  public void setProtocolNum(short protocolNum) {
    this.protocolNum=protocolNum;
  }

  public short getProtocolNum() {
    return protocolNum;
  }

  private DataBuf dataBuf;// 数据buf

  public void setDataBuf(DataBuf dataBuf) {
    this.dataBuf=dataBuf;
  }

  public DataBuf getDataBuf() {
    return dataBuf;
  }
}
