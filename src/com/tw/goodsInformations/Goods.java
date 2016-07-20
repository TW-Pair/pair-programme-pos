package com.tw.goodsInformations;

public class Goods {
  private String barcode;
  private String name;
  private String unit;
  private String category;
  private String subCategory;
  private String price;

  public Goods(String barcode, String name, String unit, String category, String subCategory, String price) {
    this.barcode = barcode;
    this.name = name;
    this.unit = unit;
    this.category = category;
    this.subCategory = subCategory;
    this.price = price;
  }

  public String getBarcode() {
    return barcode;
  }

  public void setBarcode(String barcode) {
    this.barcode = barcode;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getUnit() {
    return unit;
  }

  public void setUnit(String unit) {
    this.unit = unit;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public String getSubCategory() {
    return subCategory;
  }

  public void setSubCategory(String subCategory) {
    this.subCategory = subCategory;
  }

  public String getPrice() {
    return price;
  }

  public void setPrice(String price) {
    this.price = price;
  }


}
