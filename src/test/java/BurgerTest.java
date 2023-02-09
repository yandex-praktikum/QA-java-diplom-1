import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.*;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    Bun exampleBun;
    Ingredient exampleIngredient1;
    Ingredient exampleIngredient2;
    Burger burger = new Burger();



    @Test
    public void setBunsSetsCorrectBun(){

        exampleBun = new Bun("Булочка", 10);

        String nameOfExpectedBun = "Булочка";
        float priceOfExpectedBun = 10;

        burger.setBuns(exampleBun);
        String nameOfActualBun = burger.getBun().getName();
        float priceOfActualBun = burger.getBun().getPrice();

        assertEquals(nameOfExpectedBun, nameOfActualBun);
        assertEquals(priceOfExpectedBun, priceOfActualBun, 0);
    }


    @Test
    public void addIngredientAddsCorrectBun(){
        exampleIngredient1 = new Ingredient(IngredientType.SAUCE,"Кетчуп", 50);

        boolean ingredientsListIsEmptyExpectedResult = false;

        burger.addIngredient(exampleIngredient1);
        boolean ingredientsListIsEmptyActualResult = burger.getIngredients().isEmpty();

        assertEquals(ingredientsListIsEmptyExpectedResult, ingredientsListIsEmptyActualResult);
    }

    @Test
    public void removeIngredientRemovesCorrectIngredient(){
        exampleIngredient1 = new Ingredient(IngredientType.SAUCE,"Кетчуп", 50);

        List<Ingredient> ingredients = burger.getIngredients();
        ingredients.add(exampleIngredient1);
        boolean ingredientsListIsEmptyExpectedResult = true;

        burger.removeIngredient(0);
        boolean ingredientsListIsEmptyActualResult = burger.getIngredients().isEmpty();

        assertEquals(ingredientsListIsEmptyExpectedResult, ingredientsListIsEmptyActualResult);

    }

    @Test
    public void moveIngredientMovesIngredientCorrect(){
        exampleIngredient1 = new Ingredient(IngredientType.SAUCE,"Кетчуп", 50);
        exampleIngredient2 = new Ingredient(IngredientType.FILLING,"Котлета", 150);

        List<Ingredient> ingredients = burger.getIngredients();
        ingredients.add(exampleIngredient1);
        ingredients.add(exampleIngredient2);
        Ingredient expectedIngredient = ingredients.get(1);

        burger.moveIngredient(1,0);
        Ingredient actualIngredient = ingredients.get(1);

        assertNotEquals(expectedIngredient,actualIngredient);

    }


    @Test
    public void getPriceReturnsCorrectPrice(){
        exampleBun = new Bun("Булочка", 10);
        exampleIngredient1 = new Ingredient(IngredientType.SAUCE,"Кетчуп", 50);
        exampleIngredient2 = new Ingredient(IngredientType.FILLING,"Котлета", 150);


        List<Ingredient> ingredients = burger.getIngredients();

        ingredients.add(exampleIngredient1);
        ingredients.add(exampleIngredient2);

        burger.setBuns(exampleBun);

        float expectedResult = 220;

        float actualResult = burger.getPrice();

        assertEquals(expectedResult, actualResult, 0);
    }


    @Spy
    Burger burgerSpy = new Burger();

    @Test
    public void getReceiptTest(){
        exampleBun = new Bun("Булочка", 10);
        exampleIngredient1 = new Ingredient(IngredientType.SAUCE,"Кетчуп", 50);
        exampleIngredient2 = new Ingredient(IngredientType.FILLING,"Котлета", 150);

        burgerSpy.setBuns(exampleBun);

        burgerSpy.addIngredient(exampleIngredient1);
        burgerSpy.addIngredient(exampleIngredient2);

        Mockito.when(burgerSpy.getPrice()).thenReturn(220F);

        String expectedReceipt = "(==== Булочка ====)\r\n" + "= sauce Кетчуп =\r\n" + "= filling Котлета =\r\n" + "(==== Булочка ====)\r\n" + "\r\n" + "Price: 220,000000\r\n";

        String actualReceipt = burgerSpy.getReceipt();

        assertEquals(expectedReceipt, actualReceipt);

    }
}
