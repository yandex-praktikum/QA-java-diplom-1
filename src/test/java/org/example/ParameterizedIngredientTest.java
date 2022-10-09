package org.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class ParameterizedIngredientTest {

    private Ingredient ingredient;
    private final IngredientType expectedType;
    private final String expectedName;
    private final float expectedPrice;

    public ParameterizedIngredientTest(IngredientType expectedType, String expectedName, float expectedPrice) {
        this.expectedType = expectedType;
        this.expectedName = expectedName;
        this.expectedPrice = expectedPrice;
    }

    @Before
    public void createObject() {
        ingredient = new Ingredient(expectedType, expectedName, expectedPrice);
    }

    @Parameterized.Parameters
    public static Object[][] getIngredientData() {
        return new Object[][] {
                {IngredientType.SAUCE, "_name", 136},
                {IngredientType.FILLING, "name ", 631},
        };
    }

    @Test
    public void getIngredientType() {
        IngredientType actual = ingredient.getType();
        assertEquals("Не верный тип ингредиента", expectedType, actual);
        System.out.println(actual);
    }

    @Test
    public void getIngredientName() {
        String actual = ingredient.getName();
        assertEquals("Некорректное имя", expectedName, actual);
        System.out.println(actual);
    }

    @Test
    public void getIngredientPrice() {
        float actual = ingredient.getPrice();
        assertEquals("Некорректная цена", expectedPrice, actual, 0);
        System.out.println(actual);
    }
}