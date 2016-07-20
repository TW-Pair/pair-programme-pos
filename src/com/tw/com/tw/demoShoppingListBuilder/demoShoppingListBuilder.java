package com.tw.com.tw.demoShoppingListBuilder;

import com.tw.receiptsBuilder.ReceiptsBuilder;

public class demoShoppingListBuilder {
  public static void main(String[] args) {
    String input_path = "D:/TW-Project/data/barcode.json";
    String goodsInfo_path = "D:/TW-Project/data/goods_informations.json";
    String priv_path = "D:/TW-Project/data/privilege_list.json";
    ReceiptsBuilder receiptsBuilder = new ReceiptsBuilder();
    System.out.println(receiptsBuilder.buildReceipts(goodsInfo_path, input_path, priv_path));
  }
}
