package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BurgerGetReceiptTest {
    private final Bun bun;
    private final List<Ingredient> ingredients;
    private final String expectedResult;

    public BurgerGetReceiptTest(Bun bun, List<Ingredient> ingredients, String expectedResult) {
        this.bun = bun;
        this.ingredients = ingredients;
        this.expectedResult = expectedResult;
    }

    @Test
    public void verifyGetReceipt() {
        // given
        Burger burger = new Burger();
        burger.setBuns(bun);
        ingredients.forEach(burger::addIngredient);

        // when
        String receipt = burger.getReceipt();

        // given
        assertEquals(expectedResult, receipt);
    }

    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][]{
                {
                        new Bun("black bun", 100f),
                        List.of(
                                new Ingredient(IngredientType.SAUCE, "sour cream", 200f),
                                new Ingredient(IngredientType.FILLING, "cutlet", 100f),
                                new Ingredient(IngredientType.FILLING, "dinosaur", 200f)
                        ),
                        "(==== black bun ====)" + System.lineSeparator() +
                                "= sauce sour cream =" + System.lineSeparator() +
                                "= filling cutlet =" + System.lineSeparator() +
                                "= filling dinosaur =" + System.lineSeparator() +
                                "(==== black bun ====)" + System.lineSeparator() +
                                System.lineSeparator() +
                                "Price: 700,000000" + System.lineSeparator()
                },
                {
                        new Bun("white bun", 1f),
                        List.of(
                                new Ingredient(IngredientType.FILLING, "cutlet", 0.5f),
                                new Ingredient(IngredientType.SAUCE, "chili sauce", 4f),
                                new Ingredient(IngredientType.FILLING, "sausage", 1f)
                        ),
                        "(==== white bun ====)" + System.lineSeparator() +
                                "= filling cutlet =" + System.lineSeparator() +
                                "= sauce chili sauce =" + System.lineSeparator() +
                                "= filling sausage =" + System.lineSeparator() +
                                "(==== white bun ====)" + System.lineSeparator() +
                                System.lineSeparator() +
                                "Price: 7,500000" + System.lineSeparator()
                },
                {
                        new Bun("red bun", 1f),
                        List.of(
                                new Ingredient(IngredientType.SAUCE, "hot sauce", 5.5f),
                                new Ingredient(IngredientType.FILLING, "sausage", 14.5f),
                                new Ingredient(IngredientType.FILLING, "dinosaur", 200f)
                        ),
                        "(==== red bun ====)" + System.lineSeparator() +
                                "= sauce hot sauce =" + System.lineSeparator() +
                                "= filling sausage =" + System.lineSeparator() +
                                "= filling dinosaur =" + System.lineSeparator() +
                                "(==== red bun ====)" + System.lineSeparator() +
                                System.lineSeparator() +
                                "Price: 222,000000" + System.lineSeparator()
                },
        };
    }
}
