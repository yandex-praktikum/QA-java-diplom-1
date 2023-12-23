package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;

import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTests {
    Burger burger;

    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient;
    @Mock
    Ingredient newIngredient;

    @Before
    public void setUp() {
        burger = new Burger();
    }

    @Test
    public void addIngredientTest() {

        int expected = 3;
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient);

        assertEquals(expected, burger.ingredients.size());
    }

    @Test
    public void removeIngredientTest() {

        int expected = 1;
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient);
        burger.removeIngredient(1);

        assertEquals(expected, burger.ingredients.size());
    }

    @Test
    public void setBunsTest() {

        burger.setBuns(bun);
        assertEquals(bun, burger.bun);

    }

    @Test
    public void moveIngredientTest() {

        burger.ingredients.add(ingredient);
        burger.ingredients.add(newIngredient);
        List<Ingredient> actual = new ArrayList<>(Arrays.asList(newIngredient, ingredient));
        burger.moveIngredient(0, 1);

        assertEquals(actual, burger.ingredients);

    }

    @Test
    public void getPriceTest() {

        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        Mockito.when(bun.getPrice()).thenReturn(33F);
        Mockito.when(ingredient.getPrice()).thenReturn(77F);

        assertEquals(143, burger.getPrice(), 0);

    }
    @Test
    public void getReceiptTest() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient);

        Mockito.when(bun.getName()).thenReturn("Флюоресцентная булка");
        Mockito.when(bun.getPrice()).thenReturn(988F);
        Mockito.when(ingredient.getType()).thenReturn(FILLING);
        Mockito.when(ingredient.getName()).thenReturn("Говяжий метеорит");
        Mockito.when(ingredient.getPrice()).thenReturn(3000F);

        String expected = String.format("(==== %s ====)%n", bun.getName()) +
                          String.format("= %s %s =%n", ingredient.getType().toString().toLowerCase(), ingredient.getName()) +
        String.format("(==== %s ====)%n", bun.getName()) +
        String.format("%nPrice: %f%n", burger.getPrice());

         assertEquals(expected, burger.getReceipt());
    }

}
