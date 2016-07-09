package com.tw.printList;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/7/8.
 */
public interface PrintList {
  //输出清单详情
  public void printList(List<Map.Entry<String, Integer>> list);
}
