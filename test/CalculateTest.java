import com.tw.calculate.Calculate;
import org.junit.*;
import static org.junit.Assert.*;

public class CalculateTest {
  @Test
  public void testCalculate() {
    Calculate calculate = new Calculate();
    assertEquals(calculate.calculate(3, 3.5, 0.95), 9.975, 0.00001);
  }
}
