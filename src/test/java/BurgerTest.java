import org.junit.Test;

import praktikum.*;

import static org.junit.Assert.assertEquals;

public class BurgerTest {

    /**
     * Проверка добавления ингредиентов
     */
    @Test
    public void addIngredientsTest() {
        Burger burger = new Burger();
        burger.addIngredient(new Ingredient(IngredientType.FILLING, "cutlet", 100));
        burger.addIngredient(new Ingredient(IngredientType.SAUCE, "sour cream", 200));
        burger.addIngredient(new Ingredient(IngredientType.FILLING, "sausage", 300));

        int actualCount = burger.ingredients.size();

        int expectedCount = 3;
        assertEquals(expectedCount, actualCount);
    }

    /**
     * Проверка удаления ингредиентов
     */
    @Test
    public void removeIngredientsTest() {
        Burger burger = new Burger();
        burger.addIngredient(new Ingredient(IngredientType.FILLING, "cutlet", 100));
        burger.addIngredient(new Ingredient(IngredientType.SAUCE, "sour cream", 200));
        burger.addIngredient(new Ingredient(IngredientType.FILLING, "sausage", 300));
        burger.removeIngredient(0);

        int actualCount = burger.ingredients.size();

        int expectedCount = 2;
        assertEquals(expectedCount, actualCount);
    }

    /**
     * Проверка перемещения ингредиентов
     */
    @Test
    public void moveIngredientsTest() {
        Burger burger = new Burger();
        burger.addIngredient(new Ingredient(IngredientType.FILLING, "cutlet", 100));
        burger.addIngredient(new Ingredient(IngredientType.SAUCE, "sour cream", 200));
        burger.addIngredient(new Ingredient(IngredientType.FILLING, "sausage", 300));
        burger.moveIngredient(0, 2);

        int actualCount = burger.ingredients.size();

        int expectedCount = 3;
        assertEquals(expectedCount, actualCount);
    }
}
