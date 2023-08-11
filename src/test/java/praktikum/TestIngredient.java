package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class TestIngredient {

    Ingredient ingredient;
    private final IngredientType type;
    private final String name;
    private final float price;

    public TestIngredient(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] ingredientData() {
        return new Object[][]{
                {SAUCE, "hot sauce", 100},
                {SAUCE, "chili sauce", 300},
                {FILLING, "dinosaur", 200},
                {FILLING, "sausage", 300}
        };
    }

    @Before
    public void setUp() {
        ingredient = new Ingredient(type, name, price);
    }

    @Test
    public void testGetPrice() {
        float expectedPrice = price;
        float actualPrice = ingredient.getPrice();
        assertEquals("Неверная цена", expectedPrice, actualPrice, 0);
    }

    @Test
    public void testGetName() {
        String expectedName = name;
        String actualName = ingredient.getName();
        assertEquals("Неверное название", expectedName, actualName);
    }

    @Test
    public void testGetType() {
        IngredientType expectedType = type;
        IngredientType actualType = ingredient.getType();
        assertEquals("Неверный тип ингридиента", expectedType, actualType);
    }

}
