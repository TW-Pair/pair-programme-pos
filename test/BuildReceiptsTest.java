import com.tw.buildReceipts.BuildReceipts;
import org.junit.*;
import static org.junit.Assert.*;

public class BuildReceiptsTest {
  BuildReceipts buildReceipts;
  @Before
  public void init() {
    buildReceipts = new BuildReceipts();
  }

  @Test
  public void testSubBuildList(){
    String goods_path = "D:/TW-Project/test/fixture/goods_informations.json";
    String input_path = "D:/TW-Project/test/fixture/barcode.json";
    String privilege_path = "D:/TW-Project/test/fixture/privilege_list.json";
    String receipt = "***<没钱赚商店>购物清单***\n" +
      "名称: 可口可乐, 数量: 11瓶, 单价: 3.00(元),小计: 24.00(元)\n" +
      "--------------------------\n" +
      "名称: 羽毛球, 数量: 2个, 单价: 1.00(元),小计: 2.00(元)\n" +
      "--------------------------\n" +
      "名称: 苹果, 数量: 13个, 单价: 5.50(元),小计: 67.92(元), 节省: 3.58(元)\n" +
      "--------------------------\n" +
      "买二增一商品:\n" +
      "名称: 可口可乐, 数量: 3.00瓶\n" +
      "--------------------------\n" +
      "总计: 93.92(元)\n" +
      "节省: 12.58(元)\n" +
      "**************************";
    assertEquals(receipt, buildReceipts.buildReceipts(goods_path,input_path,privilege_path));
  }


}


