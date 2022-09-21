package praktikum;

import com.github.javafaker.Faker;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BunTest {
    private static Faker faker = new Faker();

    @Test
    public void getNameReturnsCorrectValues() {
        String expectedName = faker.regexify("[A-Za-z]{6}");
        float expectedPrice = faker.number().numberBetween(1,10000);

        Bun bun = new Bun(expectedName, expectedPrice);

        String actualName = bun.getName();
        assertEquals("Name is not correct: ", expectedName, actualName);
    }

    @Test
    public void getPriceReturnsCorrectValues() {
        String expectedName = faker.regexify("[A-Za-z]{6}");
        float expectedPrice = faker.number().numberBetween(1,10000);

        Bun bun = new Bun(expectedName, expectedPrice);

        float actualPrice = bun.getPrice();
        assertEquals("Price is not correct: ", expectedPrice, actualPrice, 0.1);
    }
}
