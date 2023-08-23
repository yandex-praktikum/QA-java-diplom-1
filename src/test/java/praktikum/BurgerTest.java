package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    @Mock
    Bun bunMock;
    @Mock
    Ingredient ingredientMock;
    Burger burger = new Burger();

    @Test
    public void setBunsReturnsCorrectBun(){
        String bunName = "Булочка с кунжутом";
        burger.setBuns(bunMock);
        Mockito.when(bunMock.getName()).thenReturn(bunName);

        StringBuilder expected = new StringBuilder()
                .append(String.format("(==== Булочка с кунжутом ====)%n"))
                .append(String.format("(==== Булочка с кунжутом ====)%n"))
                .append(String.format("%nPrice: 0,000000%n"));

        assertEquals("Неправильный текст", expected.toString(), burger.getReceipt());
    }

    @Test
    public void addIngredientSuccess(){

        String ingredientName = "Котлетка сочная";
        float ingredientPrice = 250;

        burger.setBuns(bunMock);
        burger.addIngredient(ingredientMock);
        burger.addIngredient(ingredientMock);

        Mockito.when(ingredientMock.getName()).thenReturn(ingredientName);
        Mockito.when(ingredientMock.getPrice()).thenReturn(ingredientPrice);
        Mockito.when(ingredientMock.getType()).thenReturn(IngredientType.FILLING);

        StringBuilder expected = new StringBuilder()
                .append(String.format("(==== null ====)%n"))
                .append(String.format("= filling Котлетка сочная =%n"))
                .append(String.format("= filling Котлетка сочная =%n"))
                .append(String.format("(==== null ====)%n"))
                .append(String.format("%nPrice: 500,000000%n"));

        assertEquals("Неправильный текст", expected.toString(), burger.getReceipt());
        assertEquals(2, burger.ingredients.size());
    }

    @Test
    public void removeIngredientSuccess(){

        burger.setBuns(bunMock);
        burger.addIngredient(ingredientMock);
        burger.addIngredient(ingredientMock);
        burger.removeIngredient(0);

        String ingredientName = "Котлетка сочная";
        float ingredientPrice = 250;

        Mockito.when(ingredientMock.getName()).thenReturn(ingredientName);
        Mockito.when(ingredientMock.getPrice()).thenReturn(ingredientPrice);
        Mockito.when(ingredientMock.getType()).thenReturn(IngredientType.FILLING);

        StringBuilder expected = new StringBuilder()
                .append(String.format("(==== null ====)%n"))
                .append(String.format("= filling Котлетка сочная =%n"))
                .append(String.format("(==== null ====)%n"))
                .append(String.format("%nPrice: 250,000000%n"));

        System.out.println(ingredientMock.getName());
        System.out.println(burger.getReceipt());

        assertEquals("Неправильный текст", expected.toString(), burger.getReceipt());
        assertEquals(1, burger.ingredients.size());
    }

    @Test
    public void moveIngredientSuccess(){

        Ingredient first = Mockito.mock(Ingredient.class);
        Ingredient second = Mockito.mock(Ingredient.class);
        String ingredientNameFirst = "Котлетка сочная 1";
        String ingredientNameSecond = "Котлетка сочная 2";
        String ingredientName = "Котлетка сочная 3";
        float ingredientPrice = 250;

        burger.setBuns(bunMock);
        burger.addIngredient(first);
        burger.addIngredient(second);
        burger.addIngredient(ingredientMock);


        Mockito.when(first.getName()).thenReturn(ingredientNameFirst);
        Mockito.when(first.getPrice()).thenReturn(ingredientPrice);
        Mockito.when(first.getType()).thenReturn(IngredientType.FILLING);

        Mockito.when(second.getName()).thenReturn(ingredientNameSecond);
        Mockito.when(second.getPrice()).thenReturn(ingredientPrice);
        Mockito.when(second.getType()).thenReturn(IngredientType.FILLING);

        Mockito.when(ingredientMock.getName()).thenReturn(ingredientName);
        Mockito.when(ingredientMock.getPrice()).thenReturn(ingredientPrice);
        Mockito.when(ingredientMock.getType()).thenReturn(IngredientType.FILLING);

        burger.moveIngredient(burger.ingredients.indexOf(ingredientMock), 0);

        StringBuilder expected = new StringBuilder()
                .append(String.format("(==== null ====)%n"))
                .append(String.format("= filling Котлетка сочная 3 =%n"))
                .append(String.format("= filling Котлетка сочная 1 =%n"))
                .append(String.format("= filling Котлетка сочная 2 =%n"))
                .append(String.format("(==== null ====)%n"))
                .append(String.format("%nPrice: 750,000000%n"));

        assertEquals("Неправильный текст", expected.toString(), burger.getReceipt());

        assertEquals(3, burger.ingredients.size());
        assertEquals(ingredientMock, burger.ingredients.get(0));
    }

    @Test
    public void getPriceReturnCorrectPrice(){

        float bunPrice = 500;
        float ingredientPrice = 250;

        Mockito.when(bunMock.getPrice()).thenReturn(bunPrice);
        Mockito.when(ingredientMock.getPrice()).thenReturn(ingredientPrice);

        burger.setBuns(bunMock);
        burger.addIngredient(ingredientMock);

        assertEquals((bunPrice * 2) + ingredientPrice, burger.getPrice(), 0);
    }

    @Test
    public void getReceiptReturnCorrectReceipt() {
        String bunName = "Булочка с кунжутом";
        String ingredientName = "Котлетка сочная";
        float bunPrice = 500;
        float ingredientPrice = 250;

        burger.setBuns(bunMock);
        burger.addIngredient(ingredientMock);
        burger.addIngredient(ingredientMock);

        Mockito.when(ingredientMock.getName()).thenReturn(ingredientName);
        Mockito.when(bunMock.getName()).thenReturn(bunName);
        Mockito.when(bunMock.getPrice()).thenReturn(bunPrice);
        Mockito.when(ingredientMock.getPrice()).thenReturn(ingredientPrice);
        Mockito.when(ingredientMock.getType()).thenReturn(IngredientType.FILLING);

        StringBuilder expected = new StringBuilder()
                .append(String.format("(==== Булочка с кунжутом ====)%n"))
                .append(String.format("= filling Котлетка сочная =%n"))
                .append(String.format("= filling Котлетка сочная =%n"))
                .append(String.format("(==== Булочка с кунжутом ====)%n"))
                .append(String.format("%nPrice: 1500,000000%n"));

        assertEquals("Неправильный текст", expected.toString(), burger.getReceipt());
    }
}
