import org.junit.Test;
import praktikum.Bun;
import static org.junit.Assert.assertEquals;

public class BunTest {

    private final String bunName = "black bun";
    private final float bunPrice = 100f;

    @Test
    public void shouldReturnBunName() {
        Bun bun = new Bun(bunName, bunPrice);
        String expectedName = bunName;
        assertEquals(expectedName, bun.getName());
    }

    @Test
    public void shouldReturnBunPrice() {
        Bun bun = new Bun(bunName, bunPrice);
        float expectedPrice = bunPrice;
        assertEquals(expectedPrice, bun.getPrice(), 0);
    }
}
