package com.tw.privilege;


import java.util.List;
import java.util.Map;

public interface PrintPrivilege {
  //打折方法
  public double privilege(int num, double price);
  //判断全部商品里是否有打折商品
  public boolean isPrivilegeList(List<Map.Entry<String, Integer>> list);
  //判断该商品是否为打折商品
  public boolean isPrivilege(String barcode);
  //计算打折商品数量并输出
  public void totalPrivilegeNumber(List<Map.Entry<String, Integer>> list);
  //单品打折优惠
  public void singlePricilege(int num, double price, double priv);
  //总优惠
  public void totalPrivilege(double oriprice, double privprice);
}
