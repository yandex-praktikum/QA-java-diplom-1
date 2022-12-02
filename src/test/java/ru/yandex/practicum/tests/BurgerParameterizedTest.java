package ru.yandex.practicum.tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BurgerParameterizedTest {

    private final float bunPrice;
    private final float meatPrice;
    private final float cheesePrice;
    private final float mustardPrice;

    public BurgerParameterizedTest(float bunPrice, float meatPrice, float cheesePrice, float mustardPrice) {
        this.bunPrice = bunPrice;
        this.meatPrice = meatPrice;
        this.cheesePrice = cheesePrice;
        this.mustardPrice = mustardPrice;
    }

    @Parameterized.Parameters
    public static Object[][] getTestData() {

        return new Object[][] {
                {20f, 51f, 28f, 9f},
                {19.5f, 50.5f, 28.3f, 9.1f},
                {19.57f, 50.54f, 28.39f, 9.18f}
        };
    }

    @Test
    public void getPriceReturnsCorrectValue() {
        Burger burger = new Burger();
        Bun bun = new Bun("Пшеничная", bunPrice);
        Ingredient meat = new Ingredient(IngredientType.FILLING, "Котлета", meatPrice);
        Ingredient cheese = new Ingredient(IngredientType.FILLING, "Сыр", cheesePrice);
        Ingredient mustard = new Ingredient(IngredientType.SAUCE, "Горчица", mustardPrice);
        burger.setBuns(bun);
        burger.ingredients.add(meat);
        burger.ingredients.add(cheese);
        burger.ingredients.add(mustard);
        float expectedPrice = 2 * bunPrice + meatPrice + cheesePrice + mustardPrice;
        assertEquals("The burger price does not match the expected result", expectedPrice, burger.getPrice(), 0);
    }
}
