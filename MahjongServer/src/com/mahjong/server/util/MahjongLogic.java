package com.mahjong.server.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * 麻将逻辑处理类
 * 
 * @author Simple
 * @date 2013-3-21 上午11:26:30
 * @Description TODO
 */
public class MahjongLogic {

  private static final byte FENG=0x31;// 番子[东西南北风中发白]

  private static List<Byte> jiangPAI=new ArrayList<Byte>();// 将牌

  private static final int CHI=1;

  private static final int PENG=2;

  private static final int GANG=3;

  /**
   * 一盒麻将
   * 
   * @return
   */
  private byte[] getOneBoxMahjong() {
    byte[] pai=new byte[]{0x01, 0x02, 0x03, 0x04, 0x05, 0x06, 0x07, 0x08, 0x09, // 万（1-9）
      0x01, 0x02, 0x03, 0x04, 0x05, 0x06, 0x07, 0x08, 0x09, // 万
      0x01, 0x02, 0x03, 0x04, 0x05, 0x06, 0x07, 0x08, 0x09, // 万
      0x01, 0x02, 0x03, 0x04, 0x05, 0x06, 0x07, 0x08, 0x09, // 万
      0x11, 0x12, 0x13, 0x14, 0x15, 0x16, 0x17, 0x18, 0x19, // 条（17-25）
      0x11, 0x12, 0x13, 0x14, 0x15, 0x16, 0x17, 0x18, 0x19, // 条
      0x11, 0x12, 0x13, 0x14, 0x15, 0x16, 0x17, 0x18, 0x19, // 条
      0x11, 0x12, 0x13, 0x14, 0x15, 0x16, 0x17, 0x18, 0x19, // 条
      0x21, 0x22, 0x23, 0x24, 0x25, 0x26, 0x27, 0x28, 0x29, // 筒（33-41）
      0x21, 0x22, 0x23, 0x24, 0x25, 0x26, 0x27, 0x28, 0x29, // 筒
      0x21, 0x22, 0x23, 0x24, 0x25, 0x26, 0x27, 0x28, 0x29, // 筒
      0x21, 0x22, 0x23, 0x24, 0x25, 0x26, 0x27, 0x28, 0x29, // 筒
      0x31, 0x32, 0x33, 0x34, 0x35, 0x36, 0x37, // 番子[东西南北中发白]
      0x31, 0x32, 0x33, 0x34, 0x35, 0x36, 0x37, // 番子
      0x31, 0x32, 0x33, 0x34, 0x35, 0x36, 0x37, // 番子
      0x31, 0x32, 0x33, 0x34, 0x35, 0x36, 0x37, // 番子（49-55）
    };
    return pai;
  }

  /**
   * 洗牌和发牌
   */
  public void shuffleAndDeal() {
    byte[] playerA=new byte[14];
    byte[] playerB=new byte[14];
    byte[] playerC=new byte[14];
    byte[] playerD=new byte[14];
    List<byte[]> players=new LinkedList<byte[]>();
    players.add(playerA);
    players.add(playerB);
    players.add(playerC);
    players.add(playerD);
    long start=System.currentTimeMillis();
    byte[] mahjongElements=getOneBoxMahjong();
    int playerCount=0;
    int total=mahjongElements.length;
    int sended=1;
    for(byte[] p: players) {// 发牌
      for(int i=0; i < 14; i++) {
        int random=(int)(Math.random() * (total - sended));
        if(playerCount != 0 && i >= 13) {// 其他
          break;// 不发
        } else {// 庄
          p[i]=mahjongElements[random];
        }
        byte temp=mahjongElements[total - sended];
        mahjongElements[random]=temp;
        mahjongElements[total - sended]=0x00;
        sended++;
      }
      playerCount++;
    }
    long end=System.currentTimeMillis();
    System.out.println("用时:" + (end - start));
    // 每人手中的牌数
    int i=1;
    for(byte[] b: players) {
      System.out.print("玩家" + i + "[");
      for(int j=0; j < b.length; j++) {
        System.out.print(b[j] + ",");
      }
      System.out.print("]");
      System.out.println();
      i++;
    }
    // 剩余牌数
    int ii=0;
    for(int jj=0; jj < mahjongElements.length - 1; jj++) {
      if(mahjongElements[jj] != 0x00) {
        ii++;
      }
    }
    System.out.println("剩余牌数" + ii + "张，具体如下:");
    for(int iii=0; iii < mahjongElements.length; iii++) {
      if(mahjongElements[iii] != 0x00) {
        System.out.print(mahjongElements[iii] + ",");
        if((iii + 1) % 5 == 0) {
          System.out.println();
        }
      }
    }
  }

  /**
   * 是否胡牌?
   * 
   * @param PAIs
   * @return
   */
  public boolean isHU(byte[] PAIs) {
    Arrays.sort(PAIs);
    int jiangSize=getJiangPAI(PAIs);
    if(jiangSize == 7) {
      System.out.println("SUCCESS 7对");
      return true;
    } else if(jiangSize > 0) {
      // 链数
      int linkCount=0;
      // 循环每个可能当将的牌
      for(byte jiang: jiangPAI) {
        byte[] temp=PAIs.clone();
        int jiangSizeTemp=0;
        // 1、去除将牌
        for(int i=0; i < temp.length; i++) {
          if(temp[i] == jiang) {
            temp[i]=0x00;// 将牌置0
            jiangSizeTemp++;
            if(jiangSizeTemp == 2) // 将牌为2张
              break;
          }
        }
        printByteArray("除去将牌" + jiang + "后\t", temp);
        Arrays.sort(temp);
        // 2、分离3同
        for(int i=0; i < temp.length; i++) {// 3同
          if(i > 0 && i < temp.length - 1 && temp[i] > 0) {
            if(temp[i] == temp[i - 1] && temp[i] == temp[i + 1]) {
              temp[i - 1]=0x00;
              temp[i]=0x00;
              temp[i + 1]=0x00;
              linkCount++;
            }
          }
        }
        printByteArray("分离3同后\t", temp);
        Arrays.sort(temp);
        // 3、分离3连
        for(int i=0; i < temp.length; i++) {// 3连
          if(i > 0 && i < temp.length - 1 && temp[i] > 0) {
            if(temp[i + 1] < FENG && temp[i - 1] != 0 && temp[i + 1] != 0 && temp[i] == temp[i - 1] + 1
              && temp[i] == temp[i + 1] - 1) {
              temp[i - 1]=0x00;
              temp[i]=0x00;
              temp[i + 1]=0x00;
              linkCount++;
            }
          }
        }
        printByteArray("分离3连后\t", temp);
        if(linkCount == 4) {
          break;
        } else {
          linkCount=0;
          continue;
        }
      }
      if(linkCount == 4) {
        System.out.println("SUCCESS");
        return true;
      } else {
        System.out.println("FAILD");
        return false;
      }
    } else {
      System.out.println("将牌都没,胡个毛");
      return false;
    }
  }

  /**
   * 获得将牌[有将牌才有可能胡，没将牌就不会胡]
   * 
   * @param b
   * @return
   */
  private int getJiangPAI(byte[] b) {
    // tempMap存放牌值的张数<牌值,张数>
    Map<Byte, Integer> tempMap=new HashMap<Byte, Integer>();
    for(byte value: b) {
      if(tempMap.containsKey(value)) {
        tempMap.put(value, tempMap.get(value) + 1);
      } else {
        tempMap.put(value, 1);
      }
    }
    // 将可能成为将牌的牌值存放到jiangPAI中
    for(Entry<Byte, Integer> e: tempMap.entrySet()) {
      if(e.getValue() >= 2) {
        jiangPAI.add(e.getKey());
      }
    }
    if(jiangPAI.size() > 0) {
      // print
      for(byte i: jiangPAI) {
        System.out.println("将牌:" + i);
      }
      return jiangPAI.size();
    } else
      return 0;
  }

  /**
   * 吃/碰/杠
   * 
   * @param value
   *        打出的牌
   * @param playerx
   *        玩家x的牌
   * @param isNext
   *        是否为出牌者的下家
   * @return
   */
  public int isCPG(byte value, byte[] playerx, boolean isNext) {
    Map<Byte, Integer> temp=new HashMap<Byte, Integer>();
    for(byte b: playerx) {
      if(temp.containsKey(b)) {
        temp.put(b, temp.get(b) + 1);
      } else {
        temp.put(b, 1);
      }
    }
    // 吃
    if(isNext) {
      if((temp.containsKey((byte)(value + 1)) && temp.containsKey((byte)(value + 2)))
        || (temp.containsKey((byte)(value - 1)) && temp.containsKey((byte)(value + 1)))
        || (temp.containsKey((byte)(value - 1)) && temp.containsKey((byte)(value - 2)))) {
        System.out.println("吃");
        return CHI;
      }
    } else {
      // 碰
      if(temp.containsValue(2)) {
        System.out.println("碰");
        return PENG;
      }
      // 杠
      if(temp.containsValue(3)) {
        System.out.println("碰/杠");
        return PENG + GANG;
      }
    }
    System.out.println("毛都没有");
    return 0;
  }

  /**
   * 是否听牌
   * 
   * @param surplus
   *        剩余牌种
   * @param hands
   *        手牌
   * @param x
   *        摸到的牌
   * @return
   */
  public boolean isTING(List<Byte> surplus, byte[] hands, byte x) {
    Map<Byte, Byte> canHU=new HashMap<Byte, Byte>();
    for(int i=0; i < hands.length; i++) {
      byte[] temp=hands.clone();
      temp[i]=x;// 1换13张中的一张
      for(byte sur: surplus) {
        temp[temp.length - 1]=sur;
        if(isHU(temp)) {
          canHU.put(sur, temp[i]);
        }
      }
    }
    Iterator<Entry<Byte, Byte>> it=canHU.entrySet().iterator();
    while(it.hasNext()) {
      Entry<Byte, Byte> entry=it.next();
      System.out.println("可以HU的牌:" + entry.getKey() + "|弃牌:" + entry.getValue());
    }
    if(canHU.size() != 0) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * print
   * 
   * @param explain
   * @param b
   */
  private void printByteArray(String explain, byte[] b) {
    System.out.print(explain + "[");
    for(int i=0; i < b.length; i++) {
      if(i == b.length - 1)
        System.out.print(b[i]);
      else
        System.out.print(b[i] + ",");
    }
    System.out.print("]");
    System.out.println();
  }

  /**
   * test
   * 
   * @param args
   */
  public static void main(String[] args) {
     byte[] b=new byte[]{1, 1, 1, 3, 3, 3, 4, 5, 6, 7, 8, 8, 9};
    // byte[] b=new byte[]{2, 5, 8, 2, 5, 8, 2, 5, 8, 2, 5, 8, 10, 10};
    // byte[] b=new byte[]{2, 2, 2, 2, 4, 4, 4, 4, 6, 6, 6, 6, 8, 8, 8, 8, 10, 10};// 18罗汉 SUCCESS
//     byte[] b=new byte[]{1, 1, 2, 2, 3, 3, 5, 5, 7, 7, 9, 9, 4, 4};
     long start=System.currentTimeMillis();
     new MahjongLogic().isHU(b);
     long end=System.currentTimeMillis();
     System.out.println("耗时:" + (end - start));
    //
    // byte[] next=new byte[]{0x04, 0x04, 0x04, 0x05, 0x06};
    // // new MahjongLogic().isCHI((byte)0x03, next);
    // new MahjongLogic().isCPG((byte)0x04, next, true);
  }

  public void logic() {
    /***
     *server.strart(); init Hall if(玩家连接服务器){ if(isFirst){ 记录玩家信息 }else{ 获得玩家信息 } if(玩家进入大厅){ 获取ROOM列表 } if(进入ROOM){
     * 初始化ROOM，遍历状态，开是否开局 } if(如果都处于准备状态，开局){ 洗牌，发牌，走牌 if(有人hu){ 结束，算分。 } } }else{
     * 
     *}
     */
    //
    //
    //
    //
    // 玩家选择ROOM进入
  }
}
