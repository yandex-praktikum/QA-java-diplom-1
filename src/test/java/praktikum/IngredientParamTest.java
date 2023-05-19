package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientParamTest {
    private Ingredient ingredient;
    private final String name;
    private final float price;
    private final IngredientType ingredientType;

    public IngredientParamTest(IngredientType ingredientType, String name, float price) {
        this.name = name;
        this.price = price;
        this.ingredientType = ingredientType;
    }

    @Parameterized.Parameters(name = "Данные для теста {0} {1} {2}")
    public static Object[][] getIngredientData() {
        return new Object[][] {
                {IngredientType.FILLING, "Вкусненькая котлета", 10.21313f},
                {IngredientType.SAUCE, "!№;?%*№(№(;?№-_", 5.1312f},
                {null, "asddasaasdasdas", 100},
                {IngredientType.FILLING, "3123131123123", 23.123124151242f},
                {IngredientType.SAUCE, null, -10},
                {IngredientType.FILLING, "", 0},
        };
    }

    @Before
    public void setUp() {
        ingredient = new Ingredient(ingredientType, name, price);
    }

    @Test
    public void getPrice() {
        assertEquals("Цены не совпадают", price, ingredient.getPrice(), 0);
    }

    @Test
    public void getName() {
        assertEquals("Названия не совпадают", name, ingredient.getName());
    }

    @Test
    public void getType() {
        assertEquals("Типы ингредиента не совпадают", ingredientType, ingredient.getType());
    }
}