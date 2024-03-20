import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.*;

public class BurgerTests {
    Burger burger = new Burger();
    private int index;
    private int newIndex;

    @Mock
    protected Bun bun;
    @Mock
    protected Ingredient ingredient;
    @Mock
    protected Ingredient ingredient1;

    @Before
    public void dataTest() {
        MockitoAnnotations.initMocks(this);

        Mockito.when(bun.getName()).thenReturn("Название");
        Mockito.when(bun.getPrice()).thenReturn(12f);

        Mockito.when(ingredient.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredient.getName()).thenReturn("соус");
        Mockito.when(ingredient.getPrice()).thenReturn(2f);

        Mockito.when(ingredient1.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ingredient1.getName()).thenReturn("катлета");
        Mockito.when(ingredient1.getPrice()).thenReturn(3f);
    }

    @Test
    public void setBunsTest() {
        burger.setBuns(bun);
        assertEquals(bun.getName(), burger.bun.getName());
    }

    @Test
    public void addIngredientTest() {
        burger.addIngredient(ingredient);
        assertTrue(burger.ingredients.contains(ingredient));
    }

    @Test
    public void removeIngredientTest() {
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        assertFalse(burger.ingredients.contains(ingredient));
    }

    @Test
    public void moveIngredientTest() {
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient1);

        burger.moveIngredient(index, newIndex);

        assertEquals(ingredient, burger.ingredients.get(0));
        assertEquals(ingredient1, burger.ingredients.get(1));
    }

    @Test
    public void getPriceTest() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        float expectedPrice = bun.getPrice() * 2;
        expectedPrice += ingredient.getPrice();
        assertEquals(expectedPrice, burger.getPrice(), 0);
    }

    @Test
    public void getReceiptTest() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient);

        float expectedPrice = bun.getPrice() * 2;
        expectedPrice += ingredient.getPrice();

        String expectedReceipt =
                String.format("(==== %s ====)%n", bun.getName()) +
                        String.format("= %s %s =%n", ingredient.getType().toString().toLowerCase(), ingredient.getName()) +
                        String.format("(==== %s ====)%n", bun.getName()) +
                        String.format("%nPrice: %f%n", expectedPrice);

        assertEquals(expectedReceipt, burger.getReceipt());
    }

}
