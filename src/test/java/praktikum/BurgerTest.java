package praktikum;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class BurgerTest {

    @Mock
    Bun bunMock = mock(Bun.class);

    @Mock
    Ingredient ingredientMock = mock(Ingredient.class);

    @Test
    void setBunsTest() {
        Burger burger = new Burger();
        burger.setBuns(bunMock);
        assertEquals(bunMock, burger.bun);
    }

    @Test
    public void addIngredientBurgerTest() {
        Burger burger = new Burger();
        burger.addIngredient(ingredientMock);
        assertEquals(1, burger.ingredients.size());
    }

    @Test
    public void removeIngredientBurgerTest() {
        Burger burger = new Burger();
        burger.addIngredient(ingredientMock);
        burger.removeIngredient(0);
        assertEquals(0, burger.ingredients.size());
    }

    @Test
    public void moveIngredientBurgerTest() {
        Burger burger = new Burger();
        burger.addIngredient(new Ingredient(IngredientType.FILLING, "filling_test", 14.88f));
        burger.addIngredient(new Ingredient(IngredientType.SAUCE, "sauce_test", 9f));
        burger.moveIngredient(0, 1);
        assertEquals(2, burger.ingredients.size());
        assertEquals("filling_test", burger.ingredients.get(1).name);
        assertEquals("sauce_test", burger.ingredients.get(0).name);
    }

    @Test
    public void getPriceBurgerTest() {
        Burger burger = new Burger();
        float bunPrice = 99;
        float ingredientPrice = 49;
        float expectedPrice = bunPrice * 2 + ingredientPrice;
        when(bunMock.getPrice()).thenReturn(bunPrice);
        when(ingredientMock.getPrice()).thenReturn(ingredientPrice);
        burger.setBuns(bunMock);
        burger.addIngredient(ingredientMock);
        assertEquals(expectedPrice, burger.getPrice());
    }

    @Test
    public void getReceiptBurgerTest() {
        Burger burger = new Burger();
        burger.setBuns(bunMock);
        burger.addIngredient(ingredientMock);
        when(bunMock.getName()).thenReturn("bun name");
        when(bunMock.getPrice()).thenReturn(99f);
        when(ingredientMock.getType()).thenReturn(IngredientType.FILLING);
        when(ingredientMock.getName()).thenReturn("ingredient name");
        when(ingredientMock.getPrice()).thenReturn(49f);
        String expected = "(==== bun name ====)" + "\n" + "= filling ingredient name =" + "\n" + "(==== bun name ====)" + "\n\n" + "Price: 247,000000" + "\n";
        assertEquals(expected, burger.getReceipt());
    }
}