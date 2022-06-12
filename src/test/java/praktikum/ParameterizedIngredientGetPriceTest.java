package praktikum;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class ParameterizedIngredientGetPriceTest {

    private IngredientType ingredientType;
    private final String ingredientName;
    private final float ingredientPrice;

    public ParameterizedIngredientGetPriceTest(IngredientType ingredientType, String ingredientName, float ingredientPrice) {
        this.ingredientType = ingredientType;
        this.ingredientName = ingredientName;
        this.ingredientPrice = ingredientPrice;
    }

    @Parameterized.Parameters( name = "{0} - ingredientName, " +
            "{1} - ingredientPrice, {2} - ingredientType")

    public static Object[][] ingredientTestFields() {
        return new Object[][] {
                {IngredientType.FILLING, "ingredientName", 15F},
                {IngredientType.FILLING, "ingredientName", 0},
                {IngredientType.FILLING, "ingredientName", -1.5f},
                {IngredientType.FILLING, "ingredientName", 0.000001F},
                {IngredientType.FILLING, "ingredientName", 1.456f},
               // {IngredientType.FILLING, "ingredientName", null}
        };
    }

    @Test
    public void getPriceTest() {
        Ingredient ingredient1 = new Ingredient(ingredientType, ingredientName, ingredientPrice);
        float actual = ingredient1.getPrice();
        assertEquals(ingredientPrice, actual, 1.0F);
    }
}



