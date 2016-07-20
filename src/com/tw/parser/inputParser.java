package com.tw.parser;

import com.tw.shopping_list.ShoppingList;
import org.json.JSONArray;
import org.json.JSONTokener;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;

public class InputParser {

  public HashMap<String, Integer> parse(String filePath) {
    HashMap<String, Integer> inputMap = new HashMap<String, Integer>();
    try {
      FileInputStream fileInputStream = new FileInputStream(filePath);
      JSONTokener jsonTokener = new JSONTokener(fileInputStream);
      JSONArray jsonArray = new JSONArray(jsonTokener);
      String itemInfo;

      for(int i = 0; i < jsonArray.length(); i++) {
        itemInfo = jsonArray.getString(i);
        String id = parseId(itemInfo);
        if(inputMap.containsKey(id)) {
          int count = inputMap.get(id);
          count += parseNum(itemInfo);
          inputMap.put(id, count);
        }else {
          inputMap.put(id, parseNum(itemInfo));
        }
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    return inputMap;
  }

  public String parseId(String barcode) {
    String str[] = barcode.split("-");
    return str[0];
  }

  public int parseNum(String barcode) {
    String str[] = barcode.split("-");
    if(str.length == 1){
      return 1;
    }
    return Integer.parseInt(str[1]);
  }
}
