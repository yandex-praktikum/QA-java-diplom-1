import org.junit.Assert;
import org.junit.Test;
import praktikum.IngredientType;

import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

public class IngredientTypeTest {

    IngredientType ingredientType;

    @Test
    public void sauceIsNotNull() {
        Assert.assertNotNull(ingredientType.valueOf(String.valueOf(SAUCE)));
    }

    @Test
    public void fillingIsNotNull() {
        Assert.assertNotNull(ingredientType.valueOf(String.valueOf(FILLING)));
    }
}
