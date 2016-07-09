package com.tw.goods;

/**
 * Created by Administrator on 2016/7/9.
 */
public class GoodsItem {
  private int amount;
  private String goodsId;

  public GoodsItem(int amount, String goodsId) {
    this.amount = amount;
    this.goodsId = goodsId;
  }

  public int getAmount() {
    return amount;
  }

  public void setAmount(int amount) {
    this.amount = amount;
  }

  public String getGoodsId() {
    return goodsId;
  }

  public void setGoodsId(String goodsId) {
    this.goodsId = goodsId;
  }
}
