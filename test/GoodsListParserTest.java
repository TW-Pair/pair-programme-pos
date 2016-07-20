import com.tw.goodsInformations.Goods;
import com.tw.parser.GoodsListParser;
import org.junit.*;
import java.util.HashMap;
import static org.junit.Assert.*;

public class GoodsListParserTest {
  @Test
  public void testGoodsListParser() {
    String json_path = "D:/TW-Project/test/fixture/goods_informations.json";
    HashMap<String, Goods> goodsMaps = new HashMap<String, Goods>();
    GoodsListParser goodsListParser = new GoodsListParser();
    goodsMaps = goodsListParser.parseGoodsList(json_path);
    assertEquals("ITEM000002", goodsMaps.get("ITEM000002").getBarcode());
    assertEquals("羽毛球", goodsMaps.get("ITEM000002").getName());
    assertEquals("个", goodsMaps.get("ITEM000002").getUnit());
    assertEquals("体育用品", goodsMaps.get("ITEM000002").getCategory());
    assertEquals("1.00", goodsMaps.get("ITEM000002").getPrice());
  }
}
