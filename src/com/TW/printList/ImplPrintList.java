package com.tw.printList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/7/8.
 */
public class ImplPrintList implements PrintList {
  public void printList(List<Map.Entry<String, Integer>> list) {
    HashMap<String, Integer> hm = new HashMap();
    hm.put("mm", 100);
    System.out.print(hm.get("mm"));
  }

  public static void main(String[] args) {
    HashMap<String, Integer> hm = new HashMap();
    hm.put("mm", 100);
    System.out.print(hm.get("mm"));
  }
}
