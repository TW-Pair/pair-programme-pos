import com.tw.factory.Factory;
import com.tw.goods.GoodsItem;
import com.tw.shopping_list.ShoppingList;
import org.junit.*;

import java.awt.event.ItemEvent;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class FactoryTest {
  @Test
  public void  testFactory() {
    Factory factory = new Factory();
    String goods_path = "D:/TW-Project/test/fixture/goods_informations.json";
    String input_path = "D:/TW-Project/test/fixture/barcode.json";
    ShoppingList shoppingList = factory.factory(goods_path, input_path);
    ArrayList<String> goodsList = shoppingList.getIdList();
    String barcode = goodsList.get(0);
    GoodsItem goodsItem = shoppingList.getGoodItem(barcode);
    assertEquals(goodsItem.getAmount(), 3);
    assertEquals(goodsItem.getGoods().getBarcode(), barcode);

  }
}
