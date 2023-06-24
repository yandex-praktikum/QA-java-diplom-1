import static org.junit.Assert.assertEquals;

import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    Bun bun;

    @Mock
    Ingredient ingredient;

    @Mock
    Ingredient sauce;

    @Mock
    Ingredient filling;

    private Burger burger;

    @Before
    public void createNewBurger() {
        burger = new Burger();
    }

    @Test
    public void addIngredient() {
        burger.addIngredient(ingredient);
        List<Ingredient> expected = List.of(ingredient);
        List<Ingredient> actual = burger.ingredients;

        assertEquals(expected, actual);
    }

    @Test
    public void removeIngredient() {
        burger.addIngredient(sauce);
        burger.addIngredient(filling);
        burger.addIngredient(sauce);
        burger.removeIngredient(0);
        List<Ingredient> actual = burger.ingredients;

        assertEquals(List.of(filling, sauce), actual);
    }

    @Test
    public void moveIngredient() {
        burger.addIngredient(sauce);
        burger.addIngredient(filling);
        burger.moveIngredient(1, 0);
        Ingredient actual = burger.ingredients.get(0);

        assertEquals(filling, actual);
    }

    @Test
    public void getReceipt() {
        Mockito.when(bun.getName()).thenReturn("softBun");
        Mockito.when(bun.getPrice()).thenReturn(60.0f);
        burger.setBuns(bun);

        Mockito.when(sauce.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(sauce.getName()).thenReturn("Sweet-chili");
        Mockito.when(sauce.getPrice()).thenReturn(45.0f);
        burger.addIngredient(sauce);

        Mockito.when(filling.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(filling.getName()).thenReturn("Chicken");
        Mockito.when(filling.getPrice()).thenReturn(35.0f);
        burger.addIngredient(filling);

        String expected = "(==== softBun ====)\n"
            + "= sauce Sweet-chili =\n"
            + "= filling Chicken =\n"
            + "(==== softBun ====)\n"
            + "\n"
            + "Price: 200,000000\n";
        String actual = burger.getReceipt();

        assertEquals(expected, actual);
    }
}
