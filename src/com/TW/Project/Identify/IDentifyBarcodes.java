package com.TW.Project.Identify;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface IDentifyBarcodes {
  //将条码数组转化为<条码, 数量>键值对EntrySet的数组
  public List<Map.Entry<String, Integer>> identifyBarcodes(String[] barcodes);

}
