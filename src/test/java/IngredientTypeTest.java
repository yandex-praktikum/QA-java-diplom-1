import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.IngredientType;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;


@RunWith(Parameterized.class)
public class IngredientTypeTest {

    private final String ingredient;
    private final boolean expectedResult;

    public IngredientTypeTest(String ingredient, boolean expectedResult){
        this.ingredient = ingredient;
        this.expectedResult = expectedResult;
    }

    @Parameterized.Parameters
    public static Object[][] checkResult(){
        return new Object[][]{
                {"SAUCE",  true},
                {"FILLING", true}
        };
    }

    @Test
    public void shouldCheckIngredient(){
        IngredientType[] ingredientTypes = IngredientType.values();
        boolean actualResult = Arrays.toString(ingredientTypes).contains(ingredient);
        assertEquals(expectedResult, actualResult);
    }
}