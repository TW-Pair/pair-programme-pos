package com.tw.shopping_list;

import java.lang.reflect.Array;
import java.util.*;

import com.tw.goods.GoodsItem;
import com.tw.goodsInformations.Goods;

public class ShoppingList {
  private HashMap<String, GoodsItem> goodsMap = new HashMap<String, GoodsItem>();

  public GoodsItem getGoodItem(String goodsId) {
    if(goodsMap.containsKey(goodsId)) {
      return goodsMap.get(goodsId);
    }
    return null;
  }
  public void addGoodsItem(GoodsItem goodsItem) {
  // 将商品加入购物列
    if(goodsMap.containsKey(goodsItem.getGoods().getBarcode())) {
      int count = goodsMap.get(goodsItem.getGoods().getBarcode()).getAmount();
      goodsMap.get(goodsItem.getGoods().getBarcode()).setAmount(count + goodsItem.getAmount());
    }else {
      goodsMap.put(goodsItem.getGoods().getBarcode(), goodsItem);
    }
  }
  public ArrayList<String> getIdList() {
    Set set = goodsMap.keySet();
    List<String> list = new ArrayList<String>();
    list.addAll(set);
    Collections.sort(list);
    return (ArrayList<String>)list;
//    Set set = goodsMap.entrySet();
//
//    Iterator iterator = set.iterator();
//    ArrayList<String> arrayList = new ArrayList<String>();
//    while (iterator.hasNext()) {
//      Map.Entry entry = (Map.Entry) iterator.next();
//      arrayList.add((String)entry.getKey());
//    }
//    return arrayList;
  }
}
