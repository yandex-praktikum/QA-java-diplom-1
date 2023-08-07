import org.junit.Assert;
import org.junit.Test;

import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;


public class IngredientTypeTest {

    IngredientType[] values = IngredientType.values();

    @Test
    public void SauceTest() {
        assertEquals("Unknown IngredientType", "SAUCE", values[0].toString());
    }

    @Test
    public void FillingTest() {
        assertEquals("Unknown IngredientType", "FILLING", values[1].toString());
    }

    @Test
    public void typesNumberTest(){

        int expected = 2;
        int actual = values.length;

        Assert.assertEquals("Check IngredientTypes", expected, actual);
    }
}
