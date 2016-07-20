import com.tw.parser.PrivilegeParser;
import org.junit.*;
import static org.junit.Assert.*;

import java.util.HashMap;

public class PrivilegeParserTest {
  @Test
  public void testParser() {
    PrivilegeParser privilegeParser = new PrivilegeParser();
    String file_path = "D:/TW-Project/test/fixture/privilege_list.json";
    HashMap<String, String[]> privMap = privilegeParser.parser(file_path);
    assertTrue(privMap.containsKey("Discount"));
    assertTrue(privMap.containsKey("ThreeSendOne"));
    String[] barcodes_discount = privMap.get("Discount");
    assertEquals("ITEM000001", barcodes_discount[0]);
    assertEquals("ITEM000003", barcodes_discount[1]);
    String[] barcodes_threesendone = privMap.get("ThreeSendOne");
    assertEquals("ITEM000001", barcodes_threesendone[0]);
  }
}
