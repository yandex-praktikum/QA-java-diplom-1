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

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {


    @Mock
    Ingredient ingredient;
    @Mock
    Ingredient ingredient2;
    @Mock
    Bun bun;

    @Test
    public void addIngredientTest(){
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        assertEquals(true, burger.ingredients.contains(ingredient));
    }

    @Test
    public void removeIngredientTest(){
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        assertEquals(false, burger.ingredients.contains(ingredient));
    }

    @Test
    public void moveIngredientTest(){
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient2);
        burger.moveIngredient(0,1);
        assertEquals(true, burger.ingredients.indexOf(ingredient)==1);
    }

    @Test
    public void getPriceTest(){
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient2);
        burger.setBuns(bun);
        float ingredientMockPrice = 200;
        float ingredient2MockPrice = 140;
        float bunMockPrice = 120;
        float mockSum = ingredient2MockPrice + ingredientMockPrice + bunMockPrice*2;
        Mockito.when(ingredient.getPrice()).thenReturn(ingredientMockPrice);
        Mockito.when(ingredient2.getPrice()).thenReturn(ingredient2MockPrice);
        Mockito.when(bun.getPrice()).thenReturn(bunMockPrice);
        float actualSum = burger.getPrice();
        assertEquals(mockSum, actualSum, 0);
    }

    @Test
    public void getReceiptTest(){
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient2);
        burger.setBuns(bun);
        String ingredientName = "Мясо";
        String ingredient2Name = "Соус";
        String bunName = "Булка";
        float ingredientMockPrice = 200;
        float ingredient2MockPrice = 140;
        float bunMockPrice = 120;
        Mockito.when(ingredient.getPrice()).thenReturn(ingredientMockPrice);
        Mockito.when(ingredient2.getPrice()).thenReturn(ingredient2MockPrice);
        Mockito.when(bun.getPrice()).thenReturn(bunMockPrice);
        Mockito.when(ingredient.getName()).thenReturn(ingredientName);
        Mockito.when(ingredient2.getName()).thenReturn(ingredient2Name);
        Mockito.when(ingredient2.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(bun.getName()).thenReturn(bunName);
        String actualReceipt = burger.getReceipt();
        String expectedReceipt =    "(==== Булка ====)\r\n" +
                "= filling Мясо =\r\n" +
                "= sauce Соус =\r\n" +
                "(==== Булка ====)\r\n" +
                "\r\n" +
                "Price: 580,000000\r\n";
        assertEquals(expectedReceipt, actualReceipt);
    }

    @Test
    public void setBunsTest(){
        Burger burger = new Burger();
        burger.setBuns(bun);
        assertEquals(bun, burger.bun);
    }
}
