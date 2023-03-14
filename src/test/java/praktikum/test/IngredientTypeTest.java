package praktikum.test;

import org.junit.Assert;
import org.junit.Test;
import praktikum.IngredientType;

import static org.junit.Assert.*;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

public class IngredientTypeTest {


    @Test
    public void valueOfTest() {
        Assert.assertEquals(SAUCE, IngredientType.valueOf("SAUCE"));
        assertEquals(FILLING, IngredientType.valueOf("FILLING"));
    }
}