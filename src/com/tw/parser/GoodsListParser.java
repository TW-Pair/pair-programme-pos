package com.tw.parser;

import com.tw.goodsInformations.Goods;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.FileInputStream;
import java.util.HashMap;

public class GoodsListParser {
  public HashMap<String,Goods> parseGoodsList(String json_path) {
    HashMap<String, Goods> goodsMaps = new HashMap<String, Goods>();
    try {
      FileInputStream fileInputStream = new FileInputStream(json_path);
      JSONTokener jsonTokener = new JSONTokener(fileInputStream);
      JSONArray jsonArray = new JSONArray(jsonTokener);
      for(int i = 0; i < jsonArray.length(); i++) {
        HashMap<String,String> goodsMap = new HashMap<String, String>();
        JSONObject jsonObject = jsonArray.getJSONObject(i);
        String barcode = jsonObject.getString("barcode");
        String name = jsonObject.getString("name");
        String unit = jsonObject.getString("unit");
        String category = jsonObject.getString("category");
        String subCategory = jsonObject.getString("subCategory");
        String price = jsonObject.getString("price");

        Goods goods = new Goods(barcode, name, unit, category, subCategory, price);
        goodsMaps.put(barcode, goods);
//        goodsMap.put("barcode", jsonObject.getString("barcode"));
//        goodsMap.put("name", jsonObject.getString("name"));
//        goodsMap.put("unit", jsonObject.getString("unit"));
//        goodsMap.put("category", jsonObject.getString("category"));
//        goodsMap.put("subCategory", jsonObject.getString("subCategory"));
//        goodsMap.put("price", jsonObject.getString("price"));
//        goodsMaps.put(jsonObject.getString("barcode"), goodsMap);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return goodsMaps;
  }
}
