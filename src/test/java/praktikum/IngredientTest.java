package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTest {
    Ingredient ingredient;
    IngredientType type;
    String name;
    float price;

    public IngredientTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] getTestValues() {
        return new Object[][]{
                {IngredientType.SAUCE, "Salad", 7},
                {IngredientType.FILLING, "BBQ", 10.01f}
        };
    }

    @Before
    public void init() {
        ingredient = new Ingredient(type, name, price);
    }

    @Test
    public void getPrice() {
        float expectedPrice = price;
        assertEquals(expectedPrice, ingredient.getPrice(), 0.0);
    }

    @Test
    public void getName() {
        String expectedName = name;
        assertEquals(expectedName, ingredient.getName());
    }

    @Test
    public void getType() {
        IngredientType expectedType = type;
        assertEquals(expectedType, ingredient.getType());
    }
}