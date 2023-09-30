package praktikum.test;

import org.junit.Assert;
import org.junit.Test;
import praktikum.IngredientType;

public class IngredientTypeTest {
    private String SAUCE = "SAUCE";
    private String FILLING = "FILLING";

    @Test
    public void testSauceEnumValue() {
        Assert.assertEquals(SAUCE, IngredientType.SAUCE.name());
    }

    @Test
    public void testFillingEnumValue() {
        Assert.assertEquals(FILLING, IngredientType.FILLING.name());
    }
}
