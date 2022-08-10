package praktikum;

import com.github.javafaker.Faker;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BunTest {

    Bun bun;
    String testName;
    float testPrice;
    Faker faker;


    @Before
    public void setUp() {
        faker = new Faker();
        testName = faker.name().firstName();
        testPrice = faker.number().numberBetween(1, 888);
        bun = new Bun(testName, testPrice);
    }

    @Test
    public void getNameShouldReturnCorrectName() {
        String expectedValue = testName;
        assertEquals(expectedValue, bun.getName());
    }

    @Test
    public void getPriceShouldReturnCorrectPrice() {
        float expectedValue = testPrice;
        assertEquals(expectedValue, bun.getPrice(), 0.0);
    }

    @Test
    public void getNameShouldReturnErrorIfNameIsNotCorrect() {
        String expectedValue = "UnknownName";
        assertNotEquals(expectedValue, bun.getName());
    }

    @Test
    public void getPriceShouldReturnErrorIfPriceIsNotCorrect() {
        float expectedValue = 999;
        assertNotEquals(expectedValue, bun.getPrice());
    }

}