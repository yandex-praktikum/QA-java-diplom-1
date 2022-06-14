package praktikum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ParameterizedIngredientGetNameTest {

    private IngredientType ingredientType;
    private final String ingredientName;
    private final Float ingredientPrice;

    public ParameterizedIngredientGetNameTest(IngredientType ingredientType, String ingredientName, Float ingredientPrice) {
        this.ingredientType = ingredientType;
        this.ingredientName = ingredientName;
        this.ingredientPrice = ingredientPrice;
    }

    @Parameterized.Parameters( name = "{0} - ingredientName, " +
            "{1} - ingredientPrice, {2} - ingredientType")

    public static Object[][] ingredientTestFields() {
        return new Object[][] {
                {IngredientType.FILLING, "ingredientName", 15F},
                {IngredientType.FILLING, "veryLongStringTestveryLongStringTestveryLongStringTestveryLongStringTestveryLongStringTest" +
                        "veryLongStringTestveryLongStringTestveryLongStringTestveryLongStringTestveryLongStringTest" +
                        "veryLongStringTestveryLongStringTestveryLongStringTestveryLongStringTestveryLongStringTest" +
                        "veryLongStringTestveryLongStringTestveryLongStringTestveryLongStringTestveryLongStringTest" +
                        "veryLongStringTestveryLongStringTestveryLongStringTestveryLongStringTestveryLongStringTest" +
                        "veryLongStringTestveryLongStringTestveryLongStringTestveryLongStringTestveryLongStringTest" +
                        "veryLongStringTestveryLongStringTestveryLongStringTestveryLongStringTestveryLongStringTest", 15F},
                {IngredientType.FILLING, null, 15F}
        };
    }

    @Test
    public void getPriceTest() {
        Ingredient ingredient1 = new Ingredient(ingredientType, ingredientName, ingredientPrice);
        String actual = ingredient1.getName();
        assertEquals(ingredientName, actual);
    }
}



