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
    Bun bun;

    @Mock
    Ingredient ingredient;

    /**
     * Проверка чека бургера без ингредиентов
     */
    @Test
    public void OnlyBunTest(){
        Burger burger = new Burger();
        Mockito.when(bun.getName()).thenReturn("black bun");
        Mockito.when(bun.getPrice()).thenReturn(100F);
        burger.setBuns(bun);

        String actualReceipt = burger.getReceipt();

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
        Burger burger = new Burger();
        Mockito.when(bun.getName()).thenReturn("black bun");
        Mockito.when(bun.getPrice()).thenReturn(100F);
        burger.setBuns(bun);

        Mockito.when(ingredient.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredient.getName()).thenReturn("hot sauce");
        Mockito.when(ingredient.getPrice()).thenReturn(50F);
        burger.addIngredient(ingredient);

        String actualReceipt = burger.getReceipt();

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
        Burger burger = new Burger();
        Mockito.when(bun.getName()).thenReturn("black bun");
        Mockito.when(bun.getPrice()).thenReturn(100F);
        burger.setBuns(bun);

        burger.addIngredient(new Ingredient(IngredientType.FILLING, "cutlet", 100));
        burger.addIngredient(new Ingredient(IngredientType.SAUCE, "sour cream", 200));
        burger.addIngredient(new Ingredient(IngredientType.FILLING, "sausage", 300));

        String actualReceipt = burger.getReceipt();

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
        Burger burger = new Burger();
        Mockito.when(bun.getName()).thenReturn("black bun");
        Mockito.when(bun.getPrice()).thenReturn(100F);
        burger.setBuns(bun);

        burger.addIngredient(new Ingredient(IngredientType.FILLING, "cutlet", 100));
        burger.addIngredient(new Ingredient(IngredientType.SAUCE, "sour cream", 200));
        burger.addIngredient(new Ingredient(IngredientType.FILLING, "sausage", 300));
        burger.removeIngredient(2);

        String actualReceipt = burger.getReceipt();

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
        Burger burger = new Burger();
        Mockito.when(bun.getName()).thenReturn("black bun");
        Mockito.when(bun.getPrice()).thenReturn(100F);
        burger.setBuns(bun);

        burger.addIngredient(new Ingredient(IngredientType.FILLING, "cutlet", 100));
        burger.addIngredient(new Ingredient(IngredientType.SAUCE, "sour cream", 200));
        burger.addIngredient(new Ingredient(IngredientType.FILLING, "sausage", 300));
        burger.moveIngredient(0, 2);

        String actualReceipt = burger.getReceipt();

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
