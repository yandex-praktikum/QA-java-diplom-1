package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTest {

    private final String ingredientName;
    private final float ingredientPrice;
    private final IngredientType ingredientType;
    Ingredient ingredient;

    public IngredientTest(IngredientType ingredientType, String ingredientName, float ingredientPrice) {
        this.ingredientName = ingredientName;
        this.ingredientPrice = ingredientPrice;
        this.ingredientType = ingredientType;
    }

    @Parameterized.Parameters
    public static Object[][] getIngredients() {
        return new Object[][]{
                {IngredientType.FILLING, "Бекон", 300},
                {IngredientType.SAUCE, "Сырный соус", 50}
        };
    }

    @Before
    public void setUp() {
        ingredient = new Ingredient(ingredientType, ingredientName, ingredientPrice);
    }

    @Test
    public void getPriceReturnsCorrectValue() {
        assertEquals(ingredient.getPrice(), ingredientPrice, 0);
    }

    @Test
    public void getNameReturnsCorrectValue() {
        assertEquals(ingredient.getName(), ingredientName);

    }

    @Test
    public void getTypeReturnsCorrectValue() {
        assertEquals(ingredient.getType(), ingredientType);
    }
}