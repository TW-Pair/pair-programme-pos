package com.tw.privilege;

import com.tw.calculate.Calculate;
import com.tw.goods.GoodsItem;
import com.tw.shopping_list.ShoppingList;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;

public class Privilege {

  public double privilege(String type, GoodsItem goodsItem) {
    Calculate calculate = new Calculate();
    if(type.equals("Discount")) {
      return calculate.calculate(goodsItem.getAmount(), Double.parseDouble(goodsItem.getGoods().getPrice()), 0.95);
    }else if(type.equals("ThreeSendOne")) {
      return calculate.calculate(PrivAcountByThreeSendOne(goodsItem.getAmount()), Double.parseDouble(goodsItem.getGoods().getPrice()), 1);
    }
    return goodsItem.getOriginal_count();
  }
  public int PrivAcountByThreeSendOne(int acount) {
    if(acount <= 2) {
      return acount;
    }
    return acount - acount / 3;
  }

  public String identifyPrivilegeType(GoodsItem goodsItem) {
    ArrayList<String> priv_info = goodsItem.getPriv_info();
    for(String type : priv_info) {
      if(type.equals("ThreeSendOne")) {
        return "ThreeSendOne";
      }
    }
    for(String type : priv_info) {
      if(type.equals("Discount")) {
        return "Discount";
      }
    }
    return "";
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

  public boolean isPrivGoods(GoodsItem goodsItem) {
    String type = identifyPrivilegeType(goodsItem);
    if(type.equals("Discount")) {
      if(goodsItem.getAmount() >= 10) {
        return true;
      }
    } else if(type.equals("ThreeSendOne")) {
      if(goodsItem.getAmount() > 2) {
        return true;
      }
    }
    return false;
  }
}
