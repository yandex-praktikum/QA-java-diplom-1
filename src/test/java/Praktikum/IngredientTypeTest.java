package Praktikum;

import org.junit.Test;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

public class IngredientTypeTest {
    @Test
    public void TestGetSauceTypeIsCorrect(){
        assertEquals(IngredientType.valueOf("SAUCE"),IngredientType.SAUCE);
    }

    @Test
    public void TestGetFillingTypeIsCorrect(){
        assertEquals(IngredientType.valueOf("FILLING"),IngredientType.FILLING);
    }
}
