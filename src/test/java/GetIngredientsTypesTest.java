import net.bytebuddy.utility.RandomString;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.Random;

import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class GetIngredientsTypesTest {

    private final IngredientType ingredientType;

    public GetIngredientsTypesTest(IngredientType ingredientType) {
        this.ingredientType = ingredientType;
    }

    @Parameterized.Parameters
    public static Object[][] getHasMane() {
        return new Object[][] {
                {SAUCE},
                {FILLING}
        };
    }

    @Test
    public void canGetIngredientType(){
        Ingredient ingredient = new Ingredient(ingredientType, RandomString.make(10), new Random().nextFloat());
        Assert.assertEquals(ingredientType, ingredient.getType());
    }
}