package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    private Burger burger;

    @Mock
    Bun bun;

    @Mock
    Ingredient ingredient;

    @Before
    public void setUp() {
        burger = new Burger();
    }

    @Test
    public void setBunsTest() {
        Burger burger = new Burger();
        burger.setBuns(bun);

        assertEquals(bun, burger.bun);
    }

    @Test
    public void addIngredient() {
        Burger burger = new Burger();
        burger.addIngredient(ingredient);

        assertTrue(burger.ingredients.contains(ingredient));
    }

    @Test
    public void removeIngredientTest() {
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);

        assertFalse(burger.ingredients.contains(ingredient));
    }

    @Test
    public void moveIngredientTest() {
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient);
        burger.moveIngredient(0, 1);

        assertEquals(ingredient, burger.ingredients.get(1));
    }

    @Test
    public void getPriceTest() {
        Burger burger = new Burger();
        when(bun.getPrice()).thenReturn(4.4f);
        when(ingredient.getPrice()).thenReturn(2.2f);
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        float actual = burger.getPrice();

        assertEquals(0, Float.compare(11, actual));
    }

    @Test
    public void getReceiptReturnsCorrectReceipt() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        String bunName = "Bun";
        IngredientType ingredientType = IngredientType.valueOf("SAUCE");
        String ingredientName = "Sauce";
        float expectedPrice = 100f;
        Mockito.when(bun.getName()).thenReturn(bunName);
        Mockito.when(ingredient.getType()).thenReturn(ingredientType);
        Mockito.when(ingredient.getName()).thenReturn(ingredientName);
        Mockito.when(bun.getPrice()).thenReturn(50f);

        StringBuilder tmpReceipt = new StringBuilder(String.format("(==== %s ====)%n", bunName));
        tmpReceipt.append(String.format("= %s %s =%n", ingredientType.toString().toLowerCase(), ingredientName));
        tmpReceipt.append(String.format("(==== %s ====)%n", bunName));
        tmpReceipt.append(String.format("%nPrice: %f%n", expectedPrice));

        String expectedReceipt = tmpReceipt.toString();

        String actualReceipt = burger.getReceipt();

        assertEquals(expectedReceipt, actualReceipt);
    }
}
