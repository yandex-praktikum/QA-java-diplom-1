package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(value = Parameterized.class)
public class BurgerTest {

    private static final String FILLING = "filling";
    private static final String SAUCE = "sauce";
    private static final String BUN = "bun";
    private static final float FILLING_PRICE = 200;
    private static final float SAUCE_PRICE = 100;
    private static final int BUN_PRICE = 10;

    private List<Ingredient> inputIngredients;
    private int expectedSize;

    public BurgerTest(List<Ingredient> inputIngredients, int expectedSize) {
        this.inputIngredients = inputIngredients;
        this.expectedSize = expectedSize;
    }

    @Parameterized.Parameters(name = "{index}: testAdd({0}+{1}) = {2}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {Arrays.asList(new Ingredient(IngredientType.FILLING, FILLING, FILLING_PRICE)), 1},
                {Arrays.asList(new Ingredient(IngredientType.FILLING, FILLING, FILLING_PRICE),
                        new Ingredient(IngredientType.SAUCE, SAUCE, SAUCE_PRICE)), 2}
        });
    }

    @Test
    public void testAddIngredient() {
        Burger burger = new Burger();

        for (Ingredient ingredient : inputIngredients) {
            burger.addIngredient(ingredient);
        }

        assertEquals("Burger should have 1 ingredient!",
                inputIngredients.size(),
                burger.ingredients.size());

        for (int i = 0; i < inputIngredients.size(); i++) {
            assertEquals("Ingredient should be named '" + inputIngredients.get(i).name + "'!",
                    inputIngredients.get(i).name,
                    burger.ingredients.get(i).name);

            assertEquals("Ingredient should cost '" + inputIngredients.get(i).price + "'!",
                    inputIngredients.get(i).price,
                    burger.ingredients.get(i).price,
                    0);
        }
    }

    @Test
    public void testRemoveIngredient() {
        Burger burger = new Burger();

        burger.addIngredient(new Ingredient(IngredientType.FILLING, FILLING, FILLING_PRICE));

        burger.removeIngredient(0);

        assertEquals("Burger should not have ingredients!",
                0,
                burger.ingredients.size());
    }

    @Test
    public void testMoveIngredient() {
        Burger burger = new Burger();

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
        Burger burger = new Burger();

        float expectedPrice = BUN_PRICE * 2 + FILLING_PRICE + SAUCE_PRICE;

        burger.setBuns(new Bun(BUN, BUN_PRICE));
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
        Burger burger = new Burger();

        String expectedReceipt = "(==== bun ====)\r\n" +
                "= filling filling =\r\n" +
                "= sauce sauce =\r\n" +
                "(==== bun ====)\r\n" +
                "\r\nPrice: 320,000000\r\n";

        burger.setBuns(new Bun(BUN, BUN_PRICE));
        burger.addIngredient(new Ingredient(IngredientType.FILLING, FILLING, FILLING_PRICE));
        burger.addIngredient(new Ingredient(IngredientType.SAUCE, SAUCE, SAUCE_PRICE));

        String result = burger.getReceipt();

        assertEquals("Receipts should be equal!",
                expectedReceipt,
                result);
    }
}