package praktikum;

import org.junit.Test;

import static org.junit.Assert.*;

public class BurgerTest {
    @Test
    public void setBunsTest() {
        // given
        Bun bun = new Bun("булка", 1f);
        Burger burger = new Burger();

        // when
        burger.setBuns(bun);

        // then
        assertEquals(bun,burger.bun);
    }

    @Test
    public void addIngredientTest() {
        // given
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "Katchup", 1f);
        Burger burger = new Burger();

        // when
        burger.addIngredient(ingredient);

        // then
        assertTrue(burger.ingredients.contains(ingredient));
    }

    @Test
    public void removeIngredientTest() {
        // given
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "Katchup", 1f);
        Burger burger = new Burger();
        burger.addIngredient(ingredient);

        // when
        burger.removeIngredient(0);

        // then
        assertTrue(burger.ingredients.isEmpty());
    }

    @Test
    public void moveIngredientTest() {
        // given
        Ingredient firstIngredient = new Ingredient(IngredientType.SAUCE, "Katchup", 1f);
        Ingredient secondIngredient = new Ingredient(IngredientType.FILLING, "Cutlet", 3f);

        Burger burger = new Burger();
        burger.addIngredient(firstIngredient);
        burger.addIngredient(secondIngredient);

        // when
        burger.moveIngredient(1, 0);

        // then
        assertEquals(firstIngredient, burger.ingredients.get(1));
        assertEquals(secondIngredient, burger.ingredients.get(0));
    }

    @Test(expected = NullPointerException.class)
    public void returnNpeOnGetPriceWhenBunIsNotSet() {
        // given
        Burger burger = new Burger();

        // when
        burger.getPrice();

        // then exception is thrown
    }

    @Test(expected = NullPointerException.class)
    public void returnNpeOnGetReceiptWhenBunIsNotSet() {
        // given
        Burger burger = new Burger();

        // when
        burger.getReceipt();

        // then exception is thrown
    }
}