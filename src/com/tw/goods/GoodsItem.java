package com.tw.goods;

import com.tw.goodsInformations.Goods;

public class GoodsItem {
  private Goods goods;
  private int amount;

  public GoodsItem(Goods goods, int amount) {
    this.goods = goods;
    this.amount = amount;
  }

  public Goods getGoods() {
    return goods;
  }

  public void setGoods(Goods goods) {
    this.goods = goods;
  }

  public int getAmount() {
    return amount;
  }

  public void setAmount(int amount) {
    this.amount = amount;
  }
}
