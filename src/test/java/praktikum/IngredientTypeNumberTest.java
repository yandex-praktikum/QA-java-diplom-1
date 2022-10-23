package praktikum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IngredientTypeNumberTest {

    @Test
    public void checkNumberOfElementsInIngredientTypeEnum2 () {
        int actualNumber = IngredientType.values().length;
        int expectedNumber = 2;
        assertEquals("Число типов ингредиентов должно быть 2", expectedNumber, actualNumber);
    }
}
