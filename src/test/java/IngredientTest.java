import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTest {


    private Ingredient ingredient;
    private IngredientType ingredientType;
    private String ingredientName;
    private float ingredientPrice;

    public IngredientTest(IngredientType ingredientType, String ingredientName, float ingredientPrice) {
        this.ingredientType = ingredientType;
        this.ingredientName = ingredientName;
        this.ingredientPrice = ingredientPrice;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> testTata() {
        return Arrays.asList(new Object[][]{
                {IngredientType.FILLING, "Cheese", 1.5f},
                {IngredientType.SAUCE, "Ketchup", 0.5f}
        });
    }

    @Before
    public void setUp() {
        ingredient = new Ingredient(ingredientType, ingredientName, ingredientPrice);
    }

    @Test
    public void getPriceTest() {
        assertEquals(ingredientPrice, ingredient.getPrice(), 0.01);
    }

    @Test
    public void getNameTest() {
        assertEquals(ingredientName, ingredient.getName());
    }

    @Test
    public void getTypeTest() {
        assertEquals(ingredientType, ingredient.getType());
    }
}
