import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTests {
    Burger burger;
    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient;

    @Before
    public void initBurger() {
        burger = new Burger();
    }
    @Test
    public void checkSetBuns() {
        String bunName = "Название_булочки";
        Mockito.when(bun.getName()).thenReturn(bunName);

        burger.setBuns(bun);
        assertEquals(bunName, burger.bun.getName());
    }

    @Test
    public void checkAddIngredient() {
        String ingredientName = "Название_ингрединента";
        Mockito.when(ingredient.getName()).thenReturn(ingredientName);

        burger.addIngredient(ingredient);
        assertEquals(ingredientName, burger.ingredients.get(0).getName());
    }

    @Test
    public void checkRemoveIngredient() {
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        assertTrue(burger.ingredients.isEmpty());
    }

    @Test
    public void checkMoveIngredient() {
        String ingredientName = "Название_ингрединента";
        Mockito.when(ingredient.getName()).thenReturn(ingredientName);

        burger.ingredients.add(null);
        burger.addIngredient(ingredient);
        burger.moveIngredient(1,0);
        assertEquals(ingredientName, burger.ingredients.get(0).getName());
    }

    @Test
    public void checkGetPrice() {
        float expectedBurgerPrice = 40.1f;
        float bunPrice = 10;
        float ingredientPrice = 20.1f;
        Mockito.when(ingredient.getPrice()).thenReturn(ingredientPrice);
        Mockito.when(bun.getPrice()).thenReturn(bunPrice);

        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        assertEquals(expectedBurgerPrice,burger.getPrice(),0);
    }

    @Test
    public void checkGetReceipt() {
        float bunPrice = 10f;
        float ingredientPrice = 20f;
        String ingredientName = "Песто";
        String bunName = "Булочка с кунжутом";
        String expectedBurgerPrice = "50,000000";

        StringBuilder expectedReceipt = new StringBuilder(String.format("(==== %s ====)%n", bunName));
        expectedReceipt.append(String.format("= %s %s =%n", IngredientType.SAUCE.toString().toLowerCase(), ingredientName));
        expectedReceipt.append(String.format("(==== %s ====)%n", bunName));
        expectedReceipt.append(String.format("%nPrice: %s%n", expectedBurgerPrice));

        Mockito.when(bun.getName()).thenReturn(bunName);
        Mockito.when(bun.getPrice()).thenReturn(ingredientPrice);
        Mockito.when(ingredient.getName()).thenReturn(ingredientName);
        Mockito.when(ingredient.getPrice()).thenReturn(bunPrice);
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.SAUCE);

        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        assertEquals(expectedReceipt.toString(), burger.getReceipt());
    }
}
