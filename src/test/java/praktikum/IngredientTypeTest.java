package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;


@RunWith(Parameterized.class)
public class IngredientTypeTest {

    @Parameterized.Parameter
    public IngredientType typeIngredient;

    @Parameterized.Parameter(1)
    public String nameIngredient;

    @Parameterized.Parameter(2)
    public float priceIngredient;

    @Parameterized.Parameter(3)
    public String excepted;

    @Parameterized.Parameters(name = "{0} {1}, price = {2}")
    public static Object[][] dataBun() {
        return new Object[][]{
                {SAUCE, "горчица", 20, "SAUCE"},
                {FILLING, "salmon", 100.29f, "FILLING"},
        };
    }

    @Test
    public void ingredientTest(){
        Ingredient ingredient = new Ingredient(typeIngredient, nameIngredient, priceIngredient);
        Assert.assertEquals(excepted, ingredient.getType().toString());
    }

}
