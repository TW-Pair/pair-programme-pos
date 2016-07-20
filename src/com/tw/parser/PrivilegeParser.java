package com.tw.parser;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.omg.CORBA.portable.InputStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Iterator;

public class PrivilegeParser {
  public HashMap<String, String[]> parser(String file_path) {
    HashMap<String, String[]> privMap = new HashMap<String, String[]>();
    String key;
    String[] barcodes;
    try {
      FileInputStream inputStream = new FileInputStream(file_path);
      JSONTokener jsonTokener = new JSONTokener(inputStream);
      JSONArray jsonArray = new JSONArray(jsonTokener);
      for(int i = 0; i < jsonArray.length(); i++) {
        JSONObject jsonObject = jsonArray.getJSONObject(i);
        Iterator iterator = jsonObject.keys();
        while(iterator.hasNext()) {
          if(iterator.next().toString().equals("type"));
          key = jsonObject.get("type").toString();
          if(iterator.next().toString().equals("barcodes")) {
            JSONArray priv_Id = jsonObject.getJSONArray("barcodes");
            barcodes = new String[priv_Id.length()];
            for(int j = 0; j < priv_Id.length(); j++) {
              barcodes[j] = priv_Id.get(j).toString();
            }
            privMap.put(key, barcodes);
          }
        }
      }
      return privMap;
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    return null;
  }
}
