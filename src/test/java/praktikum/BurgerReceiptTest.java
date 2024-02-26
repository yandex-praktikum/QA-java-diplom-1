package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BurgerReceiptTest {
    private final Bun bun;
    private final List<Ingredient> ingredients;
    private final String expected;

    public BurgerReceiptTest(Bun bun, List<Ingredient> ingredients, String expected) {
        this.bun = bun;
        this.ingredients = ingredients;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Object[][] generateData() {
        return new Object[][]{
                {
                        new Bun("Black bun", 1f),
                        List.of(
                                new Ingredient(IngredientType.SAUCE, "Mayonnaise", 1f),
                                new Ingredient(IngredientType.FILLING, "Beef", 2f)
                        ),
                        "(==== Black bun ====)" + System.lineSeparator() +
                                "= sauce Mayonnaise =" + System.lineSeparator() +
                                "= filling Beef =" + System.lineSeparator() +
                                "(==== Black bun ====)" + System.lineSeparator() +
                                System.lineSeparator() +
                                "Price: 5,000000" + System.lineSeparator()
                },
                {
                        new Bun("White bun", 1f),
                        List.of(
                                new Ingredient(IngredientType.SAUCE, "Mayonnaise", 4f),
                                new Ingredient(IngredientType.FILLING, "Sausage", 1f)
                        ),
                        "(==== White bun ====)" + System.lineSeparator() +
                                "= sauce Mayonnaise =" + System.lineSeparator() +
                                "= filling Sausage =" + System.lineSeparator() +
                                "(==== White bun ====)" + System.lineSeparator() +
                                System.lineSeparator() +
                                "Price: 7,000000" + System.lineSeparator()
                },
                {
                        new Bun("Hot bun", 1f),
                        List.of(
                                new Ingredient(IngredientType.SAUCE, "Shirachi", 5.5f),
                                new Ingredient(IngredientType.FILLING, "sausage", 1f)
                        ),
                        "(==== Hot bun ====)" + System.lineSeparator() +
                                "= sauce Shirachi =" + System.lineSeparator() +
                                "= filling sausage =" + System.lineSeparator() +
                                "(==== Hot bun ====)" + System.lineSeparator() +
                                System.lineSeparator() +
                                "Price: 8,500000" + System.lineSeparator()
                },
        };
    }

    @Test
    public void burgerReceiptTest() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        ingredients.forEach(burger::addIngredient);
        String receipt = burger.getReceipt();
        assertEquals(expected, receipt);
    }
}
