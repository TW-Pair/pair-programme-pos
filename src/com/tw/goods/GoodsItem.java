package com.tw.goods;

import com.tw.calculate.Calculate;
import com.tw.goodsInformations.Goods;

import java.util.ArrayList;

public class GoodsItem {
  private Goods goods;
  private int amount;
  private double original_count;
  private ArrayList<String> priv_info;

  public GoodsItem(Goods goods, int amount, ArrayList<String> priv_info) {
    this.goods = goods;
    this.amount = amount;
    this.priv_info = priv_info;
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

  public double getOriginal_count() {
    Calculate calculate = new Calculate();
    return calculate.calculate(amount, Double.parseDouble(goods.getPrice()), 1);
  }

  public ArrayList<String> getPriv_info() {
    return priv_info;
  }

  public void setPriv_info(ArrayList<String> priv_info) {
    this.priv_info = priv_info;
  }
}
