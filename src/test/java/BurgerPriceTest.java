import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.*;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class BurgerPriceTest {

    @Mock
    Database database;

    @Mock
    Bun bun;

    @Mock
    Ingredient ingredient;

    /**
     * Проверка цены бургера без ингредиентов
     */
    @Test
    public void OnlyBunTest(){
        // Arrange
        Burger burger = new Burger();
        Mockito.when(bun.getName()).thenReturn("black bun");
        Mockito.when(bun.getPrice()).thenReturn(100F);
        burger.setBuns(bun);

        // Act
        float actualPrice = burger.getPrice();

        // Assert
        float expectedPrice = 200;
        assertEquals(expectedPrice, actualPrice, 0.05);
    }

    /**
     * Проверка цены бургера с одним ингредиентом
     */
    @Test
    public void OneIngredientTest(){
        // Arrange
        Burger burger = new Burger();
        Mockito.when(bun.getName()).thenReturn("black bun");
        Mockito.when(bun.getPrice()).thenReturn(100F);
        burger.setBuns(bun);

        Mockito.when(ingredient.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredient.getName()).thenReturn("hot sauce");
        Mockito.when(ingredient.getPrice()).thenReturn(50F);
        burger.addIngredient(ingredient);

        // Act
        float actualPrice = burger.getPrice();

        // Assert
        float expectedPrice = 250;
        assertEquals(expectedPrice, actualPrice, 0.05);
    }

    /**
     * Проверка цены бургера с несколькими ингредиентами
     */
    @Test
    public void MultipleIngredientsTest(){
        // Arrange
        Burger burger = new Burger();
        Mockito.when(bun.getName()).thenReturn("black bun");
        Mockito.when(bun.getPrice()).thenReturn(100F);
        burger.setBuns(bun);

        burger.addIngredient(new Ingredient(IngredientType.FILLING, "cutlet", 100));
        burger.addIngredient(new Ingredient(IngredientType.SAUCE, "sour cream", 200));
        burger.addIngredient(new Ingredient(IngredientType.FILLING, "sausage", 300));

        // Act
        float actualPrice = burger.getPrice();

        // Assert
        float expectedPrice = 800;
        assertEquals(expectedPrice, actualPrice, 0.05);
    }

    /**
     * Проверка цены бургера при удалении ингредиента
     */
    @Test
    public void RemoveIngredientsTest(){
        // Arrange
        Burger burger = new Burger();
        Mockito.when(bun.getName()).thenReturn("black bun");
        Mockito.when(bun.getPrice()).thenReturn(100F);
        burger.setBuns(bun);

        burger.addIngredient(new Ingredient(IngredientType.FILLING, "cutlet", 100));
        burger.addIngredient(new Ingredient(IngredientType.SAUCE, "sour cream", 200));
        burger.addIngredient(new Ingredient(IngredientType.FILLING, "sausage", 300));
        burger.removeIngredient(2);

        // Act
        float actualPrice = burger.getPrice();

        // Assert
        float expectedPrice = 500;
        assertEquals(expectedPrice, actualPrice, 0.05);
    }

    /**
     * Проверка неизменяемости цены бургера при перемещении ингредиентов
     */
    @Test
    public void MoveIngredientsTest(){
        // Arrange
        Burger burger = new Burger();
        Mockito.when(bun.getName()).thenReturn("black bun");
        Mockito.when(bun.getPrice()).thenReturn(100F);
        burger.setBuns(bun);

        burger.addIngredient(new Ingredient(IngredientType.FILLING, "cutlet", 100));
        burger.addIngredient(new Ingredient(IngredientType.SAUCE, "sour cream", 200));
        burger.addIngredient(new Ingredient(IngredientType.FILLING, "sausage", 300));
        burger.moveIngredient(0, 2);

        // Act
        float actualPrice = burger.getPrice();

        // Assert
        float expectedPrice = 800;
        assertEquals(expectedPrice, actualPrice, 0.05);
    }
}
