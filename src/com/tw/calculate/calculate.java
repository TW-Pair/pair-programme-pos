package com.tw.calculate;

import java.text.DecimalFormat;

/**
 * Created by Administrator on 2016/7/20.
 */
public class Calculate {
  public double calculate(int num, double price, double priv) {
    DecimalFormat decimalFormat = new DecimalFormat("#.00");
    double ans = num * price * priv;
    decimalFormat.format(ans);
    return ans;
  }
}
