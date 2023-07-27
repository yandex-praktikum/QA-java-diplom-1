package praktikum.tests;

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
    Bun bun;
    @Mock
    Ingredient ingredient;

    @Test

    public void getPriceTest(){

        Burger burger = new Burger();
        float price = 300;

        Mockito.when(bun.getPrice()).thenReturn(price);
        Mockito.when(ingredient.getPrice()).thenReturn(price);

        burger.setBuns(bun);
        burger.addIngredient(ingredient);

        float expectedPrice = price * 2 + price;
        float actualPrice = burger.getPrice();
        assertEquals(expectedPrice, actualPrice, 0);
    }


    @Test
    public void getReceiptTest(){
        Burger burger = new Burger();
        Mockito.when(bun.getName()).thenReturn("bunTest");
        Mockito.when(bun.getPrice()).thenReturn(300F);
        burger.setBuns(bun);

        Mockito.when(ingredient.getName()).thenReturn("ingredientTest");
        Mockito.when(ingredient.getPrice()).thenReturn(300F);
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.FILLING);
        burger.addIngredient(ingredient);

        String expectedReceipt = "(==== bunTest ====)\r\n= filling ingredientTest =\r\n(==== bunTest ====)\r\n\r\nPrice: 900,000000\r\n";;
        String actualReceipt = burger.getReceipt();
        assertEquals(expectedReceipt, actualReceipt);
    }

    @Test
    public void moveBurgerIngredientTest() {
        Burger burger = new Burger();
        burger.addIngredient(new Ingredient(IngredientType.FILLING, "sausage", 300));
        burger.addIngredient(new Ingredient(IngredientType.SAUCE, "hot sauce", 10));
        burger.moveIngredient(0, 1);
        assertEquals("sausage", burger.ingredients.get(1).name);
    }

    @Test
    public void removeIngredientTest() {
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        assertEquals(0, burger.ingredients.size());
    }

}
