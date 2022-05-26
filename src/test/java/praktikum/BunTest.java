package praktikum;

import com.github.javafaker.Faker;
import org.junit.Test;
import java.util.Random;
import static org.junit.Assert.assertEquals;

public class BunTest {
    Random random = new Random();
    Faker faker = Faker.instance();

    final String bunName = faker.name().toString();
    final float bunPrice = random.nextFloat();

    Bun bun = new Bun(bunName, bunPrice);

    @Test
    public void getNameCheck() {
        String actual = bun.getName();
        assertEquals(bunName, actual);
    }

    @Test
    public void getPriceCheck() {
        float actual = bun.getPrice();
        assertEquals(bunPrice, actual, 0);
    }
}
