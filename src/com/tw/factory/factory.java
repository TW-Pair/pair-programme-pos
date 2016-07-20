package com.tw.factory;

import com.tw.goods.GoodsItem;
import com.tw.goodsInformations.Goods;
import com.tw.parser.GoodsListParser;
import com.tw.parser.InputParser;
import com.tw.shopping_list.*;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


public class Factory {
  public ShoppingList factory(String goods_path, String input_path) {
    ShoppingList shoppingList = new ShoppingList();
    GoodsListParser goodsListParser = new GoodsListParser();
    InputParser inputParser = new InputParser();
    HashMap<String, Integer> inputMap = inputParser.parse(input_path);
    HashMap<String, Goods> goodsMap = goodsListParser.parseGoodsList(goods_path);

    Iterator iterator = inputMap.entrySet().iterator();
    while (iterator.hasNext()) {
      Map.Entry entry = (Map.Entry)iterator.next();
      String barcode = (String)entry.getKey();
      int amount = inputMap.get(barcode);


      if(goodsMap.containsKey(barcode)) {
        Goods goods = goodsMap.get(barcode);
        GoodsItem goodsItem = new GoodsItem(goods, amount);
        shoppingList.addGoodsItem(goodsItem);
      }
    }
    return shoppingList;
  }
}
