import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Database;
import praktikum.Ingredient;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    Database data = new Database();
    @Mock
    private Bun bun;
    @Mock
    private Ingredient ingredient;
    @Mock
    private Ingredient filling;
    private Burger burger;

    @Before
    public void createBurger() {
        burger = new Burger();
    }

    @Test
    public void testSetBuns() {
        burger.setBuns(bun);
        assertEquals("Incorrect introduction of the bun dependency into burger", bun, burger.bun);
    }

    @Test
    public void testAddIngredient() {
        burger.addIngredient(ingredient);
        List<Ingredient> expect = List.of(ingredient);
        List<Ingredient> actual = burger.ingredients;

        assertEquals("Incorrect addition of an ingredient to the list", expect, actual);
    }

    @Test
    public void testRemoveIngredient() {
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        List<Ingredient> actual = burger.ingredients;

        assertEquals("Incorrect remove of an ingredient in the list", List.of(), actual);
    }

    @Test
    public void testMoveIngredient() {
        burger.addIngredient(filling);
        burger.addIngredient(ingredient);
        burger.moveIngredient(0, 1);
        Ingredient actual = burger.ingredients.get(1);

        assertEquals("Incorrect movement of an ingredient in the list", filling, actual);
    }

    @Test
    public void testBurgerGetPrice() {
        burger.setBuns(data.availableBuns().get(1));
        burger.addIngredient(data.availableIngredients().get(5));
        burger.addIngredient(data.availableIngredients().get(1));
        float actual = burger.getPrice();

        assertEquals(900, actual, 0);
    }

    @Test
    public void testBurgerGetReceipt() {
        burger.addIngredient(data.availableIngredients().get(1));
        burger.addIngredient(data.availableIngredients().get(5));
        burger.addIngredient(data.availableIngredients().get(1));
        burger.setBuns(data.availableBuns().get(2));
        Bun bun = burger.bun;

        StringBuilder receipt = new StringBuilder(String.format("(==== %s ====)%n", bun.getName()));
        List<Ingredient> ingredients = burger.ingredients;
        for (Ingredient ingredient : ingredients) {
            receipt.append(String.format("= %s %s =%n", ingredient.getType().toString().toLowerCase(),
                    ingredient.getName()));
        }

        receipt.append(String.format("(==== %s ====)%n", bun.getName()));
        receipt.append(String.format("%nPrice: %f%n", burger.getPrice()));

        assertEquals("Incorrect burger receipt", receipt.toString(), burger.getReceipt());
    }
}