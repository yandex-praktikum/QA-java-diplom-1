package ru.yandex.praktikum;

import org.junit.Test;
import praktikum.IngredientType;

import static org.junit.Assert.*;

public class IngredientTypeTest {

    @Test
    public void CheckTypeSauceTest()
    {
        assertEquals(IngredientType.SAUCE, IngredientType.valueOf("SAUCE"));
    }

    @Test
    public void CheckTypeFillingTest()
    {
        assertEquals(IngredientType.FILLING, IngredientType.valueOf("FILLING"));
    }

}