package praktikum;

import org.junit.Assert;
import org.junit.Test;


public class IngredientTypeTest {

    @Test
    public void values() {
        Assert.assertNotNull(IngredientType.values());
    }

    @Test
    public void valueOf() {
        Assert.assertEquals(IngredientType.SAUCE, IngredientType.valueOf("SAUCE"));
    }
}