import com.tw.goods.GoodsItem;
import com.tw.goodsInformations.Goods;
import com.tw.shopping_list.ShoppingList;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static  org.junit.Assert.*;

public class ShoppingListTest {
  ShoppingList shoppingList;

  @Before
  public void init() {
    shoppingList = new ShoppingList();
  }

  @Test
  public void testShoppingList() {
    Goods goods1 = new Goods("ITEM000001", "可口可乐", "瓶", "食品", "碳酸饮料", "3.00");
    GoodsItem goodsItem1 = new GoodsItem(goods1, 5);
    GoodsItem goodsItem2 = new GoodsItem(goods1, 3);

    shoppingList.addGoodsItem(goodsItem1);
    shoppingList.addGoodsItem(goodsItem2);

    assertEquals(shoppingList.getGoodItem("ITEM000001").getAmount(), 8);
    assertEquals("ITEM000001", shoppingList.getGoodItem("ITEM000001").getGoods().getBarcode());
    assertEquals("可口可乐", shoppingList.getGoodItem("ITEM000001").getGoods().getName());
    assertEquals("3.00", shoppingList.getGoodItem("ITEM000001").getGoods().getPrice());
  }

  @Test
  public void testGetIdList() {
    Goods goods1 = new Goods("ITEM000001", "可口可乐", "瓶", "食品", "碳酸饮料", "3.00");
    GoodsItem goodsItem1 = new GoodsItem(goods1, 5);
    Goods goods2 = new Goods("ITEM000002", "羽毛球", "个", "体育器材", "球类器材", "1.00");
    GoodsItem goodsItem2 = new GoodsItem(goods2, 3);

    shoppingList.addGoodsItem(goodsItem1);
    shoppingList.addGoodsItem(goodsItem2);

    assertEquals("ITEM000001", shoppingList.getIdList().get(0));
    assertEquals(shoppingList.getIdList().get(1), "ITEM000002");
  }
  @Test
  public void testGetIdList_1() {
    Goods goods1 = new Goods("ITEM000001", "可口可乐", "瓶", "食品", "碳酸饮料", "3.00");
    GoodsItem goodsItem1 = new GoodsItem(goods1, 5);
    Goods goods2 = new Goods("ITEM000002", "羽毛球", "个", "体育器材", "球类器材", "1.00");
    GoodsItem goodsItem2 = new GoodsItem(goods2, 3);
    shoppingList.addGoodsItem(goodsItem2);
    shoppingList.addGoodsItem(goodsItem1);
    ArrayList<String> arrayList = shoppingList.getIdList();

    assertEquals(arrayList.get(0), "ITEM000001");
    assertEquals(arrayList.get(1), "ITEM000002");
  }
}
