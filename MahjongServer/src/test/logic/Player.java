package test.logic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Player extends Thread {

  private final byte FENG=0x31;// 番子[东西南北风中发白]

  private List<Byte> jiangPAI=new ArrayList<Byte>();// 将牌

  @Override
  public void run() {
    byte[] b=new byte[]{49, 50, 51, 2, 3, 4, 5, 6, 7, 8, 9, 10, 33, 33};
    long start=System.currentTimeMillis();
    isHU(b);
    long end=System.currentTimeMillis();
    System.out.println("耗时:" + (end - start));
  }

  public boolean isHU(byte[] PAIs) {
    Arrays.sort(PAIs);
    if(hasJiangPAI(PAIs)) {
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
        printArray("除去将牌" + jiang + "后\t", temp);
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
        printArray("分离3同后\t", temp);
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
        printArray("分离3连后\t", temp);
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
   * 是否有将牌?[有将牌才有可能胡，没将牌就不会胡]
   * 
   * @param b
   * @return
   */
  private boolean hasJiangPAI(byte[] b) {
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
      return true;
    } else
      return false;
  }

  private static void printArray(String explain, byte[] b) {
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

  public void setJiangPAI(List<Byte> jiangPAI) {
    this.jiangPAI=jiangPAI;
  }

  public List<Byte> getJiangPAI() {
    return jiangPAI;
  }

  public static void main(String[] args) {
    long start=System.currentTimeMillis();
    for(int i=0; i < 10000; i++) {
      Player p=new Player();
      p.start();
      // try {
      // sleep(10);
      // } catch(InterruptedException e) {
      // // TODO Auto-generated catch block
      // e.printStackTrace();
      // }
    }
    long end=System.currentTimeMillis();
    System.out.println("总共耗时:" + (end - start));
  }
}
