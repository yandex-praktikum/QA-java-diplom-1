import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;
import static praktikum.IngredientType.FILLING;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    Bun bun;

    @Mock
    Ingredient ingredient;
    Ingredient ingredientTwo;

    @Test
    public void setBunsTest() {
        Burger burger = new Burger();

        burger.setBuns(bun);

        assertEquals(bun, burger.bun);
    }

    @Test
    public void addIngredientTest (){
        Burger burger = new Burger();

        burger.addIngredient(ingredient);

        assertTrue(burger.ingredients.contains(ingredient));

    }

    @Test
    public void removeIngredientTest (){
        Burger burger = new Burger();
        burger.addIngredient(ingredient);

        burger.removeIngredient(0);

        assertTrue(burger.ingredients.isEmpty());
    }

    @Test
    public void moveIngredientTest(){
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredientTwo);

        burger.moveIngredient(0,1 );

        assertEquals(ingredient, burger.ingredients.get(1));
        assertEquals(ingredientTwo, burger.ingredients.get(0));
    }

    @Test
    public void getPriceTest(){
        Burger burger = new Burger();
        when(bun.getPrice()).thenReturn(100f);
        when(ingredient.getPrice()).thenReturn(100f);
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        float expectedPrice = bun.getPrice() * 2 + ingredient.getPrice();

        float price = burger.getPrice();

        assertEquals(expectedPrice, price, 1e-8);
    }

    @Test
    public void getReceiptTest(){
        Burger burger = new Burger();
        when(bun.getName()).thenReturn("Abc bun");
        when(bun.getPrice()).thenReturn(100f);
        when(ingredient.getType()).thenReturn(FILLING);
        when(ingredient.getName()).thenReturn("abc ingr");
        when(ingredient.getPrice()).thenReturn(100f);
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        String expectedReceipt =
        "(==== Abc bun ====)\r\n" +
        "= filling abc ingr =\r\n" +
        "(==== Abc bun ====)\r\n" +
        "\r\nPrice: 300,000000\r\n";

        String actualReceipt = burger.getReceipt();

        assertEquals(expectedReceipt.toString(), actualReceipt);
    }
}