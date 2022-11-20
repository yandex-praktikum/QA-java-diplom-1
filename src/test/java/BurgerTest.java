import org.junit.Test;

import praktikum.*;

import static org.junit.Assert.assertEquals;

public class BurgerTest {

    /**
     * Проверка добавления ингредиентов
     */
    @Test
    public void addIngredientsTest() {
        // Arrange
        Burger burger = new Burger();
        burger.addIngredient(new Ingredient(IngredientType.FILLING, "cutlet", 100));
        burger.addIngredient(new Ingredient(IngredientType.SAUCE, "sour cream", 200));
        burger.addIngredient(new Ingredient(IngredientType.FILLING, "sausage", 300));

        // Act
        int actualCount = burger.ingredients.size();

        // Assert
        int expectedCount = 3;
        assertEquals(expectedCount, actualCount);
    }

    /**
     * Проверка удаления ингредиентов
     */
    @Test
    public void removeIngredientsTest() {
        // Arrange
        Burger burger = new Burger();
        burger.addIngredient(new Ingredient(IngredientType.FILLING, "cutlet", 100));
        burger.addIngredient(new Ingredient(IngredientType.SAUCE, "sour cream", 200));
        burger.addIngredient(new Ingredient(IngredientType.FILLING, "sausage", 300));
        burger.removeIngredient(0);

        // Act
        int actualCount = burger.ingredients.size();

        // Assert
        int expectedCount = 2;
        assertEquals(expectedCount, actualCount);
    }

    /**
     * Проверка перемещения ингредиентов
     */
    @Test
    public void moveIngredientsTest() {
        // Arrange
        Burger burger = new Burger();
        burger.addIngredient(new Ingredient(IngredientType.FILLING, "cutlet", 100));
        burger.addIngredient(new Ingredient(IngredientType.SAUCE, "sour cream", 200));
        burger.addIngredient(new Ingredient(IngredientType.FILLING, "sausage", 300));
        burger.moveIngredient(0, 2);

        // Act
        int actualCount = burger.ingredients.size();

        // Assert
        int expectedCount = 3;
        assertEquals(expectedCount, actualCount);
    }
}
