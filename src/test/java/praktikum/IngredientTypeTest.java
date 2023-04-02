package praktikum;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class IngredientTypeTest {

    @Test
    public void valuesSauce() {
        IngredientType actual = IngredientType.SAUCE;
        IngredientType excepted = IngredientType.valueOf("SAUCE");
        Assert.assertEquals("Error valuesSauce",excepted,actual);
    }

    @Test
    public void valueFilling() {
        IngredientType actual = IngredientType.FILLING;
        IngredientType excepted = IngredientType.valueOf("FILLING");
        Assert.assertEquals("Error valueFilling",excepted,actual);
    }
}