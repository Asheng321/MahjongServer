package com.mahjong.server.mina.protocol;

import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;

import org.apache.mina.core.buffer.IoBuffer;

/**
 * 
 * @author Simple
 * @date 2013-3-5 上午10:58:49
 * @Description 数据区BUF(对IoBuffer的封装)，主要用来在protocolHandler中解析数据
 */
public class DataBuf {

  public static final int STRING_LENTH=2;

  protected Charset charset=Charset.forName("UTF-16BE");

  protected CharsetEncoder charsetEncoder=charset.newEncoder();

  protected CharsetDecoder charsetDecoder=charset.newDecoder();

  private IoBuffer buf;

  public DataBuf() {
  }

  public DataBuf(int size, IoBuffer buf) {
    allocate(size);
    this.setBuf(buf);
  }

  public static DataBuf allocate(int i) {
    DataBuf dataBuf=new DataBuf();
    dataBuf.setBuf(IoBuffer.allocate(i));
    dataBuf.getBuf().setAutoExpand(true);
    return dataBuf;
  }

  public String getString() {
    try {
      return getBuf().getPrefixedString(STRING_LENTH, charsetDecoder);
    } catch(CharacterCodingException e) {
      e.printStackTrace();
    }
    return null;
  }

  public DataBuf putString(String s) {
    if(s == null)
      return this;
    try {
      getBuf().putPrefixedString(s, STRING_LENTH, charsetEncoder);
    } catch(CharacterCodingException e) {
      e.printStackTrace();
    }
    return this;
  }

  public byte get() {
    return getBuf().get();
  }

  public DataBuf put(byte b) {
    getBuf().put(b);
    return this;
  }

  public short getShort() {
    return getBuf().getShort();
  }

  public DataBuf putShort(short s) {
    getBuf().putShort(s);
    return this;
  }

  public int getInt() {
    return getBuf().getInt();
  }

  public DataBuf putInt(int i) {
    getBuf().putInt(i);
    return this;
  }

  public long getLong() {
    return getBuf().getLong();
  }

  public DataBuf putLong(long l) {
    getBuf().putLong(l);
    return this;
  }

  public float getFloat() {
    return getBuf().getFloat();
  }

  public DataBuf putInt(float f) {
    getBuf().putFloat(f);
    return this;
  }

  public double getDouble() {
    return getBuf().getDouble();
  }

  public DataBuf putDouble(double d) {
    getBuf().putDouble(d);
    return this;
  }

  public void setBuf(IoBuffer buf) {
    this.buf=buf;
  }

  public IoBuffer getBuf() {
    return buf;
  }

  public DataBuf flip() {
    buf.flip();
    return this;
  }
}
