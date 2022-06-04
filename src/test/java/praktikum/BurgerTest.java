package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    private static final String FILLING = "filling";
    private static final String SAUCE = "sauce";
    private static final String BUN_NAME = "bun";
    private static final float FILLING_PRICE = 200;
    private static final float SAUCE_PRICE = 100;
    private static final float BUN_PRICE = 10;

    @Mock
    private Bun bun;

    private Burger burger;

    @Before
    public void init() {
        burger = new Burger();
        burger.setBuns(bun);

        when(bun.getPrice()).thenReturn(BUN_PRICE);
        when(bun.getName()).thenReturn(BUN_NAME);
    }

    @Test
    public void testAddIngredient() {
        List<Ingredient> ingredients = Arrays.asList(
                new Ingredient(IngredientType.FILLING, FILLING, FILLING_PRICE),
                new Ingredient(IngredientType.SAUCE, SAUCE, SAUCE_PRICE));

        for (Ingredient ingredient : ingredients) {
            burger.addIngredient(ingredient);
        }

        assertEquals("Burger should have 1 ingredient!",
                ingredients.size(),
                burger.ingredients.size());

        for (int i = 0; i < ingredients.size(); i++) {
            assertEquals("Ingredient should be named '" + ingredients.get(i).name + "'!",
                    ingredients.get(i).name,
                    burger.ingredients.get(i).name);

            assertEquals("Ingredient should cost '" + ingredients.get(i).price + "'!",
                    ingredients.get(i).price,
                    burger.ingredients.get(i).price,
                    0);
        }
    }

    @Test
    public void testRemoveIngredient() {
        burger.addIngredient(new Ingredient(IngredientType.FILLING, FILLING, FILLING_PRICE));

        burger.removeIngredient(0);

        assertEquals("Burger should not have ingredients!",
                0,
                burger.ingredients.size());
    }

    @Test
    public void testMoveIngredient() {
        burger.addIngredient(new Ingredient(IngredientType.FILLING, FILLING, FILLING_PRICE));
        burger.addIngredient(new Ingredient(IngredientType.SAUCE, SAUCE, SAUCE_PRICE));

        burger.moveIngredient(0, 1);

        assertEquals("Burger should have the same size!",
                2,
                burger.ingredients.size());
        assertEquals("First ingredient should be '" + SAUCE + "'!",
                burger.ingredients.get(0).name,
                SAUCE);
        assertEquals("Second ingredient should be '" + FILLING + "'!",
                burger.ingredients.get(1).name,
                FILLING);
    }

    @Test
    public void testGetPrice() {
        float expectedPrice = BUN_PRICE * 2 + FILLING_PRICE + SAUCE_PRICE;

        burger.setBuns(new Bun(BUN_NAME, BUN_PRICE));
        burger.addIngredient(new Ingredient(IngredientType.FILLING, FILLING, FILLING_PRICE));
        burger.addIngredient(new Ingredient(IngredientType.SAUCE, SAUCE, SAUCE_PRICE));

        float resultPrice = burger.getPrice();

        assertEquals("The burger cost is different!",
                expectedPrice,
                resultPrice,
                0);
    }

    @Test
    public void testGetReceipt() {
        String expectedReceipt = "(==== bun ====)\r\n" +
                "= filling filling =\r\n" +
                "= sauce sauce =\r\n" +
                "(==== bun ====)\r\n" +
                "\r\nPrice: 320,000000\r\n";

        burger.setBuns(new Bun(BUN_NAME, BUN_PRICE));
        burger.addIngredient(new Ingredient(IngredientType.FILLING, FILLING, FILLING_PRICE));
        burger.addIngredient(new Ingredient(IngredientType.SAUCE, SAUCE, SAUCE_PRICE));

        String result = burger.getReceipt();

        assertEquals("Receipts should be equal!",
                expectedReceipt,
                result);
    }
}