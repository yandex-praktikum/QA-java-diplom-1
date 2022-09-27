package praktikum;

import com.github.javafaker.Faker;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertEquals;

public class BunTest {
    private static Faker faker = new Faker();

    @Test
    public void getNameReturnsCorrectValuesOnlyLetters() {
        String expectedName = faker.regexify("[A-Za-z]{6}");
        float expectedPrice = faker.number().numberBetween(1,10000);

        Bun bun = new Bun(expectedName, expectedPrice);

        String actualName = bun.getName();
        assertEquals("Name is not correct: ", expectedName, actualName);
    }

    @Test
    public void getNameReturnsCorrectValuesOnlyDigits() {
        String expectedName = faker.regexify("[0-9]{6}");
        float expectedPrice = faker.number().numberBetween(1,10000);

        Bun bun = new Bun(expectedName, expectedPrice);

        String actualName = bun.getName();
        assertEquals("Name is not correct: ", expectedName, actualName);
    }

    @Test
    public void getNameReturnsCorrectValuesSpecialCharacters() {
        String expectedName = faker.internet().password(6,20,true, true);
        float expectedPrice = faker.number().numberBetween(1,10000);

        Bun bun = new Bun(expectedName, expectedPrice);

        String actualName = bun.getName();
        assertEquals("Name is not correct: ", expectedName, actualName);
    }

    @Test
    public void getNameReturnsCorrectValuesEmptyName() {
        String expectedName = "";
        float expectedPrice = faker.number().numberBetween(1,10000);

        Bun bun = new Bun(expectedName, expectedPrice);

        String actualName = bun.getName();
        assertEquals("Name is not correct: ", expectedName, actualName);
    }

    @Test
    public void getNameReturnsCorrectValuesNullName() {
        String expectedName = null;
        float expectedPrice = faker.number().numberBetween(1,10000);

        Bun bun = new Bun(expectedName, expectedPrice);

        String actualName = bun.getName();
        assertEquals("Name is not correct: ", expectedName, actualName);
    }

    @Test
    public void getNameReturnsCorrectValuesLongName() {
        String expectedName = faker.regexify("[A-Za-z]{100}");
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

    @Test
    public void getPriceReturnsCorrectValuesLowPrice() {
        Random r = new Random();
        String expectedName = faker.regexify("[A-Za-z]{6}");
        float expectedPrice = (float) (0.0001 + r.nextFloat() * (0.01 - 0.0001));

        Bun bun = new Bun(expectedName, expectedPrice);

        float actualPrice = bun.getPrice();
        assertEquals("Price is not correct: ", expectedPrice, actualPrice, 0.1);
    }

    @Test
    public void getPriceReturnsCorrectValuesHighPrice() {
        Random r = new Random();
        String expectedName = faker.regexify("[A-Za-z]{6}");
        float expectedPrice = faker.number().numberBetween(1000000,1000000000);

        Bun bun = new Bun(expectedName, expectedPrice);

        float actualPrice = bun.getPrice();
        assertEquals("Price is not correct: ", expectedPrice, actualPrice, 0.1);
    }

    @Test
    public void getPriceReturnsCorrectValuesZeroPrice() {
        Random r = new Random();
        String expectedName = faker.regexify("[A-Za-z]{6}");
        float expectedPrice = 0;

        Bun bun = new Bun(expectedName, expectedPrice);

        float actualPrice = bun.getPrice();
        assertEquals("Price is not correct: ", expectedPrice, actualPrice, 0.1);
    }

    @Test
    public void getPriceReturnsCorrectValuesUnderZeroPrice() {
        Random r = new Random();
        String expectedName = faker.regexify("[A-Za-z]{6}");
        float expectedPrice = faker.number().numberBetween(-10000, -1);

        Bun bun = new Bun(expectedName, expectedPrice);

        float actualPrice = bun.getPrice();
        assertEquals("Price is not correct: ", expectedPrice, actualPrice, 0.1);
    }
}
