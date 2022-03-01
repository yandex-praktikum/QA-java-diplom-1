package praktikum.ingredientTestSuit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class GetTypeIngredientTest {
    private final IngredientType testIngredientType;

    public GetTypeIngredientTest(IngredientType testIngredientType) {
        this.testIngredientType = testIngredientType;
    }

    @Parameterized.Parameters
    public static Object[][] getTypeParameters() {
        return new Object[][]{
                {SAUCE},
                {FILLING}
        };
    }

    @Test
    public void getTypeIngredientTest() {
        Ingredient testIngredient = new Ingredient(testIngredientType, "Szechuan Sauce", 420);
        assertEquals(testIngredientType, testIngredient.getType());
    }
}


