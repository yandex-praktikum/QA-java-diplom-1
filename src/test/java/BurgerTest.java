import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Database;
import praktikum.Ingredient;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    @Mock
    Bun bunMock;
    @Mock
    Ingredient ingredientMock;
    Burger burger = new Burger();
    Burger defaultBurger = new Burger();
    Database database = new Database();
    List<Ingredient> burgerIngredients = new ArrayList<>();

    @Before
    public void setUp() {
        defaultBurger.setBuns(database.availableBuns().get(0));
        defaultBurger.addIngredient(database.availableIngredients().get(1));
        defaultBurger.addIngredient(database.availableIngredients().get(2));

        burgerIngredients.add(database.availableIngredients().get(2));
        burgerIngredients.add(database.availableIngredients().get(1));
    }

    @Test
    public void checkCanSetBuns() {
        Mockito.when(bunMock.getName()).thenReturn("bunName");
        burger.setBuns(bunMock);
        assertEquals("bunName", burger.bun.getName());
    }

    @Test
    public void checkCanAddIngredients() {
        burger.addIngredient(ingredientMock);
        assertTrue(burger.ingredients.contains(ingredientMock));
    }

    @Test
    public void checkCanRemoveIngredients() {
        burger.addIngredient(ingredientMock);
        burger.removeIngredient(0);
        assertFalse(burger.ingredients.contains(ingredientMock));
    }

    @Test
    public void checkCanMoveIngredients() {
        defaultBurger.moveIngredient(1, 0);
        assertEquals(burgerIngredients, defaultBurger.ingredients);
    }

    @Test
    public void checkCanGetBurgerPrice() {
        assertEquals(700, defaultBurger.getPrice(), 0);
    }

    @Test
    public void checkCanGetReceipt() {
        StringBuilder receipt = new StringBuilder(String.format("(==== %s ====)%n", defaultBurger.bun.getName()));

        for (Ingredient ingredient : defaultBurger.ingredients) {
            receipt.append(String.format("= %s %s =%n", ingredient.getType().toString().toLowerCase(),
                    ingredient.getName()));
        }

        receipt.append(String.format("(==== %s ====)%n", defaultBurger.bun.getName()));
        receipt.append(String.format("%nPrice: %f%n", defaultBurger.getPrice()));
        assertEquals(receipt.toString(), defaultBurger.getReceipt());
    }
}
