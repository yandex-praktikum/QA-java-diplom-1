package ru.yandex.practicum.tests;

import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

public class IngredientTest {

    @Test
    public void getNameReturnsCorrectValue() {
        String expectedName = "Томатный";
        Ingredient ingredient = new Ingredient(SAUCE, expectedName, 5.25f);
        assertEquals("The ingredient name does not match the expected result", expectedName, ingredient.getName());
    }

    @Test
    public void getPriceReturnsCorrectValue() {
        float expectedPrice = 6.7f;
        Ingredient ingredient = new Ingredient(SAUCE, "Кисло-сладкий", expectedPrice);
        assertEquals("The ingredient price does not match the expected result", expectedPrice, ingredient.getPrice(), 0);
    }

    @Test
    public void getTypeReturnsCorrectValue() {
        IngredientType expectedType = FILLING;
        Ingredient ingredient = new Ingredient(expectedType, "Чили", 9.35f);
        assertEquals("The ingredient type does not match the expected result", expectedType, ingredient.getType());
    }
}
