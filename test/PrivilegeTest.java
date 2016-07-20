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
    Goods goods1 = new Goods("ITEM000001", "可口可乐", "瓶", "食品", "3.00");
    GoodsItem goodsItem1 = new GoodsItem(goods1, 10, new ArrayList<String>());
    Goods goods2 = new Goods("ITEM000002", "羽毛球", "个", "体育器材", "1.00");
    GoodsItem goodsItem2 = new GoodsItem(goods2, 3, new ArrayList<String>());
    shoppingList.addGoodsItem(goodsItem2);
    shoppingList.addGoodsItem(goodsItem1);
    assertTrue(privilege.hasPrivGoods(priv_list, shoppingList));
  }

  @Test
  public void testIdentifyPrivilegeType_ThreeSendOne() {
    Goods goods1 = new Goods("ITEM000001", "可口可乐", "瓶", "食品", "3.00");
    ArrayList<String> priv_info = new ArrayList<String>();
    priv_info.add("Discount");
    priv_info.add("ThreeSendOne");
    GoodsItem goodsItem = new GoodsItem(goods1, 3, priv_info);
    assertEquals("ThreeSendOne", privilege.identifyPrivilegeType(goodsItem));
  }

  @Test
  public void testIdentifyPrivilegeType_Discount() {
    Goods goods1 = new Goods("ITEM000001", "可口可乐", "瓶", "食品", "3.00");
    ArrayList<String> priv_info = new ArrayList<String>();
    priv_info.add("Discount");
    GoodsItem goodsItem = new GoodsItem(goods1, 3, priv_info);
    assertEquals("Discount", privilege.identifyPrivilegeType(goodsItem));
  }

  @Test
  public void testIsPrivGoodsType_Discount() {
    Goods goods1 = new Goods("ITEM000001", "可口可乐", "瓶", "食品", "3.00");
    ArrayList<String> priv_info = new ArrayList<String>();
    priv_info.add("Discount");
    GoodsItem goodsItem = new GoodsItem(goods1, 11, priv_info);
    assertTrue(privilege.isPrivGoods(goodsItem));
  }
  @Test
  public void testIsPrivGoodsType_ThreeSendOne() {
    Goods goods1 = new Goods("ITEM000001", "可口可乐", "瓶", "食品", "3.00");
    ArrayList<String> priv_info = new ArrayList<String>();
    priv_info.add("Discount");
    priv_info.add("ThreeSendOne");
    GoodsItem goodsItem = new GoodsItem(goods1, 3, priv_info);
    assertTrue(privilege.isPrivGoods(goodsItem));
  }
  @Test
  public  void testprivilegeTypeDiscount() {
    Goods goods1 = new Goods("ITEM000001", "可口可乐", "瓶", "食品", "3.00");
    ArrayList<String> priv_info = new ArrayList<String>();
    priv_info.add("Discount");
    GoodsItem goodsItem = new GoodsItem(goods1, 11, priv_info);
    assertEquals(31.35, privilege.privilege("Discount", goodsItem), 0.0001);
  }
  @Test
  public  void testprivilegeTypeThreeSendOne() {
    Goods goods1 = new Goods("ITEM000001", "可口可乐", "瓶", "食品", "3.00");
    ArrayList<String> priv_info = new ArrayList<String>();
    priv_info.add("Discount");
    priv_info.add("ThreeSendOne");
    GoodsItem goodsItem = new GoodsItem(goods1, 11, priv_info);
    assertEquals(24, privilege.privilege("ThreeSendOne", goodsItem), 0.0001);
  }
}
