import com.tw.factory.Factory;
import com.tw.goods.GoodsItem;
import com.tw.shopping_list.ShoppingList;
import org.junit.*;

import java.awt.event.ItemEvent;
import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.*;

public class FactoryTest {
  @Test
  public void  testFactory() {
    Factory factory = new Factory();
    String goods_path = "D:/TW-Project/test/fixture/goods_informations.json";
    String input_path = "D:/TW-Project/test/fixture/barcode.json";
    String priv_path = "D:/TW-Project/test/fixture/privilege_list.json";
    ShoppingList shoppingList = factory.factory(goods_path, input_path, priv_path);
    ArrayList<String> goodsList = shoppingList.getIdList();
    String barcode = goodsList.get(0);
    GoodsItem goodsItem = shoppingList.getGoodItem(barcode);
    assertEquals(goodsItem.getAmount(), 11);
    assertEquals(goodsItem.getGoods().getBarcode(), barcode);

  }
  @Test
  public void testProducePriv_info() {
    Factory factory = new Factory();
    String barcode = "ITEM000001";
    HashMap<String, String[]> privMap = new HashMap<String, String[]>();
    String[] privs1 = {"ITEM000001"};
    String[] privs2 = {"ITEM000001"};
    privMap.put("Discount", privs1);
    privMap.put("ThreeSendOne", privs2);
    assertEquals("Discount", factory.producePriv_info(barcode, privMap).get(0));
    assertEquals("ThreeSendOne", factory.producePriv_info(barcode, privMap).get(1));
  }

}
