package praktikum.stellar_burgers;

import org.junit.Assert;
import org.junit.Test;
import praktikum.IngredientType;

public class IngredientTypeTest {
    @Test
    public void ingredientTypeContainsSauceValue() {
        Assert.assertNotNull(IngredientType.valueOf("SAUCE"));
    }

    @Test
    public void ingredientTypeContainsFillingValue() {
        Assert.assertNotNull(IngredientType.valueOf("FILLING"));
    }
}