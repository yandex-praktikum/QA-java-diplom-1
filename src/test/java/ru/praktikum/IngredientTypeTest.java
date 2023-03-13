package ru.praktikum;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class IngredientTypeTest {
    @Test
    public void fillingNotNullTest() {
        assertNotNull("Начинки не указаны в ингредиентах", IngredientType.valueOf("FILLING"));
    }

    @Test
    public void sauceTest() {
        assert IngredientType.SAUCE != null;
    }

    @Test
    public void fillingTest() {
        assert IngredientType.FILLING != null;
    }
}
