import org.apache.commons.lang3.RandomStringUtils;
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
public class IngredientTypeTest {

    private final IngredientType expectedIngredient;

    public IngredientTypeTest (IngredientType ingredientType) {
        this.expectedIngredient = ingredientType;
    }

    @Parameterized.Parameters (name = "Тестовые данные: {0}")
    public static Object[][] getData() {
        return new Object[][] {
                {SAUCE},
                {FILLING}
        };
    }

    @Test
    public void testGetIngredientTypeReturnAllIngredientType () {
        Random random = new Random();
        Ingredient actualIngredient = new Ingredient(expectedIngredient, RandomStringUtils.randomAlphabetic(10), random.nextFloat()*100);
        Assert.assertEquals("Error in IngredientType class getType() method", expectedIngredient, actualIngredient.getType());
    }

}
