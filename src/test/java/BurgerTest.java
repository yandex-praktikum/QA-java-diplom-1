import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class BurgerTest {
    private Burger burger;

    @Parameterized.Parameter
    public String ingredientName;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"cutlet"},
                {"dinosaur"},
                {"sausage"}
        });
    }

    @Before
    public void setUp() {
        burger = new Burger();
        Bun bun = new Bun("Bun", 1.5f);
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, "chili sauce", 2.0f);
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
    }

    @Test
    public void testAddIngredient() {
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, ingredientName, 1.0f);
        burger.addIngredient(ingredient);
        assertTrue(burger.ingredients.contains(ingredient));
    }

    @Test
    public void testRemoveIngredient() {
        int initialSize = burger.ingredients.size();
        burger.removeIngredient(0);
        assertEquals(initialSize - 1, burger.ingredients.size());
    }

    @Test
    public void testMoveIngredient() {
        Ingredient initialIngredient = new Ingredient(IngredientType.FILLING, "sausage", 1.0f);
        burger.addIngredient(initialIngredient);

        int initialIndex = 0;
        int newIndex = 1;
        Ingredient movedIngredient = burger.ingredients.get(initialIndex);
        burger.moveIngredient(initialIndex, newIndex);
        assertEquals(movedIngredient, burger.ingredients.get(newIndex));
    }

    @Test
    public void testGetPrice() {
        float bunPrice = 1.5f;
        float sausagePrice = 2.0f;
        float expectedPrice = bunPrice * 2 + sausagePrice;
        assertEquals(expectedPrice, burger.getPrice(), 0.01);
    }

    @Test
    public void testGetReceiptWithNoIngredients() {
        Bun bun = new Bun("white bun", 200);
        Burger burger = new Burger();
        burger.setBuns(bun);

        String receipt = burger.getReceipt();

        String expectedReceipt = "(==== white bun ====)\n" +
                "(==== white bun ====)\n" +
                "\n" +
                "Price: 400,000000\n";

        assertEquals(expectedReceipt, receipt);
    }
}
