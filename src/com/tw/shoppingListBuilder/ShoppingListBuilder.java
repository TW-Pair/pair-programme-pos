package com.tw.shoppingListBuilder;

import com.tw.goods.GoodsItem;
import com.tw.goodsInformations.Goods;
import com.tw.parser.GoodsListParser;
import com.tw.parser.InputParser;
import com.tw.parser.PrivilegeParser;
import com.tw.shopping_list.*;

import java.util.*;


public class ShoppingListBuilder {
  public ShoppingList factory(String goods_path, String input_path, String priv_path) {
    ShoppingList shoppingList = new ShoppingList();
    GoodsListParser goodsListParser = new GoodsListParser();
    InputParser inputParser = new InputParser();
    PrivilegeParser privilegeParser = new PrivilegeParser();

    HashMap<String, Integer> inputMap = inputParser.parse(input_path);
    HashMap<String, Goods> goodsMap = goodsListParser.parseGoodsList(goods_path);
    HashMap<String, String[]> privMap = privilegeParser.parser(priv_path);

    Iterator iterator = inputMap.entrySet().iterator();
    while (iterator.hasNext()) {
      Map.Entry entry = (Map.Entry)iterator.next();
      String barcode = (String)entry.getKey();
      int amount = inputMap.get(barcode);


      if(goodsMap.containsKey(barcode)) {
        Goods goods = goodsMap.get(barcode);
        ArrayList<String> priv_info = producePriv_info(barcode, privMap);
        GoodsItem goodsItem = new GoodsItem(goods, amount, priv_info);
        shoppingList.addGoodsItem(goodsItem);
      }
    }
    return shoppingList;
  }

  public ArrayList<String> producePriv_info(String barcode, HashMap<String, String[]> privMap) {
    Set set = privMap.keySet();
    ArrayList<String> priv_infos = new ArrayList<String>();
    ArrayList<String> priv_info = new ArrayList<String>();
    priv_infos.addAll(set);
    for(int i = 0; i < priv_infos.size(); i++) {
      String[] privs = privMap.get(priv_infos.get(i));
      for(String priv : privs) {
        if(priv.equals(barcode)) {
          priv_info.add(priv_infos.get(i));
          continue;
        }
      }
    }
    return priv_info;
  }

}
