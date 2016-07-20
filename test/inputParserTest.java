import com.tw.parser.InputParser;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;


public class inputParserTest {
  InputParser InputParser;
  @Before
  public void init() {
    InputParser = new InputParser();
  }

  @Test
  public void parse() {
    String filePath = "D:/TW-Project/data/barcode.json";
    HashMap<String, Integer> inputMap = InputParser.parse(filePath);
    assertEquals(11, inputMap.get("ITEM000001").intValue());
    assertEquals(13, inputMap.get("ITEM000003").intValue());
    assertEquals(2, inputMap.get("ITEM000002").intValue());
  }

  @Test
  public void testParseId() {
    String barcode = "ITEM000001-2";
    assertEquals("ITEM000001", InputParser.parseId(barcode));
  }

  @Test
  public void testParseIdNoStrike() {
    String barcode = "ITEM000001";
    assertEquals("ITEM000001", InputParser.parseId(barcode));
  }

  @Test
  public void testParseNumNoStrike() {
    String barcode = "ITEM000001";
    assertEquals("notEquals", 1, InputParser.parseNum(barcode));
  }

  @Test
  public void testParseNum() {
    String barcode = "ITEM000001-3";
    assertEquals("notEquals", 3, InputParser.parseNum(barcode));

  }
}
