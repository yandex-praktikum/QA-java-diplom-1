package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class IngredientTest {

    private Ingredient ingredient;
    private static IngredientType type;
    private final String name;
    private final float price;

    @Before
    public void beforeBenTest() {
        ingredient = new Ingredient(type, name, price);
    }

    public IngredientTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters()
    public static Object[][] getTypeNameAndPrice() {
        return new Object[][] {
                {type.SAUCE, "Sausage", (float) 57.32},
                {type.FILLING, "Кетчуп", (float) 17.99}
        };
    }

    @Test
    public void getPriceTest() {
        assertEquals("Price of ingredient is not correct", price, ingredient.getPrice(), 0.0f);
    }

    @Test
    public void getNameTest() {
        assertEquals("Name of ingredient is not correct", name, ingredient.getName());
    }

    @Test
    public void getTypeTest() {
        assertEquals("Type of ingredient is not correct", type, ingredient.getType());
    }
}