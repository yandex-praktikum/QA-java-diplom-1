import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class IngredientTest {

    private final IngredientType type;
    private final String name;
    private final float price;
    private final Ingredient expectIngredient;

    public IngredientTest(IngredientType type, String name, float price, Ingredient expectIngredient) {
        this.type = type;
        this.name = name;
        this.price = price;
        this.expectIngredient = expectIngredient;
    }

    @Parameterized.Parameters
    public static Object[][] testData() {
        return new Object[][] {
                {IngredientType.FILLING, "Test", 100500, new Ingredient(IngredientType.FILLING, "Test", 100500)},
                {IngredientType.SAUCE, "Test", 100500, new Ingredient(IngredientType.SAUCE, "Test", 100500)},
                {IngredientType.FILLING, null, 100500, new Ingredient(IngredientType.FILLING, null, 100500)},
                {IngredientType.SAUCE, null, 100500, new Ingredient(IngredientType.SAUCE, null, 100500)},
                {IngredientType.FILLING, "Test", 0, new Ingredient(IngredientType.FILLING, "Test", 0)},
                {IngredientType.SAUCE, "Test", 0, new Ingredient(IngredientType.SAUCE, "Test", 0)},
                {IngredientType.FILLING, "Test", -1, new Ingredient(IngredientType.FILLING, "Test", -1)},
                {IngredientType.SAUCE, "Test", -1, new Ingredient(IngredientType.SAUCE, "Test", -1)}
        };
    }

    @Test
    public void BunCreateTest() {
        Ingredient actualIngredient = new Ingredient(type, name, price);
        assertEquals(expectIngredient.getType(), actualIngredient.getType());
        assertEquals(expectIngredient.getName(), actualIngredient.getName());
        assertTrue(Math.abs(expectIngredient.getPrice() - actualIngredient.getPrice()) < 0.00001);
    }
}
