package praktikum;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class IngredientTypeTest {

    @Test
    public void valuesTest() {
        String expected = "SAUCE";
        String actual = String.valueOf(IngredientType.valueOf("SAUCE"));
        Assert.assertEquals(expected, actual);
    }


}