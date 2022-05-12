package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

public class BurgerTest {
    private final String bunName = "Цельнозерновая";
    private final float bunPrice = 55.0f;
    private final IngredientType sauceType = SAUCE;
    private final IngredientType fillingType = FILLING;
    private final String sauceName = "Chili";
    private final String fillingName = "Говядина";
    private final float intPrice = 150;
    private final float doublePrice = 22.0f;

    @Mock
    Bun bun = new Bun(bunName, bunPrice);

    Ingredient ingredient = new Ingredient(sauceType, sauceName, intPrice);
    Ingredient ingredient2 = new Ingredient(fillingType, fillingName, doublePrice);

    @Test
    public void setBuns() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        assertEquals(bun, burger.bun);
    }

    @Test
    public void addIngredient() {
        Burger burger = new Burger();
        int initialIngredientsCount = burger.ingredients.size();
        burger.addIngredient(ingredient);
        int updatedIngredientsCount = burger.ingredients.size();
        assertEquals(initialIngredientsCount, updatedIngredientsCount - 1);
    }

    @Test
    public void removeIngredient() {
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        int initialIngredientsCount = burger.ingredients.size();
        burger.removeIngredient(initialIngredientsCount - 1);
        int updatedIngredientsCount = burger.ingredients.size();
        assertEquals(initialIngredientsCount - 1, updatedIngredientsCount);
    }

    @Test
    public void moveIngredient() {
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        int initialIngredientIndex = burger.ingredients.size() - 1;
        int newIngredientIndex = 0;
        burger.moveIngredient(initialIngredientIndex, newIngredientIndex);
        Ingredient newIngredient = burger.ingredients.get(newIngredientIndex);
        assertEquals(ingredient, newIngredient);
    }

    @Test
    public void getPrice() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient2);
        float expectedPrice = burger.getPrice();
        float actualPrice = bun.getPrice() * 2 + ingredient.getPrice() + ingredient2.getPrice();
        assertEquals(expectedPrice, actualPrice, 0);
    }

    @Test
    public void getReceipt() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient2);
        boolean receiptText = burger.getReceipt().contains(bun.name) & burger.getReceipt().contains(ingredient.name) & burger.getReceipt().contains(ingredient2.name) & burger.getReceipt().contains("Price");
        assertTrue(receiptText);
    }

}