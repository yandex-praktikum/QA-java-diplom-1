package praktikum.ingredient;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.Random;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class GetPriceTest {
    private final float PRICE;
    private static Faker faker = new Faker();
    private static Random r = new Random();

    public GetPriceTest(float price) {
        this.PRICE = price;
    }

    @Parameterized.Parameters
    public static Object[][] typeValues() {
        return new Object[][] {
                { faker.number().numberBetween(1,10000)}, //common price
                { (float) (0.0001 + r.nextFloat() * (0.01 - 0.0001))}, //very small price
                { faker.number().numberBetween(1000000,1000000000)}, //very high price
                { 0,},
                { faker.number().numberBetween(-10000, -1)}, //under zero price
        };
    }

    @Test
    public void getPriceReturnsCorrectValues() {
        String expectedName = faker.regexify("[A-Za-z]{6}");
        float expectedPrice = PRICE;
        IngredientType expectedType = IngredientType.FILLING;

        Ingredient ingredient = new Ingredient(expectedType, expectedName, expectedPrice);

        float actualPrice = ingredient.getPrice();
        assertEquals("Price is not correct: ", expectedPrice, actualPrice, 0.1);
    }
}
