package praktikum;

import org.junit.Assert;
import org.junit.Test;

public class IngredientTypeTest {

    @Test
    public void ingredientTypeSauceTest() {
        Assert.assertNotNull(IngredientType.valueOf("SAUCE"));
    }

    @Test
    public void ingredientTypeFillingTest() {
        Assert.assertNotNull(IngredientType.valueOf("FILLING"));
    }
}
