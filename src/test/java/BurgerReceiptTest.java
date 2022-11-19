import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.*;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class BurgerReceiptTest {

    @Mock
    Database database;

    @Mock
    Bun bun;

    @Mock
    Ingredient ingredient;

    /**
     * Проверка чека бургера без ингредиентов
     */
    @Test
    public void OnlyBunTest(){
        // Arrange
        Burger burger = new Burger();
        Mockito.when(bun.getName()).thenReturn("black bun");
        Mockito.when(bun.getPrice()).thenReturn(100F);
        burger.setBuns(bun);

        // Act
        String actualReceipt = burger.getReceipt();

        // Assert
        String expectedReceipt = "(==== black bun ====)\r\n" +
                "(==== black bun ====)\r\n" +
                "\r\n" +
                "Price: 200,000000\r\n";
        assertEquals(expectedReceipt, actualReceipt);
    }

    /**
     * Проверка чека бургера с одним ингредиентом
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
        String actualReceipt = burger.getReceipt();

        // Assert
        String expectedReceipt = "(==== black bun ====)\r\n" +
                "= sauce hot sauce =\r\n" +
                "(==== black bun ====)\r\n" +
                "\r\n" +
                "Price: 250,000000\r\n";
        assertEquals(expectedReceipt, actualReceipt);
    }

    /**
     * Проверка чека бургера с несколькими ингредиентами
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
        String actualReceipt = burger.getReceipt();

        // Assert
        String expectedReceipt = "(==== black bun ====)\r\n" +
                "= filling cutlet =\r\n" +
                "= sauce sour cream =\r\n" +
                "= filling sausage =\r\n" +
                "(==== black bun ====)\r\n" +
                "\r\n" +
                "Price: 800,000000\r\n";
        assertEquals(expectedReceipt, actualReceipt);
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
        String actualReceipt = burger.getReceipt();

        // Assert
        String expectedReceipt = "(==== black bun ====)\r\n" +
                "= filling cutlet =\r\n" +
                "= sauce sour cream =\r\n" +
                "(==== black bun ====)\r\n" +
                "\r\n" +
                "Price: 500,000000\r\n";
        assertEquals(expectedReceipt, actualReceipt);
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
        String actualReceipt = burger.getReceipt();

        // Assert
        String expectedReceipt = "(==== black bun ====)\r\n" +
                "= sauce sour cream =\r\n" +
                "= filling sausage =\r\n" +
                "= filling cutlet =\r\n" +
                "(==== black bun ====)\r\n" +
                "\r\n" +
                "Price: 800,000000\r\n";
        assertEquals(expectedReceipt, actualReceipt);
    }
}
