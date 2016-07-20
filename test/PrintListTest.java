import com.tw.factory.Factory;
import com.tw.goods.GoodsItem;
import com.tw.goodsInformations.Goods;
import com.tw.parser.PrivilegeParser;
import com.tw.printList.PrintList;
import com.tw.privilege.Privilege;
import com.tw.shopping_list.ShoppingList;
import org.junit.*;
import org.testng.annotations.BeforeTest;

import static org.junit.Assert.*;

public class PrintListTest {
  PrintList printList;
  GoodsItem goodsItem;
  @Before
  public void init() {
    printList = new PrintList();
  }
  @Test
  public void testPrintGoodsItem() {
    String testStr = "名称: 可口可乐, 数量: 10瓶, 单价: 3.00(元)";
    Goods goods = new Goods("ITEM000001", "可口可乐", "瓶", "食品", "碳酸饮料", "3.00");
    goodsItem = new GoodsItem(goods, 10);
    assertEquals(testStr, printList.printGoodsItem(goodsItem));
  }
  @Test
  public void testPrintTotal() {
    String testStr = ", 小计: 31.35(元), 优惠: 1.65(元)";
    Goods goods = new Goods("ITEM000001", "可口可乐", "瓶", "食品", "碳酸饮料", "3.00");
    goodsItem = new GoodsItem(goods, 11);
    assertEquals(testStr, printList.printTotal("Discount", goodsItem));

  }
  @Test
  public void testBuildList(){
    Factory factory = new Factory();
    Privilege privilege = new Privilege();
    PrivilegeParser privilegeParser = new PrivilegeParser();
    String goods_path = "D:/TW-Project/test/fixture/goods_informations.json";
    String input_path = "D:/TW-Project/test/fixture/barcode.json";
    String privilege_path = "D:/TW-Project/test/fixture/privilege_list.json";
    ShoppingList shoppingList = factory.factory(goods_path, input_path);
    String receipt = "***<没钱赚商店>购物清单***\n" +
      "名称: 可口可乐, 数量: 11瓶, 单价: 3.00(元), 小计: 31.35(元), 优惠: 1.65(元)\n" +
      "名称: 羽毛球, 数量: 5个, 单价: 1.00(元), 小计: 5.00(元)\n" +
      "名称: 苹果, 数量: 2个, 单价: 5.50(元), 小计: 11.00(元)\n" +
      "----------------------\n" +
      "批发价出售商品：\n" +
      "名称: 可口可乐，数量: 11瓶\n" +
      "----------------------\n" +
      "总计: 47.35(元)\n" ;
    if(privilege.hasPrivGoods(privilegeParser.parser(privilege_path).get("Discount"), factory.factory(goods_path, input_path).getIdList())) {

    }
      "节省: 1.65(元)\n" +
      "**********************";
    assertEquals(receipt, printList.buildList(goods_path,input_path,privilege_path));
  }
  @Test
  public void testSubBuildList(){
    String goods_path = "D:/TW-Project/test/fixture/goods_informations.json";
    String input_path = "D:/TW-Project/test/fixture/subTotal.json";
    String privilege_path = "D:/TW-Project/test/fixture/privilege_list.json";
    String receipt = "***<没钱赚商店>购物清单***\n" +
      "名称: 可口可乐, 数量: 9瓶, 单价: 3.00(元), 小计: 27.00(元) \n" +
      "名称: 羽毛球, 数量: 5个, 单价: 1.00(元), 小计: 5.00(元)\n" +
      "名称: 苹果, 数量: 2个, 单价: 5.50(元), 小计: 11.00(元)\n" +
      "----------------------\n"  +
      "总计: 43.00(元)\n" +
      "**********************";
    assertEquals(receipt, printList.buildList(goods_path,input_path,privilege_path));
  }


}


