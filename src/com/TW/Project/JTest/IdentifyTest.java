package com.TW.Project.JTest;

import com.TW.Project.GoodsInformations.GoodsInformation;
import com.TW.Project.Identify.IDentifyBarcodes;
import com.TW.Project.Identify.ImplIdentifyBarcodes;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

import java.lang.reflect.Array;
import java.util.*;

public class IdentifyTest {
  @Test
  public void testIdentifyBarcodes() {
    HashMap<String, Integer> hm = new HashMap<String, Integer>();
    hm.put("ITEM000001", 2);
    hm.put("ITEM000003", 3);
    hm.put("ITEM000002", 4);

    List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(hm.entrySet());
    Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
      public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
        return o1.getKey().toString().compareTo(o2.getKey());
      }
    });

    String[] strs = new String[]{"ITEM000001-2", "ITEM000002-4", "ITEM000003-3"};

    assertEquals("notEquals",list, new ImplIdentifyBarcodes().identifyBarcodes(strs));


  }

}
