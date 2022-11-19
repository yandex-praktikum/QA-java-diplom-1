import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.*;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)

public class BurgerTest {

    @Mock
    Database database;

    @Mock
    Bun bun;

    @Mock
    Ingredient ingredient;

     /**
     * Проверка добавления ингредиентов
     */
    @Test
    public void addIngredientsTest(){
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
    public void removeIngredientsTest(){
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
    public void moveIngredientsTest(){
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

    /**
     * Проверка, что метод возвращает чек с информацией о бургере
     */
    @Test
    public void getReceiptTest() {
//        Mockito.when(bun.getName()).thenReturn("red bun");
//        Burger.setBuns(bun);
//        Mockito.when(ingredient.getType()).thenReturn(IngredientType.SAUCE);
//        Mockito.when(ingredient.getName()).thenReturn("sausage");
//        Mockito.when(bun.getPrice()).thenReturn(300F);
//        Mockito.when(ingredient.getPrice()).thenReturn(300F);
//        Burger burger = new Burger();
//        assertEquals(true, burger.getReceipt().contains("red bun")); // todo: проверить формат

    }
}
