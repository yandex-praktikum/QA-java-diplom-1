package praktikum;

import org.junit.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class BurgerTest {
    Burger burger = new Burger();
    @Mock
    private Bun bun;
    @Mock
    Ingredient sauce;
    @Mock
    Ingredient filling;

    @Test
    public void setBunsTest() {
        burger.setBuns(bun);
        assertEquals(bun, burger.bun);
    }

    @Test
    public void addIngredientTest() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "кетчуп", 20f);
        burger.addIngredient(ingredient);
        assertEquals(List.of(ingredient), burger.ingredients);
    }

    @Test
    public void removeIngredientTest() {
        burger.addIngredient(sauce);
        burger.addIngredient(filling);
        burger.removeIngredient(0);
        assertEquals(1, burger.ingredients.size());
    }

    @Test
    public void moveIngredientTest() {
        burger.addIngredient(sauce);
        burger.addIngredient(filling);
        burger.moveIngredient(1, 0);
        assertEquals("Ингредиенты изменены", new ArrayList<>(Arrays.asList(sauce, filling)), burger.ingredients);
    }

    @Test
    public void getPriceTest() {
        Bun bun = new Bun("булочка", 10f);
        burger.setBuns(bun);
        var actual = burger.getPrice();
        var expected = bun.getPrice() * 2;
        assertEquals(expected, actual, 0);
    }

    @Test
    public void getReceiptTest() {
        Bun bun = new Bun("Булочка", 10f);
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "кетчуп", 10f);
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        var expected =
                "(==== Булочка ====)\r\n" +
                        "= sauce кетчуп =\r\n" +
                        "(==== Булочка ====)\r\n" +
                        "\r\n" +
                        "Price: 30,000000\r\n";
        var actual = burger.getReceipt();
        assertEquals(expected, actual);
    }
}
