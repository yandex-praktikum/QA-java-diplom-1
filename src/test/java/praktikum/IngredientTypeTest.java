package praktikum;

import org.junit.Assert;
import org.junit.Test;

public class IngredientTypeTest {
    @Test
    public void checkIngredients() {
        Assert.assertEquals("SAUCE", String.valueOf(IngredientType.SAUCE));
        Assert.assertEquals("FILLING", String.valueOf(IngredientType.FILLING));
    }
}
