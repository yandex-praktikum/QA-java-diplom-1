package praktikum;

import net.bytebuddy.utility.RandomString;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Random;
import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class IngredientsTypeTest {

    private final IngredientType ingredientType;

    public IngredientsTypeTest(IngredientType ingredientType) {
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