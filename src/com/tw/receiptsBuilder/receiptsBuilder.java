package com.tw.receiptsBuilder;

import com.tw.shoppingListBuilder.ShoppingListBuilder;
import com.tw.goods.GoodsItem;
import com.tw.privilege.Privilege;
import com.tw.shopping_list.ShoppingList;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class ReceiptsBuilder {
  public String buildReceipts(String goods_path, String input_path, String priv_path) {
    StringBuilder receipts = new StringBuilder("***<没钱赚商店>购物清单***\n");
    DecimalFormat decimalFormat = new DecimalFormat("#.00");
    ShoppingListBuilder shoppingListBuilder = new ShoppingListBuilder();
    ShoppingList shoppingList_total = shoppingListBuilder.factory(goods_path, input_path, priv_path);
    ShoppingList shoppingList_ThreeSendOne = new ShoppingList();
    Privilege privilege = new Privilege();
    ArrayList<String> id_list = shoppingList_total.getIdList();
    double total = 0;
    double priv_total = 0;

    for(String barcode : id_list) {
      GoodsItem goodsItem = shoppingList_total.getGoodItem(barcode);
      String type = privilege.identifyPrivilegeType(goodsItem);
      double priv_count = privilege.privilege(type, goodsItem);
      total += goodsItem.getOriginal_count();
      priv_total += priv_count;

      receipts.append("名称: " + goodsItem.getGoods().getName() +
      ", 数量: " + goodsItem.getAmount() + goodsItem.getGoods().getUnit() +
      ", 单价: " + goodsItem.getGoods().getPrice() + "(元)" +
      ",小计: " + decimalFormat.format(priv_count) + "(元)");

      if(type.equals("Discount")) {
        receipts.append(", 节省: " + decimalFormat.format(goodsItem.getOriginal_count() - priv_count) + "(元)\n");
      }else if(type.equals("ThreeSendOne")){
        shoppingList_ThreeSendOne.addGoodsItem(goodsItem);
        receipts.append("\n");
      } else {
        receipts.append("\n");
      }
      receipts.append("--------------------------\n");
    }

    if(shoppingList_ThreeSendOne.getIdList().size() > 0) {
      receipts.append("买二增一商品:\n");
      ArrayList<String> priv_list = shoppingList_ThreeSendOne.getIdList();
      for(String barcode : priv_list) {
        GoodsItem goodsItem = shoppingList_ThreeSendOne.getGoodItem(barcode);
        receipts.append("名称: " + goodsItem.getGoods().getName() +
        ", 数量: " + decimalFormat.format(goodsItem.getAmount() - privilege.PrivAcountByThreeSendOne(goodsItem.getAmount())) +
          goodsItem.getGoods().getUnit() + "\n");
      }
      receipts.append("--------------------------\n");
    }
    receipts.append("总计: " + decimalFormat.format(priv_total) + "(元)\n");
    if(total > priv_total) {
      receipts.append("节省: " + decimalFormat.format(total - priv_total) + "(元)\n");
    }
    receipts.append("**************************");
    return receipts.toString();
  }
}
