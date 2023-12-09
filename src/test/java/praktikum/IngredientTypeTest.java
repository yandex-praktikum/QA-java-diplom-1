package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class IngredientTypeTest {
    private final String ingredient;
    private boolean expectedInList;
    private boolean actualInList;
    private Ingredient ingredientSause;
    private Ingredient ingredientFilling;

    public IngredientTypeTest(String ingredient, boolean expectedInList) {
        this.ingredient = ingredient;
        this.expectedInList = expectedInList;
    }

    @Parameterized.Parameters
    public static Object[][] ingredients() {
        return new Object[][]{
                {"SAUCE", true},
                {"FILLING", true},
                {"SYRUP", false},
                {"$#^", false}
        };
    }

    @Test
    public void ingredientTypeTest() {

        try {
            IngredientType.valueOf(ingredient);
            actualInList = true;
        } catch (IllegalArgumentException e) {
            System.out.println("Unknow ingredient");
            actualInList = false;
        }
        Assert.assertEquals(expectedInList, actualInList);
    }
}
