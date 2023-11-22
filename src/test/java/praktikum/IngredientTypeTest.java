package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class IngredientTypeTest {
    private final String ingredient;
    private final boolean inList;

    public IngredientTypeTest(String ingredient, boolean inList) {
        this.ingredient = ingredient;
        this.inList = inList;
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

        } catch (IllegalArgumentException e) {
            System.out.println("Unknow ingredient");
        }
    }
}
