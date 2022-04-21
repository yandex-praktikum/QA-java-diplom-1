package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    Burger burger = new Burger();

    @Mock
    Bun bun;
    Ingredient ingredient = mock(Ingredient.class);
    Ingredient ingredient2 = mock(Ingredient.class);
    Ingredient ingredient3 = mock(Ingredient.class);


    //только булки, без ингредиентов
    @Test
    public void burgerWithoutIngredientsCheckTotalPrice() {
       // Burger burger = new Burger();
        when(bun.getPrice()).thenReturn(20f);
        burger.setBuns(bun);
        float actual = burger.getPrice();
        float expected = 40f;
        assertEquals(expected, actual,0);
    }

    // булки + ингредиенты
    @Test
    public void burgerWithIngredientsCheckTotalPrice() {

        when(bun.getPrice()).thenReturn(100f);
        when(ingredient.getPrice()).thenReturn(500f);

        burger.addIngredient(ingredient);
        burger.setBuns(bun);

        float actual = burger.getPrice();

        float expected = 700f;
        assertEquals(expected, actual,0);
    }

    //удалим ингредиент
    @Test
    public void burgerDeleteIngredient() {

        Mockito.when(bun.getPrice()).thenReturn(100f);
        Mockito.when(ingredient.getPrice()).thenReturn(10f);
//        Mockito.when(ingredient2.getPrice()).thenReturn(50f); - UnnecessaryStubbingException
        Mockito.when(ingredient3.getPrice()).thenReturn(100f);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient2);
        burger.addIngredient(ingredient3);

        burger.removeIngredient(1);

        burger.setBuns(bun);
        float actual = burger.getPrice();
        float expected = 310;
        assertEquals(expected, actual,0);
    }

    //перемешаем ингредиенты
    @Test
    public void burgerShuffleIngredients() {

        when(bun.getPrice()).thenReturn(100.50f);
        burger.setBuns(bun);

        when(ingredient.getPrice()).thenReturn(100f);
        when(ingredient2.getPrice()).thenReturn(99.99f);
//        when(ingredient3.getPrice()).thenReturn(200f); - UnnecessaryStubbingException

        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient2);
        burger.addIngredient(ingredient3);

        burger.moveIngredient(0,2);  // новый порядок теперь: 99.99, 200, 100

        // удалим элемент с индексом 1 (=200) чтобы потом увидеть цену и убедиться что данные были реально перемешаны
        burger.removeIngredient(1);

        float actual = burger.getPrice();
        float expected = 400.99f; // 100.50*2 + 99.99 + 100
        assertEquals(expected, actual,0);
    }

    // получим чек: булочка, 2 начинки, 1 соус
    @Test
    public void burgerGetReceipt() {

        burger.setBuns(bun);
        when(bun.getPrice()).thenReturn(500f);
        when(bun.getName()).thenReturn("Vegan Burger");

        when(ingredient.getPrice()).thenReturn(500f);
        when(ingredient.getType()).thenReturn(SAUCE);
        when(ingredient.getName()).thenReturn("sour cream");

        when(ingredient2.getPrice()).thenReturn(500f);
        when(ingredient2.getType()).thenReturn(FILLING);
        when(ingredient2.getName()).thenReturn("vegan cutlet");

        when(ingredient3.getPrice()).thenReturn(200f);
        when(ingredient3.getType()).thenReturn(FILLING);
        when(ingredient3.getName()).thenReturn("green");

        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient2);
        burger.addIngredient(ingredient3);

        String actual = burger.getReceipt();
        String receipt = (String.format("(==== Vegan Burger ====)%n" +
                        "= sauce sour cream =%n" +
                        "= filling vegan cutlet =%n" +
                        "= filling green =%n" +
                        "(==== Vegan Burger ====)%n" +
                        "%n" +
                        "Price: 2200,000000%n"));

        System.out.println(actual);

        assertEquals(receipt, actual);
    }


    // булка без имени, нет начинки и соуса
    @Test
    public void burgerGetReceipt2() {

        burger.setBuns(bun);
        when(bun.getName()).thenReturn("");

        String actual = burger.getReceipt();
        String receipt = (String.format("(====  ====)%n" +
                "(====  ====)%n" +
                "%n" +
                "Price: 0,000000%n"));

        System.out.println(actual);
        assertEquals(receipt, actual);
    }


}


