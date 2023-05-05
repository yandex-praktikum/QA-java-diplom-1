package ru.yandex.praktikum;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class IngredientTypeTests {
    @Test
    public void valueOfIngredientTypeTest() {
        assertEquals(IngredientType.SAUCE, IngredientType.valueOf("SAUCE"));
        assertEquals(IngredientType.FILLING, IngredientType.valueOf("FILLING"));
    }
}