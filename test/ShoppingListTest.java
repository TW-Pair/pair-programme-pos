import com.tw.identify.ShoppingList;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ShoppingListTest {
  ShoppingList shoppingList;

  @Before
  public void init() {
    shoppingList = new ShoppingList();
  }


  @Test
  public void testIdentifyBarcodes() {
    String[] strs = {"ITEM000001-2", "ITEM000003", "ITEM000002-1", "ITEM000001"};
    shoppingList.identifyBarcodes(strs);
  int num1 = shoppingList.getGoodsNum("ITEM000001");
  int num2 = shoppingList.getGoodsNum("ITEM000002");
  int num3 = shoppingList.getGoodsNum("ITEM000003");
  assertEquals(3, num1);
  assertEquals(1, num2);
  assertEquals(1, num3);

}







}
