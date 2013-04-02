package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import junit.framework.Assert;

import org.junit.Test;

public class TestDemo {

  private static List<Byte> jiangPAI=new ArrayList<Byte>();// 将牌

  private static final byte FENG=0x31;// 番子[东西南北风中发白]

  byte[] noRepeatPai=new byte[]{0x01, 0x02, 0x03, 0x04, 0x05, 0x06, 0x07, 0x08, 0x09, // 万（1-9）
    0x11, 0x12, 0x13, 0x14, 0x15, 0x16, 0x17, 0x18, 0x19, // 条（17-25）
    0x21, 0x22, 0x23, 0x24, 0x25, 0x26, 0x27, 0x28, 0x29, // 筒（33-41）
    0x31, 0x32, 0x33, 0x34, 0x35, 0x36, 0x37, // 番子[东西南北中发白]
  };

  @Test
  public void testTING() {
    long start=System.currentTimeMillis();
    byte[] hands=new byte[]{0x01, 0x02, 0x03, 0x11, 0x12, 0x13, 0x21, 0x22, 0x23, 0x07, 0x08, 0x04, 0x04};
    byte x=0x35;
    boolean result=isTing(hands, x);
    long end=System.currentTimeMillis();
    System.out.println("耗时:" + (end - start));
    Assert.assertTrue(result);
  }

  // @Test
  public void testCPG() {
    byte[] next=new byte[]{0x04, 0x04, 0x04, 0x05, 0x06};
    int result=new MahjongLogic().isCPG((byte)0x04, next, true);
    Assert.assertEquals(result, 1);
  }

  // @Test
  public void testHU() {
    // byte[] b=new byte[]{1, 1, 1, 3, 3, 3, 4, 5, 6, 7, 8, 8, 9, 10};
    // byte[] b=new byte[]{2, 5, 8, 2, 5, 8, 2, 5, 8, 2, 5, 8, 10, 10};
    // byte[] b=new byte[]{2, 2, 2, 2, 4, 4, 4, 4, 6, 6, 6, 6, 8, 8, 8, 8, 10, 10};// 18罗汉 SUCCESS
    byte[] b=new byte[]{1, 1, 2, 2, 3, 3, 5, 5, 7, 7, 9, 9, 4, 4};// 7连对
    long start=System.currentTimeMillis();
    boolean result=new MahjongLogic().isHU(b);
    long end=System.currentTimeMillis();
    System.out.println("耗时:" + (end - start));
    Assert.assertTrue(result);
  }

  public boolean isTing(byte[] hands, byte mo) {
    @SuppressWarnings("unused")
    byte[] handsBak=hands.clone();// 保留一份手牌
    //
    // hands[hands.length - 1]=mo;// 自摸牌加入手牌中
    // 
    Arrays.sort(hands);
    int jiangSize=getJiangPAI(hands);
    if(jiangSize == 7) {
      System.out.println("SUCCESS 7对");
      return true;
    } else if(jiangSize > 0) {
      // 链数
      int linkCount=0;
      // 循环每个可能当将的牌
      for(byte jiang: jiangPAI) {
        byte[] temp=hands.clone();
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
        // 1
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
        // 2
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
        // 3
        if(linkCount == 3) {
          // 有希望胡
          Arrays.sort(temp);
          byte[] ting=temp.clone();
          printByteArray("ting", ting);
          ArrayList<Byte> arrayList=byte2ArrayList(ting);
          int size=arrayList.size();
          @SuppressWarnings("unused")
          int tempValue=-1;
          for(int i=0; i < arrayList.size(); i++) {
            arrayList.set(i, mo);
            for(byte b: noRepeatPai) {
              ArrayList<Byte> tempArrayList=arrayList;
              for(byte bb: tempArrayList) {
                System.out.print("-" + bb + "-");
              }
              if(size == 2) {
                tempArrayList.add(b);
                tempValue=b;
                Collections.sort(tempArrayList);
                if((tempArrayList.get(0) + 1) == tempArrayList.get(1) && (tempArrayList.get(2) - 1) == tempArrayList.get(1)) {
                  System.out.println("3连听" + b);
                }
              } else if(size == 1) {
                tempArrayList.add(b);
                Collections.sort(tempArrayList);
                tempValue=b;
                if(tempArrayList.get(0) == tempArrayList.get(1)) {
                  System.out.println("对子听" + b);
                }
              }
            }
          }
        }
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

  public ArrayList<Byte> byte2ArrayList(byte[] obj) {
    ArrayList<Byte> arrayList=new ArrayList<Byte>();
    for(byte b: obj) {
      if(b != 0)
        arrayList.add(b);
    }
    return arrayList;
  }
}
