package ru.yandex.practicum.burgers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    String bunName = "white bun";
    String ingredientName1 = "sour cream";
    String ingredientName2 = "cutlet";

    @Mock
    Bun bunMock;

    @Mock
    Ingredient ingredientMock1;

    @Mock
    Ingredient ingredientMock2;

    @Test
    public void setBunsTest() {
        Burger burger = new Burger();
        Mockito.when(bunMock.getName()).thenReturn(bunName); // стаб для булочки
        burger.setBuns(bunMock);
        String expectedBunName = bunName;
        assertEquals("Название выбранной булочки не соответствует:", expectedBunName, burger.bun.getName());
    }

    @Test
    public void addIngredientTest() {
        Burger burger = new Burger();
        Mockito.when(ingredientMock1.getName()).thenReturn(ingredientName1);
        burger.addIngredient(ingredientMock1);
        String expectedIngredientName = ingredientName1;
        String actualIngredientName = burger.ingredients.get(0).getName();
        assertEquals("Название выбранного ингредиента не соответствует:", expectedIngredientName, actualIngredientName);
    }

    @Test
    public void removeIngredientTest() {
        Burger burger = new Burger();
        burger.addIngredient(ingredientMock1);
        burger.removeIngredient(0);
        assertTrue("Ингредиент не был удален:", burger.ingredients.isEmpty());
    }

    @Test
    public void moveIngredientTest() {
        Burger burger = new Burger();
        burger.addIngredient(ingredientMock1);
        burger.addIngredient(ingredientMock2);
        Mockito.when(ingredientMock2.getName()).thenReturn(ingredientName2);
        burger.moveIngredient(1,0);
        String expectedIngredientName = ingredientName2;
        String actualIngredientName = burger.ingredients.get(0).getName();
        assertEquals("Название перемещенного ингредиента не соответствует:", expectedIngredientName, actualIngredientName);
    }

    @Test
    public void getPriceTest() {
        Burger burger = new Burger();
        Mockito.when(bunMock.getPrice()).thenReturn(200F);
        burger.setBuns(bunMock);
        Mockito.when(ingredientMock1.getPrice()).thenReturn(200F);
        burger.addIngredient(ingredientMock1);
        Mockito.when(ingredientMock2.getPrice()).thenReturn(100F);
        burger.addIngredient(ingredientMock2);
        Float expectedBurgerPrice = 700F;
        Float actualBurgerPrice = burger.getPrice();
        assertEquals("Актуальная цена бургера отличается от ожидаемой:", expectedBurgerPrice, actualBurgerPrice);
    }

    @Test
    public void getReceiptTest() {
        Burger burger = new Burger();
        Mockito.when(bunMock.getName()).thenReturn(bunName);
        Mockito.when(bunMock.getPrice()).thenReturn(200F);
        burger.setBuns(bunMock);

        Mockito.when(ingredientMock1.getName()).thenReturn(ingredientName1);
        Mockito.when(ingredientMock1.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredientMock1.getPrice()).thenReturn(200F);
        burger.addIngredient(ingredientMock1);

        Mockito.when(ingredientMock2.getName()).thenReturn(ingredientName2);
        Mockito.when(ingredientMock2.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ingredientMock2.getPrice()).thenReturn(100F);
        burger.addIngredient(ingredientMock2);

        String expectedReceipt = "(==== " + bunName + " ====)\r\n" +
                "= " + IngredientType.SAUCE.name().toLowerCase() + " " + ingredientName1 + " =\r\n" +
                "= " + IngredientType.FILLING.name().toLowerCase() + " " + ingredientName2 + " =\r\n" +
                "(==== " + bunName + " ====)\r\n" +
                "\r\n" +
                "Price: 700,000000" +
                "\r\n";

        String actualReceipt = burger.getReceipt();

        assertEquals("Актуальный чек отличается от ожидаемого", expectedReceipt, actualReceipt);
    }
}
