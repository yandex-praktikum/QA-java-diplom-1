package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.*;

public class BurgerTest {
    private Burger burger;

    @Mock
    private Bun bun;

    @Mock
    private Ingredient sauce;

    @Mock
    private Ingredient filling;

    private Ingredient[] ingredients;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);

        Mockito.when(bun.getName()).thenReturn("bun");
        Mockito.when(bun.getPrice()).thenReturn(100f);

        Mockito.when(sauce.getName()).thenReturn("chili sauce");
        Mockito.when(sauce.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(sauce.getPrice()).thenReturn(300f);

        Mockito.when(filling.getName()).thenReturn("sausage");
        Mockito.when(filling.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(filling.getPrice()).thenReturn(200f);

        burger = new Burger();
        ingredients = new Ingredient[] { sauce, filling };

        burger.setBuns(bun);
        for (var ingredient : ingredients) {
            burger.addIngredient(ingredient);
        }
    }

    @Test
    public void setBuns() {
        assertEquals(bun, burger.bun);
    }

    @Test
    public void addIngredient() {
        assertArrayEquals(ingredients, burger.ingredients.toArray());
    }

    @Test
    public void removeIngredient() {
        burger.removeIngredient(1);

        assertArrayEquals(Arrays.copyOfRange(ingredients, 0, 1), burger.ingredients.toArray());
    }

    @Test
    public void moveIngredient() {
        var expected = Arrays.asList(ingredients);

        burger.moveIngredient(1, 0);
        Collections.reverse(expected);

        assertArrayEquals(expected.toArray(), burger.ingredients.toArray());
    }

    @Test
    public void getPrice() {
        assertEquals(700f, burger.getPrice(), 0f);
    }

    @Test
    public void getReceipt() {
        var expected = String.format(
                "(==== %s ====)%n= %s %s =%n= %s %s =%n(==== %s ====)%n%nPrice: 700,000000%n",
                bun.getName(),
                sauce.getType().name().toLowerCase(),
                sauce.getName(),
                filling.getType().name().toLowerCase(),
                filling.getName(),
                bun.getName()
        );

        assertEquals(expected, burger.getReceipt());
    }
}