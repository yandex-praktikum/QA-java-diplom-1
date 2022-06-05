import org.mockito.Mock;
import praktikum.Bun;
import org.junit.Test;
import praktikum.Burger;

import static org.junit.Assert.*;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Ingredient;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    Ingredient ingredientFirst;

    @Mock
    Ingredient ingredientSecond;

    @Mock
    Bun bun;

    @Test
    public void setBunsTest() {
        Burger burger = new Burger();
        Bun expBun = bun;
        burger.setBuns(bun);
        Bun actBun = burger.bun;
        assertEquals(expBun,actBun);
    }

    @Test
    public void addIngredientTest() {
        Burger burger = new Burger();
        List<Ingredient> listOfExpIngredients = List.of(ingredientFirst);
        /*
        for (int i = 0; i < listOfExpIngredients.size(); i++) {
            System.out.println(listOfExpIngredients.get(i));
        }
         */
        burger.addIngredient(ingredientFirst);
        List<Ingredient> listOfActualIngredients = burger.ingredients;
        /*
        for (int i = 0; i < listOfActualIngredients.size(); i++) {
            System.out.println(listOfActualIngredients.get(i));
        }
        */
        assertEquals(listOfExpIngredients,listOfActualIngredients);
    }

    @Test
    public void removeIngredientTest() {
        Burger burger = new Burger();
        List<Ingredient> listOfExpIngredients = List.of(ingredientFirst);
        /*
        for (int i = 0; i < listOfExpIngredients.size(); i++) {
            System.out.println(listOfExpIngredients.get(i));
        }
         */
        burger.addIngredient(ingredientFirst);
        burger.addIngredient(ingredientSecond);
        burger.removeIngredient(1);
        List<Ingredient> listOfActualIngredients = burger.ingredients;
        /*
        for (int i = 0; i < listOfExpIngredients.size(); i++) {
            System.out.println(listOfExpIngredients.get(i));
        }
         */
        assertEquals(listOfExpIngredients,listOfActualIngredients);
    }

    @Test
    public void moveIngredientTest() {
        Burger burger = new Burger();
        List<Ingredient> listOfExpIngredients = List.of(ingredientSecond,ingredientFirst);
        /*
        for (int i = 0; i < listOfExpIngredients.size(); i++) {
            System.out.println(listOfExpIngredients.get(i));
        }
        */
        burger.addIngredient(ingredientFirst);
        burger.addIngredient(ingredientSecond);
        burger.moveIngredient(0,1);

        List<Ingredient> listOfActualIngredients = burger.ingredients;
        /*
        for (int i = 0; i < listOfExpIngredients.size(); i++) {
            System.out.println(listOfExpIngredients.get(i));
        }
        */
        assertEquals(listOfExpIngredients,listOfActualIngredients);
    }

    @Test
    public void getPriceTest() {

        Burger burger = new Burger();
        float priceExpIngredients = 300f*2 + 20.15f + 19.85f;
        Mockito.when(bun.getPrice()).thenReturn(300f);

        /*
        float test = bun.getPrice();
        System.out.println(test);
         */
        burger.setBuns(bun);
        burger.addIngredient(ingredientFirst);
        burger.addIngredient(ingredientSecond);
        Mockito.when(ingredientFirst.getPrice()).thenReturn(20.15f);
        Mockito.when(ingredientSecond.getPrice()).thenReturn(19.85f);

        /*
        float testF = ingredientFirst.getPrice();
        System.out.println(testF);

        float testS= ingredientSecond.getPrice();
        System.out.println(testS);
         */

        float priceActualIngredients = burger.getPrice();
        assertEquals(priceExpIngredients,priceActualIngredients,0);

    }

    @Test
    public void getReceiptTest() {

        Burger burger = new Burger();

        StringBuilder expReceipt = new StringBuilder(String.format("(==== %s ====)%n", "white bun"));
        expReceipt.append(String.format("= %s %s =%n", "FILLING".toString().toLowerCase(),
                "dinosaur"));
        expReceipt.append(String.format("= %s %s =%n", "SAUCE".toString().toLowerCase(),
                "sour cream"));

        expReceipt.append(String.format("(==== %s ====)%n", "white bun"));
        expReceipt.append(String.format("%nPrice: %f%n",640f ));

        Mockito.when(bun.getPrice()).thenReturn(300f);
        Mockito.when(bun.getName()).thenReturn("white bun");

        Mockito.when(ingredientFirst.getType()).thenReturn(FILLING);
        Mockito.when(ingredientFirst.getName()).thenReturn("dinosaur");
        Mockito.when(ingredientFirst.getPrice()).thenReturn(20.15f);

        Mockito.when(ingredientSecond.getType()).thenReturn(SAUCE);
        Mockito.when(ingredientSecond.getName()).thenReturn("sour cream");
        Mockito.when(ingredientSecond.getPrice()).thenReturn(19.85f);

        burger.setBuns(bun);
        burger.addIngredient(ingredientFirst);
        burger.addIngredient(ingredientSecond);

        String actual = burger.getReceipt();
        System.out.println(burger.getReceipt());
        String exp = expReceipt.toString();
        System.out.println("ожидаемый результат :" + exp);

        assertEquals(exp,actual);

    }


}
