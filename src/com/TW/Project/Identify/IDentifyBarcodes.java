package com.TW.Project.Identify;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface IDentifyBarcodes {
  public List<Map.Entry<String, Integer>> identifyBarcodes(String[] barcodes);

}
