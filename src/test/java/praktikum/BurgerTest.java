package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    Burger burger;

    @Mock
    private Bun bun;

    @Mock
    private Ingredient ingredient1;
    @Mock
    private Ingredient ingredient2;

    @Before
    public void initBurger() {
        burger = new Burger();
    }
    @Test
    public void checkSetBuns() {
        String expectedName = "Moskovskaya";
        Mockito.when(bun.getName()).thenReturn(expectedName);
        burger.setBuns(bun);
        assertEquals(expectedName, burger.bun.getName());
    }

    @Test
    public void checkAddIngredient() {
        String expectedName = "Ingredient1";
        Mockito.when(ingredient1.getName()).thenReturn(expectedName);
        burger.addIngredient(ingredient1);
        assertEquals(expectedName, burger.ingredients.get(0).getName());
    }

    @Test
    public void checkRemoveIngredient() {
        burger.addIngredient(ingredient1);
        burger.removeIngredient(0);
        assertTrue(burger.ingredients.isEmpty());
    }

    @Test
    public void checkMoveIngredient() {
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.moveIngredient(0, 1);
        assertEquals(ingredient1, burger.ingredients.get(1));
        assertEquals(ingredient2, burger.ingredients.get(0));
    }

    @Test
    public void checkGetPrice() {
        float bunPrice = 25;
        float ingredientPrice = 27.8f;
        float expectedPrice = 77.8f;
        Mockito.when(ingredient1.getPrice()).thenReturn(ingredientPrice);
        Mockito.when(bun.getPrice()).thenReturn(bunPrice);
        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        assertEquals(expectedPrice,burger.getPrice(),0.0);
    }

    @Test
    public void checkGetReceipt() {
        float bunPrice = 10f;
        float ingredientPrice = 20f;
        String ingredientName = "BBQ";
        String bunName = "Moskovskaya";
        String expectedPrice = "50,000000";
        StringBuilder expectedReceipt = new StringBuilder(String.format("(==== %s ====)%n", bunName));
        expectedReceipt.append(String.format("= %s %s =%n", IngredientType.SAUCE.toString().toLowerCase(), ingredientName));
        expectedReceipt.append(String.format("(==== %s ====)%n", bunName));
        expectedReceipt.append(String.format("%nPrice: %s%n", expectedPrice));
        Mockito.when(bun.getName()).thenReturn(bunName);
        Mockito.when(bun.getPrice()).thenReturn(ingredientPrice);
        Mockito.when(ingredient1.getName()).thenReturn(ingredientName);
        Mockito.when(ingredient1.getPrice()).thenReturn(bunPrice);
        Mockito.when(ingredient1.getType()).thenReturn(IngredientType.SAUCE);
        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        assertEquals(expectedReceipt.toString(), burger.getReceipt());
    }
}