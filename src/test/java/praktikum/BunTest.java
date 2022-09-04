package praktikum;

import net.bytebuddy.utility.RandomString;
import org.junit.*;

import java.util.Random;

import static org.junit.Assert.assertEquals;

public class BunTest {

    Bun bun;

    Random random = new Random();
    RandomString randomAlphabetic = new RandomString();

    String name = randomAlphabetic.nextString();
    float price = random.nextFloat();

    @Before
    public void setUp() {
        bun = new Bun(name, price);
    }

    @Test
    public void getName() {
        assertEquals("Ожидаемое и фактическое имя не совпадают", name, bun.getName());
    }

    @Test
    public void getPrice() {
        assertEquals("Ожидаемая и фактическая цена не совпадают", price, bun.getPrice(), 0);
    }
}