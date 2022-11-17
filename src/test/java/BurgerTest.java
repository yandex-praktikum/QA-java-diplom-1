import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import praktikum.*;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    Burger burger;

    @Mock
    Bun bun;

    @Mock
    Ingredient ingredient;

    @Mock
    Ingredient ingredient2;

    @Before
    public void setup() {
        burger = new Burger();
    }

    @Test
    public void shouldSetBuns() {
        burger.setBuns(bun);
        assertEquals(bun, burger.bun);
    }

    @Test
    public void shouldAddIngredient() {
        burger.addIngredient(ingredient);
        assertEquals(List.of(ingredient), burger.ingredients);
    }

    @Test
    public void shouldRemoveIngredient() {
        burger.ingredients.add(ingredient);
        burger.removeIngredient(0);
        assertEquals(List.of(), burger.ingredients);
    }

    @Test
    public void shouldMoveIngredient() {
        burger.ingredients.addAll(Arrays.asList(ingredient, ingredient2));
        List<Ingredient> actual = new ArrayList<>(Arrays.asList(ingredient2, ingredient));
        burger.moveIngredient(0, 1);
        assertEquals(actual, burger.ingredients);
    }

    @Test
    public void shouldGetPrice() {
        burger.setBuns(bun);
        burger.ingredients.add(ingredient);
        Mockito.when(bun.getPrice()).thenReturn(100F);
        Mockito.when(ingredient.getPrice()).thenReturn(100F);
        assertEquals(300f, burger.getPrice(), 0);
    }

    @Test
    public void shouldGetReceipt() {
        burger.setBuns(bun);
        burger.ingredients.add(ingredient);
        Mockito.when(bun.getName()).thenReturn("black bun");
        Mockito.when(bun.getPrice()).thenReturn(100F);
        Mockito.when(ingredient.getType()).thenReturn(FILLING);
        Mockito.when(ingredient.getName()).thenReturn("cutlet");
        Mockito.when(ingredient.getPrice()).thenReturn(100F);
        String expected = String.format("(==== %s ====)%n", bun.getName()) +
                String.format("= %s %s =%n", ingredient.getType().toString().toLowerCase(),
                        ingredient.getName()) +
                String.format("(==== %s ====)%n", bun.getName()) +
                String.format("%nPrice: %f%n", burger.getPrice());
        assertEquals(expected, burger.getReceipt());
    }
}