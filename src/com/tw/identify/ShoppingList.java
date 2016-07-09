package com.tw.identify;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

import com.tw.goods.GoodsItem;
import org.json.*;

public class ShoppingList {
  private HashMap<String, GoodsItem> goodsMap = new HashMap<String, GoodsItem>();

  public GoodsItem getGoodItem(String goodsId) {
    return new GoodsItem(0, "");
  }

  public void addGoodsItem(String goodsId, int amount) {
  // 将商品加入购物列
  }
}
