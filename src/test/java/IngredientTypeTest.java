import net.bytebuddy.utility.RandomString;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.Random;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class IngredientTypeTest {

    private IngredientType ingredientType;

    public void IngredientsTypeTest(IngredientType ingredientType) {
        this.ingredientType = ingredientType;
    }

    public IngredientTypeTest(IngredientType ingredientType) {
        this.ingredientType = ingredientType;
    }

    @Parameterized.Parameters
    public static Object[][] getIngredient() {
        return new Object[][] {
                {SAUCE},
                {FILLING}
        };
    }

    @Test
    public void getIngredientTypeTest(){
        Ingredient ingredient = new Ingredient(ingredientType, RandomString.make(10), new Random().nextFloat());
        assertEquals(ingredientType, ingredient.getType());
    }
}

