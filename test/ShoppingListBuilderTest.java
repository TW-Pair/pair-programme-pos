import com.tw.shoppingListBuilder.ShoppingListBuilder;
import com.tw.goods.GoodsItem;
import com.tw.shopping_list.ShoppingList;
import org.junit.*;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.*;

public class ShoppingListBuilderTest {
  @Test
  public void  testFactory() {
    ShoppingListBuilder shoppingListBuilder = new ShoppingListBuilder();
    String goods_path = "D:/TW-Project/test/fixture/goods_informations.json";
    String input_path = "D:/TW-Project/test/fixture/barcode.json";
    String priv_path = "D:/TW-Project/test/fixture/privilege_list.json";
    ShoppingList shoppingList = shoppingListBuilder.factory(goods_path, input_path, priv_path);
    ArrayList<String> goodsList = shoppingList.getIdList();
    String barcode = goodsList.get(0);
    GoodsItem goodsItem = shoppingList.getGoodItem(barcode);
    assertEquals(goodsItem.getAmount(), 11);
    assertEquals(goodsItem.getGoods().getBarcode(), barcode);

  }
  @Test
  public void testProducePriv_info() {
    ShoppingListBuilder shoppingListBuilder = new ShoppingListBuilder();
    String barcode = "ITEM000001";
    HashMap<String, String[]> privMap = new HashMap<String, String[]>();
    String[] privs1 = {"ITEM000001"};
    String[] privs2 = {"ITEM000001"};
    privMap.put("Discount", privs1);
    privMap.put("ThreeSendOne", privs2);
    assertEquals("Discount", shoppingListBuilder.producePriv_info(barcode, privMap).get(0));
    assertEquals("ThreeSendOne", shoppingListBuilder.producePriv_info(barcode, privMap).get(1));
  }

}
