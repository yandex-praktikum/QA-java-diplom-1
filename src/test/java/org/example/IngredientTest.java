package org.example;

import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;

public class IngredientTest {
    @Test
    public void getRealPriceReturnsCorrectValue() {
        Ingredient ingredient = new Ingredient(FILLING, "Перец", 10F);
        float expectedRealPrice = 10F;
        float actualRealPrice = ingredient.getPrice();
        assertEquals("У ингридиента неверная цена", expectedRealPrice, actualRealPrice, 0);

    }

    @Test
    public void getRealNameReturnsCorrectValue() {
        Ingredient ingredient = new Ingredient(FILLING, "Перец", 10F);
        String expectedRealName = "Перец";
        String actualRealName = ingredient.getName();
        assertEquals("У ингридиента неверное название", expectedRealName, actualRealName);

    }

    @Test
    public void getRealTypeReturnsCorrectValue() {
        Ingredient ingredient = new Ingredient(FILLING, "Перец", 10F);
        IngredientType expectedRealType = FILLING;
        IngredientType actualRealType = ingredient.getType();
        assertEquals("У ингридиента неверный тип", expectedRealType, actualRealType);

    }
}
