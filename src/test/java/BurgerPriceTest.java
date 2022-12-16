import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.*;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.Silent.class)
public class BurgerPriceTest {

    @Mock
    Bun bun;

    @Mock
    Ingredient ingredient;

    /**
     * Проверка цены бургера без ингредиентов
     */
    @Test
    public void OnlyBunTest(){
        Burger burger = new Burger();
        Mockito.when(bun.getName()).thenReturn("black bun");
        Mockito.when(bun.getPrice()).thenReturn(100F);
        burger.setBuns(bun);

        float actualPrice = burger.getPrice();

        float expectedPrice = 200;
        assertEquals(expectedPrice, actualPrice, 0.05);
    }

    /**
     * Проверка цены бургера с одним ингредиентом
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

        float actualPrice = burger.getPrice();

        float expectedPrice = 250;
        assertEquals(expectedPrice, actualPrice, 0.05);
    }

    /**
     * Проверка цены бургера с несколькими ингредиентами
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

        float actualPrice = burger.getPrice();

        float expectedPrice = 800;
        assertEquals(expectedPrice, actualPrice, 0.05);
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

        float actualPrice = burger.getPrice();

        float expectedPrice = 500;
        assertEquals(expectedPrice, actualPrice, 0.05);
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

        float actualPrice = burger.getPrice();

        float expectedPrice = 800;
        assertEquals(expectedPrice, actualPrice, 0.05);
    }
}
