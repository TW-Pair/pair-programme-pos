package com.tw.printList;


import com.sun.xml.internal.bind.v2.model.core.ID;
import com.tw.factory.Factory;
import com.tw.goods.GoodsItem;
import com.tw.goodsInformations.Goods;
import com.tw.parser.PrivilegeParser;
import com.tw.privilege.Privilege;
import com.tw.shopping_list.ShoppingList;
import org.omg.PortableServer.ID_ASSIGNMENT_POLICY_ID;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;


public class PrintList {
  public String printGoodsItem(GoodsItem goodsItem) {
    String GoodsItemStr = "名称: " + goodsItem.getGoods().getName() + ", 数量: "
      + goodsItem.getAmount() + goodsItem.getGoods().getUnit() + ", 单价: " + goodsItem.getGoods().getPrice()
      + "(元)";
    return GoodsItemStr;
  }

  public String printTotal(String type, GoodsItem goodsItem) {
    Privilege privilege = new Privilege();
    double privTotal = privilege.doPrivilege(type, goodsItem);
    double total = Math.round(goodsItem.getAmount() * Double.parseDouble(goodsItem.getGoods().getPrice()) * 100) * 0.01d;
    DecimalFormat decimalFormat = new DecimalFormat("#.00");
    if (type.equals("Discount") && goodsItem.getAmount() >= 10) {
      return ", 小计: " + privTotal + "(元), 优惠: " + decimalFormat.format(total - privTotal) + "(元)";
    }
    return ", 小计: " + decimalFormat.format(total) + "(元)";
  }

  public String buildList(String goods_path, String input_path, String privilege_path) {
    Factory factory = new Factory();
    PrivilegeParser privilegeParser = new PrivilegeParser();
    Privilege privilege = new Privilege();
    String list = new String("***<没钱赚商店>购物清单***" + "\n");
    HashMap<String, String[]> privMap = privilegeParser.parser(privilege_path);
    ShoppingList shoppingList = factory.factory(goods_path, input_path);
    String type = "Discount";
    String[] priv_list = privMap.get(type);
    ArrayList<String> id_list = shoppingList.getIdList();
    for (int i = 0; i < id_list.size(); i++) {
      GoodsItem goodsItem = shoppingList.getGoodItem(id_list.get(i));
      list += printGoodsItem(goodsItem) + printTotal(type, goodsItem) + "\n";
    }
    list += "----------------------\n";
    if (privilege.hasPrivGoods(priv_list, shoppingList)) {
      list += "批发价出售商品：";
      for (int i = 0; i < id_list.size(); i++) {
        if (privilege.isPrivGoods(priv_list, id_list.get(i)) && shoppingList.getGoodItem(id_list.get(i)).getAmount() >= 10) {
          list += "\n" + "名称: " + shoppingList.getGoodItem(id_list.get(i)).getGoods().getName() +
            "，数量: " + shoppingList.getGoodItem(id_list.get(i)).getAmount() +
            shoppingList.getGoodItem(id_list.get(i)).getGoods().getUnit();

        }
      }
      list += "\n----------------------\n";
    }
    double total = countTotal( shoppingList,priv_list);
    double subtotal = countSubtotal(shoppingList);
    DecimalFormat decimalFormat = new DecimalFormat("#.00");
    list += "总计: " + decimalFormat.format(total)  + "(元)\n";

    list += "节省: " + decimalFormat.format(subtotal - total) + "(元)\n";
    list += "**********************";

    return list;
  }

  public  double countTotal(ShoppingList shoppingList,String[] priv_list){
    Privilege privilege = new Privilege();
    String type = "Discount";
    double total = 0 ;
    ArrayList<String> arrayList = shoppingList.getIdList();
    for(int i = 0; i  < arrayList.size(); i++){
      GoodsItem goodsItem = shoppingList.getGoodItem(arrayList.get(i));
      if(privilege.isPrivGoods(priv_list,arrayList.get(i))){
        total += privilege.doPrivilege(type, goodsItem);
      }
      else{
        total += privilege.doPrivilege("", goodsItem);
      }
    }
    return total;
  }

  public double countSubtotal(ShoppingList shoppingList){
    ArrayList<String> arrayList = shoppingList.getIdList();
    Privilege privilege = new Privilege();
    double subtotal = 0;
    for(int i = 0; i  < arrayList.size(); i++){
      subtotal += privilege.doPrivilege("", shoppingList.getGoodItem(arrayList.get(i)));
    }
    return subtotal;
  }

}
