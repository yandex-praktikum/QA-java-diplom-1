import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class BurgerIngredientTest {

    Burger burger;
    Ingredient filling;
    Ingredient sauce;
    @Mock
    Bun bun;

    @Before
    public void setUp() {
        burger = new Burger();
        filling = new Ingredient(IngredientType.FILLING, "cutlet", 100);
        sauce = new Ingredient(IngredientType.SAUCE, "sour cream", 200);
        burger.addIngredient(sauce);
        burger.addIngredient(filling);
    }

    @Test
    public void shouldAddIngredient() {
        String expected = "cutlet";
        String actual = burger.ingredients.get(burger.ingredients.size() - 1).getName();
        assertEquals("Ингредиенты должны совпадать", expected, actual);
    }

    @Test
    public void shouldRemoveIngredient() {
        burger.removeIngredient(burger.ingredients.size() - 1);
        String expected = "sour cream";
        String actual = burger.ingredients.get(burger.ingredients.size() - 1).getName();
        assertEquals("Ингредиенты должны совпадать", expected, actual);
    }

    @Test
    public void shouldMoveIngredient() {
        burger.moveIngredient(0, burger.ingredients.size() - 1);
        String expected = "sour cream";
        String actual = burger.ingredients.get(burger.ingredients.size() - 1).getName();
        assertEquals("Ингредиенты должны совпадать", expected, actual);
    }
}
