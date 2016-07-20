package com.tw.privilege;

import com.tw.goods.GoodsItem;
import com.tw.shopping_list.ShoppingList;

import java.util.ArrayList;
import java.util.HashMap;

public class Privilege {

  public double doPrivilege(String type, GoodsItem goodsItem) {
    int amount = goodsItem.getAmount();
    double price = Double.parseDouble(goodsItem.getGoods().getPrice());
    if(type.equals("Discount") && amount >= 10) {
      double total = Math.round((0.95 * amount * price) * 100) * 0.01d;
      return total;
    }
    return amount * price;
  }

  public boolean hasPrivGoods(String[] priv_list, ShoppingList shoppingList) {
    for(String barcode : shoppingList.getIdList()) {
      GoodsItem goodsItem = shoppingList.getGoodItem(barcode);
      int count = goodsItem.getAmount();
      for(String privId : priv_list) {
        if(barcode.equals(privId) && count >= 10) {
          return true;
        }
      }
    }
    return false;
  }

  public boolean isPrivGoods(String[] priv_list, String barcode) {
    for(String priv_Id : priv_list) {
      if(priv_Id.equals(barcode)) {
        return true;
      }
    }
    return false;
  }
}
