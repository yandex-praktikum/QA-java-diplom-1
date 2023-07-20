package praktikum;

import org.junit.Assert;
import org.junit.Test;
public class IngredientTypeTest {

    @Test
    public void toStringTest() {
        Assert.assertEquals("SAUCE", IngredientType.SAUCE.toString());
        Assert.assertEquals("FILLING", IngredientType.FILLING.toString());
    }
}
