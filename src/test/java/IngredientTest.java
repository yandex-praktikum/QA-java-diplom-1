import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)

public class IngredientTest {

    private final IngredientType type;
    private final String name;
    private final float price;
    private final IngredientType expectedType;
    private final String expectedName;
    private final float expectedPrice;


    public IngredientTest(IngredientType type, String name, float price, IngredientType expectedType, String expectedName, float expectedPrice) {
        this.type = type;
        this.name = name;
        this.price = price;
        this.expectedType = expectedType;
        this.expectedName = expectedName;
        this.expectedPrice = expectedPrice;
    }

    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][]{
                {SAUCE, "space sauce", 80, SAUCE, "space sauce", 80},
                {SAUCE, "galactic sauce", 15, SAUCE, "galactic sauce", 15},
                {SAUCE, "space-x sauce", 90, SAUCE, "space-x sauce", 90},
                {FILLING, "bun r2-d3", 988, FILLING, "bun r2-d3", 988},
                {FILLING, "asteriod cheese", 4142, FILLING, "asteriod cheese", 4142},
                {FILLING, "protostomia meat", 1337, FILLING, "protostomia meat", 1337}
        };
    }

    @Test
    public void checkGetName() {
        Ingredient ingredient = new Ingredient(type, name, price);
        String actualName = ingredient.getName();
        assertEquals(expectedName, actualName);
    }

    @Test
    public void checkGetType() {
        Ingredient ingredient = new Ingredient(type, name, price);
        IngredientType actualType = ingredient.getType();
        assertEquals(expectedType, actualType);
    }

    @Test
    public void checkGetPrice() {
        Ingredient ingredient = new Ingredient(type, name, price);
        float actualPrice = ingredient.getPrice();
        assertEquals(expectedPrice, actualPrice, 0.0);
    }
}