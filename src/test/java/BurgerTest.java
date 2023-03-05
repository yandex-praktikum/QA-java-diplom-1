package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    Burger burger;
    String bunName = "wheat";
    String ingredientName = "szechuan sauce";
    float bunPrice = 1;
    float ingredientPrice = 2;

    @Before
    public void setUp() {
        burger = new Burger();
    }

    @Mock
    Bun bun;
    Ingredient firstIngredient = mock(Ingredient.class);
    Ingredient secondIngredient = mock(Ingredient.class);

    @Test
    public void checkSetBuns() {
        burger.setBuns(bun);
        Mockito.when(bun.getName()).thenReturn("wheat");
        String actual = bun.getName();
        String expected = "wheat";
        assertEquals("Return wrong buns name", expected, actual);
    }

    @Test
    public void addIngredientTest() {
        burger.addIngredient(firstIngredient);
        int expected = 1;
        int actual = burger.ingredients.size();
        assertEquals("Return wrong ingredients quantity", expected, actual);
    }

    @Test
    public void RemoveIngredientTest() {
        burger.addIngredient(firstIngredient);
        burger.removeIngredient(0);
        assertTrue("Ingredient not removed", burger.ingredients.isEmpty());
    }

    @Test
    public void moveIngredientTest() {
        burger.addIngredient(firstIngredient);
        burger.addIngredient(secondIngredient);
        burger.moveIngredient(0, 1);
        assertEquals("Ingredients not move", "secondIngredient", burger.ingredients.get(0).toString());
    }

    @Test
    public void getBunPriceTest() {
        burger.setBuns(bun);
        Mockito.when(bun.getPrice()).thenReturn(1F);
        float actual = bun.getPrice();
        float expected = 1;
        assertEquals("The price of the bun is incorrect", expected, actual, 0);
    }

    @Test
    public void getReceiptTest() {
        burger.setBuns(bun);
        Mockito.when(bun.getPrice()).thenReturn(bunPrice);
        Mockito.when(bun.getName()).thenReturn(bunName);

        Mockito.when(firstIngredient.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(firstIngredient.getName()).thenReturn(ingredientName);
        Mockito.when(firstIngredient.getPrice()).thenReturn(ingredientPrice);

        burger.addIngredient(firstIngredient);

        String expected =
                String.format("(==== %s ====)%n", bunName) +
                        String.format("= %s %s =%n", firstIngredient.getType().toString().toLowerCase(), ingredientName) +
                        String.format("(==== %s ====)%n", bunName) +
                        String.format("%nPrice: %f%n", (bunPrice * 2 + ingredientPrice));


        assertEquals(" Receipt is incorrect", expected, burger.getReceipt());
    }
}