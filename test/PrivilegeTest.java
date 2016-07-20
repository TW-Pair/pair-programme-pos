import com.tw.goods.GoodsItem;
import com.tw.goodsInformations.Goods;
import com.tw.privilege.Privilege;
import com.tw.shopping_list.ShoppingList;
import org.junit.*;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class PrivilegeTest {
  Privilege privilege;
  @Before
  public void init() {
    privilege = new Privilege();
  }
  @Test
  public void testHasPrivGoods() {
    ShoppingList shoppingList = new ShoppingList();
    String[] priv_list = {"ITEM000001", "ITEM000003"};
    Goods goods1 = new Goods("ITEM000001", "可口可乐", "瓶", "食品", "碳酸饮料", "3.00");
    GoodsItem goodsItem1 = new GoodsItem(goods1, 10);
    Goods goods2 = new Goods("ITEM000002", "羽毛球", "个", "体育器材", "球类器材", "1.00");
    GoodsItem goodsItem2 = new GoodsItem(goods2, 3);
    shoppingList.addGoodsItem(goodsItem2);
    shoppingList.addGoodsItem(goodsItem1);
    assertTrue(privilege.hasPrivGoods(priv_list, shoppingList));
  }
  @Test
  public void testIsPrivGoods() {
    String[] priv_list = {"ITEM000001", "ITEM000003"};
    String barcode1 = "ITEM000001";
    String barcode2 = "ITEM000002";
    assertTrue(privilege.isPrivGoods(priv_list, barcode1));
    assertFalse(privilege.isPrivGoods(priv_list, barcode2));
  }
  @Test
  public void testDoPrivilege() {
    Goods goods = new Goods("ITEM000001", "可口可乐", "瓶", "食品", "碳酸饮料", "3.00");
    GoodsItem goodsItem = new GoodsItem(goods, 10);
    //assertEquals比较double型时需要增加一个误差参数
    assertEquals(privilege.doPrivilege("Discount", goodsItem), 28.50d);
  }
}
