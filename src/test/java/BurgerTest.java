import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;
import praktikum.Ingredient;
import praktikum.Burger;
import praktikum.IngredientType;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class BurgerTest {

    private Burger burger;
    private Bun bun;
    private Ingredient ingredient;

    @Before
    public void setUp() {
        burger = new Burger();
        bun = mock(Bun.class);
        ingredient = mock(Ingredient.class);

        when(bun.getPrice()).thenReturn(1.0f);
        when(ingredient.getPrice()).thenReturn(0.5f);

        burger.setBuns(bun);
    }

    @Test
    public void addIngredientIncreasesPrice() {
        float initialPrice = 2.0f;
        assertEquals(initialPrice, burger.getPrice(), 0.001);

        burger.addIngredient(ingredient);
        assertEquals(initialPrice + 0.5f, burger.getPrice(), 0.001);
    }

    @Test
    public void getReceiptReturnsCorrectFormat() {
        burger.addIngredient(ingredient);

        when(bun.getName()).thenReturn("Brioche");
        when(ingredient.getName()).thenReturn("Cheese");
        when(ingredient.getType()).thenReturn(IngredientType.SAUCE);

        String expectedReceipt = "(==== Brioche ====)\n= sauce Cheese =\n(==== Brioche ====)\n\nPrice: 2.500000\n";
        assertEquals(expectedReceipt, burger.getReceipt());
    }

}
