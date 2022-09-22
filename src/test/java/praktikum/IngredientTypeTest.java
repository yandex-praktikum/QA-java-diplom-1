package praktikum;

import org.junit.Assert;
import org.junit.Test;

public class IngredientTypeTest {

    @Test
    public void valuesTest() {
        String expected = "SAUCE";
        String actual = String.valueOf(IngredientType.valueOf("SAUCE"));
        Assert.assertEquals(expected, actual);
    }
}