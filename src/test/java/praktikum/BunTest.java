package praktikum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)

public class BunTest {
    @Test
    public void getName() {
        String bunName = "testBunName";
        float bunPrice = 10F;
        Bun bun = new Bun(bunName, bunPrice);
        String expected = bunName;
        String actual = bun.getName();
        assertEquals(expected, actual);
    }

    @Test
    public void getPrice() {
        String bunName = "testBunName";
        float bunPrice = 10F;
        Bun bun = new Bun(bunName, bunPrice);
        float expected = bunPrice;
        float actual = bun.getPrice();
        assertEquals(expected, actual, 1.0);
    }
}