import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

@RunWith(Parameterized.class)
public class BurgerReceiptTest {

    final String receipt;
    final float price;
    final List<Ingredient> ingredients;
    Bun bun;
    Burger burger;

    public BurgerReceiptTest(String receipt, float price, List<Ingredient> ingredients) {
        this.receipt = receipt;
        this.price = price;
        this.ingredients = ingredients;
        bun = mock(Bun.class);
    }

    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][]{
                {"(==== Булка ====)\n" +
                        "= sauce cheese sauce =\n" +
                        "= filling tomato =\n" +
                        "= filling onion =\n" +
                        "= filling beef =\n" +
                        "(==== Булка ====)\n" +
                        "\n" +
                        "Price: 120,000000\n", 120f, List.of(new Ingredient(IngredientType.SAUCE, "cheese sauce", 20),
                        new Ingredient(IngredientType.FILLING, "tomato", 30),
                        new Ingredient(IngredientType.FILLING, "onion", 10),
                        new Ingredient(IngredientType.FILLING, "beef", 50))},
                {"(==== Булка ====)\n" +
                        "= sauce cheese sauce =\n" +
                        "(==== Булка ====)\n" +
                        "\n" +
                        "Price: 30,000000\n", 30f, List.of(new Ingredient(IngredientType.SAUCE, "cheese sauce", 20))},
                {"(==== Булка ====)\n" +
                        "(==== Булка ====)\n" +
                        "\n" +
                        "Price: 10,000000\n", 10f, List.of()},
        };
    }

    @Before
    public void setUp() {
        Mockito.when(bun.getName()).thenReturn("Булка");
        Mockito.when(bun.getPrice()).thenReturn(5f);
        burger = new Burger();
        burger.setBuns(bun);
        for (Ingredient ingredient : ingredients) {
            burger.addIngredient(ingredient);
        }
    }

    @Test
    public void checkGetReceipt() {
        assertEquals("Receipt should equals", receipt, burger.getReceipt());
    }

    @Test
    public void checkGetPrice() {
        assertEquals("Price should equals", price, burger.getPrice(), 0);
    }
}
