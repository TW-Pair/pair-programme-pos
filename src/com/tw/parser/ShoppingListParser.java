package com.tw.parser;

import com.tw.identify.ShoppingList;
import org.json.JSONArray;
import org.json.JSONTokener;

import java.awt.print.PageFormat;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ShoppingListParser {

  public ShoppingList parse(String filePath) {
    ShoppingList shoppingList = new ShoppingList();
    try {
      FileInputStream fileInputStream = new FileInputStream(filePath);
      JSONTokener jsonTokener = new JSONTokener(fileInputStream);
      JSONArray jsonArray = new JSONArray(jsonTokener);
      String itemInfo;

      for(int i = 0; i < jsonArray.length(); i++) {
        itemInfo = jsonArray.getString(i);
        shoppingList.addGoodsItem(parseId(itemInfo), parseNum(itemInfo));
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    return shoppingList;
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
