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
    Goods goods1 = new Goods("ITEM000001", "可口可乐", "瓶", "食品", "3.00");
    GoodsItem goodsItem1 = new GoodsItem(goods1, 5, new ArrayList<String>());
    GoodsItem goodsItem2 = new GoodsItem(goods1, 3, new ArrayList<String>());

    shoppingList.addGoodsItem(goodsItem1);
    shoppingList.addGoodsItem(goodsItem2);

    assertEquals(8, shoppingList.getGoodItem("ITEM000001").getAmount());
    assertEquals("ITEM000001", shoppingList.getGoodItem("ITEM000001").getGoods().getBarcode());
    assertEquals("可口可乐", shoppingList.getGoodItem("ITEM000001").getGoods().getName());
    assertEquals("3.00", shoppingList.getGoodItem("ITEM000001").getGoods().getPrice());
  }

  @Test
  public void testGetIdList() {
    Goods goods1 = new Goods("ITEM000001", "可口可乐", "瓶", "食品", "3.00");
    GoodsItem goodsItem1 = new GoodsItem(goods1, 5, new ArrayList<String>());
    Goods goods2 = new Goods("ITEM000002", "羽毛球", "个", "体育器材", "1.00");
    GoodsItem goodsItem2 = new GoodsItem(goods2, 3, new ArrayList<String>());

    shoppingList.addGoodsItem(goodsItem1);
    shoppingList.addGoodsItem(goodsItem2);

    assertEquals("ITEM000001", shoppingList.getIdList().get(0));
    assertEquals("ITEM000002", shoppingList.getIdList().get(1));
  }
  @Test
  public void testGetIdList_1() {
    Goods goods1 = new Goods("ITEM000001", "可口可乐", "瓶", "食品", "3.00");
    GoodsItem goodsItem1 = new GoodsItem(goods1, 5, new ArrayList<String>());
    Goods goods2 = new Goods("ITEM000002", "羽毛球", "个", "体育器材", "1.00");
    GoodsItem goodsItem2 = new GoodsItem(goods2, 3, new ArrayList<String>());
    shoppingList.addGoodsItem(goodsItem2);
    shoppingList.addGoodsItem(goodsItem1);
    ArrayList<String> arrayList = shoppingList.getIdList();

    assertEquals("ITEM000001", arrayList.get(0));
    assertEquals("ITEM000002", arrayList.get(1));
  }
}
