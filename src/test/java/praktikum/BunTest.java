package praktikum;

import com.github.javafaker.Faker;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BunTest {

    @Test
    public void getNameTest() {
        Faker faker = new Faker();
        float price = faker.number().randomDigit();
        Bun bun = new Bun("hot sauce", price);
        String actual = bun.getName();
        String expected = "hot sauce";
        assertEquals("bun name is correct", expected, actual);
    }

    @Test
    public void getPriceTest() {
        Faker faker = new Faker();
        String name = faker.name().firstName();
        Bun bun = new Bun(name, 188);
        float actual = bun.getPrice();
        float expected = 188;
        assertEquals("bun price is correct", expected, actual, 0);
    }
}
