package praktikum.BunTest;

import net.datafaker.Faker;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

import static java.lang.Math.pow;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class GetPriceReturnsEnteredPriceTest {

    static Faker faker = new Faker();
    private final String name;
    private final Float price;

    public GetPriceReturnsEnteredPriceTest(String name, Float price) {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {RandomStringUtils.randomAlphabetic(5), (float) faker.number().randomDouble(45, 1, 2)},
                {RandomStringUtils.randomAlphabetic(5), (float) faker.number().randomDouble(1, (int) pow(10, 38), (int) pow(10, 38))},
        };
    }


    @Test
    public void testGetPriceInTheBoundaryValuesReturnsEnteredPrice() {
        Bun bun = new Bun(name, price);
        Float returnValue = bun.getPrice();
        assertEquals(price, returnValue);
    }
}