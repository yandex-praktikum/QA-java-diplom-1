import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;
import com.github.javafaker.Faker;

import static org.junit.Assert.assertEquals;

public class BunTest {

    Bun bun = new Bun();
    Faker faker = new Faker();
    String expectedNameBun = faker.food().ingredient();
    float expectedPriceBun = (float) faker.number().randomDouble(2, 1, 1000);

    @Before
    public void setup() {
        bun = new Bun(expectedNameBun,expectedPriceBun);
    }

    @Test
    public void getName() {
        assertEquals("Incorrect name bun", expectedNameBun, bun.getName());

    }

    @Test
    public void getPrice() {
        assertEquals(expectedPriceBun, bun.getPrice(), 1);

    }

}
