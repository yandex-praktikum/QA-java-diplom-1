import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.*;

import static org.junit.Assert.*;
import static praktikum.IngredientType.FILLING;


@RunWith(MockitoJUnitRunner.class)
public class BurgerTests {

    @Mock
    Database database;
    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient;
    @Mock
    Ingredient cheese;
    @Mock
    Ingredient bacon;
    @Mock
    Ingredient egg;


    @Test
    public void addIngredientTest() {
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        System.out.println(burger.ingredients);
        assertTrue(burger.ingredients.contains(ingredient));
    }

    @Test
    public void removeIngredientTest() {
        Burger burger = new Burger();
        Ingredient cheese = new Ingredient(FILLING, "CHEESE", 33.45f);
        Ingredient bacon = new Ingredient(FILLING, "BACON", 54.4f);
        Ingredient egg = new Ingredient(FILLING, "EGG", 12);

        burger.addIngredient(cheese);
        burger.addIngredient(bacon);
        burger.addIngredient(egg);

        burger.removeIngredient(1);
        assertFalse(burger.ingredients.contains(bacon));
    }

    @Test
    public void moveIngredientTest() {
        Burger burger = new Burger();
        Ingredient cheese = new Ingredient(FILLING, "CHEESE", 33.45f);
        Ingredient bacon = new Ingredient(FILLING, "BACON", 54.4f);
        Ingredient egg = new Ingredient(FILLING, "EGG", 12);

        burger.addIngredient(cheese);
        burger.addIngredient(bacon);
        burger.addIngredient(egg);

        System.out.println(burger.ingredients);
        burger.moveIngredient(1, 0);
        assertEquals(burger.ingredients.get(0), bacon);
    }

    @Test
    public void getPriceTest(){
        Burger burger = new Burger();

        Mockito.when(bun.getPrice()).thenReturn(988f);
        Mockito.when(cheese.getPrice()).thenReturn(33.4f);
        Mockito.when(bacon.getPrice()).thenReturn(54.6f);
        Mockito.when(egg.getPrice()).thenReturn(12f);

        burger.setBuns(bun);
        burger.addIngredient(bacon);
        burger.addIngredient(cheese);
        burger.addIngredient(egg);

        //Может быть, есть какой-то метод, с помощью которого можно сложить несколько чисел с плавающей точкой? К сожалению, мне так и не удалось найти ничего подобного.
        float ingredientsSum = bun.getPrice()*2 + bacon.getPrice() + cheese.getPrice() + egg.getPrice();
        assertEquals(burger.getPrice(), ingredientsSum, 0.1);


    }

    @Test
    public void getReceiptTest() {




    }




}
