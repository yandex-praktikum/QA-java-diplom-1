package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static praktikum.IngredientType.SAUCE;
import static praktikum.IngredientType.FILLING;

@RunWith(Parameterized.class)
public class ParameterizedIngredientTypeTest {



    private  final IngredientType ingredientType;

    public ParameterizedIngredientTypeTest (IngredientType ingredientType) {
        this.ingredientType = ingredientType;
    }

    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][] {
                {SAUCE},
                {FILLING}
        };
    }

    @Test
    public void getTypeIngredientTypeReturnType () {
        Ingredient ingredient = new Ingredient(ingredientType, "hot sauce", 100);
        Assert.assertEquals(ingredientType, ingredient.getType());
    }
}
