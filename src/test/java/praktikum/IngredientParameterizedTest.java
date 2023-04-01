package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientParameterizedTest {

    private IngredientType type;
    private final String name;
    private final float price;

    public IngredientParameterizedTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters(name = "Тип, название, цена: {0}, {1}, {2}")
    public static Object[][] getIngredientData() {
        return new Object[][] {
                {IngredientType.SAUCE, "Garlic", 0.15f},
                {IngredientType.FILLING, "Cheese", 1},
        };
    }

    @Test
    public void getPriceReturnCorrectPrice() {
        Ingredient ingredient = new Ingredient(type, name, price);
        float expected = price;
        float actual = ingredient.getPrice();
        assertEquals("Проверка цены", expected, actual, 0.01);
    }

    @Test
    public void getNameReturnCorrectName() {
        Ingredient ingredient = new Ingredient(type, name, price);
        String expected = name;
        String actual = ingredient.getName();
        assertEquals("Проверка названия", expected, actual);
    }

    @Test
    public void getTypeReturnCorrectType() {
        Ingredient ingredient = new Ingredient(type, name, price);
        IngredientType expected = type;
        IngredientType actual = ingredient.getType();
        assertEquals("Проверка типа", expected, actual);
    }
}