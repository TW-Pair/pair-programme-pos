import com.tw.parser.ShoppingListParser;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class ShoppingListParserTest {
  ShoppingListParser shoppingListParser;
  @Before
  public void init() {
    shoppingListParser = new ShoppingListParser();
  }

  @Test
  public void testParseFormMenu() {
    String filePath = "D:/tw-Project/test/fixture/barcode.json";
    String[] strs = {
      "ITEM000001",
      "ITEM000001",
      "ITEM000003",
      "ITEM000001",
      "ITEM000001",
      "ITEM000003-2",
      "ITEM000005",
      "ITEM000005",
      "ITEM000005"
    };
    assertEquals(strs, shoppingListParser.parseFormMenu(filePath));
  }

  @Test
  public void testParseId() {
    String barcode = "ITEM000001-2";
    assertEquals("ITEM000001", shoppingListParser.parseId(barcode));
  }

  @Test
  public void testParseIdNoStrike() {
    String barcode = "ITEM000001";
    assertEquals("ITEM000001", shoppingListParser.parseId(barcode));
  }

  @Test
  public void testParseNumNoStrike() {
    String barcode = "ITEM000001";
    assertEquals("notEquals", 1, shoppingListParser.parseNum(barcode));
  }

  @Test
  public void testParseNum() {
    String barcode = "ITEM000001-3";
    assertEquals("notEquals", 3, shoppingListParser.parseNum(barcode));

  }
}
