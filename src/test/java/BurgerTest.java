import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    @Mock
    Bun bun;

    @Mock
    Ingredient ingredient;

    @Mock
    Ingredient ingredient1;

    @Spy
    Burger burger;


    @Test
    public void checkSetBuns() {
        Burger burger = Mockito.mock(Burger.class);

        burger.setBuns(bun);

        Mockito.verify(burger, times(1)).setBuns(bun);
    }

    @Test
    public void checkAddIngredient() {
        Burger burger = Mockito.mock(Burger.class);

        burger.addIngredient(ingredient);

        Mockito.verify(burger, times(1)).addIngredient(ingredient);
    }

    @Test
    public void checkRemoveIngredient() {
        List<Ingredient> ingredients = List.of(Mockito.mock(Ingredient.class));

        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient);
        burger.removeIngredient(1);

        assertEquals(1, ingredients.size());
        Mockito.verify(burger, times(2)).addIngredient(ingredient);
        Mockito.verify(burger, times(1)).removeIngredient(1);
    }

    @Test
    public void checkMoveIngredient() {
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient1);
        burger.moveIngredient(1, 0);

        Mockito.verify(burger, times(1)).moveIngredient(1, 0);
    }

    @Test
    public void checkGetPrice() {
        when(bun.getPrice()).thenReturn(100f);
        when(ingredient.getPrice()).thenReturn(200f);

        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        float actual = burger.getPrice();

        assertEquals(400, actual, 1E-4);
        Mockito.verify(bun, times(1)).getPrice();
        Mockito.verify(ingredient, times(1)).getPrice();
        Mockito.verify(burger, times(1)).setBuns(bun);
        Mockito.verify(burger, times(1)).addIngredient(ingredient);
        Mockito.verify(burger, times(1)).getPrice();
    }

    @Test
    public void checkGetReceipt() {
        when(bun.getName()).thenReturn("black bun");
        when(bun.getPrice()).thenReturn(100f);
        when(ingredient.getName()).thenReturn("hot sauce");
        when(ingredient.getType()).thenReturn(SAUCE);
        when(ingredient.getPrice()).thenReturn(100f);
        when(ingredient1.getName()).thenReturn("dinosaur");
        when(ingredient1.getType()).thenReturn(FILLING);
        when(ingredient1.getPrice()).thenReturn(200f);

        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient1);
        burger.getPrice();
        String actual = (String.format("(==== %s ====)%n", bun.getName()) + String.format("= %s %s =%n", ingredient.getType().toString().toLowerCase(),
                ingredient.getName()) + String.format("= %s %s =%n", ingredient1.getType().toString().toLowerCase(),
                ingredient1.getName()) + String.format("(==== %s ====)%n", bun.getName()) + String.format("%nPrice: %f%n", burger.getPrice()));


        assertEquals(actual, burger.getReceipt());
        Mockito.verify(burger, times(1)).setBuns(bun);
        Mockito.verify(burger, times(1)).addIngredient(ingredient);
        Mockito.verify(burger, times(1)).addIngredient(ingredient1);
        Mockito.verify(burger, times(3)).getPrice();
        Mockito.verify(burger, times(1)).getReceipt();
        Mockito.verify(bun, times(4)).getName();
        Mockito.verify(bun, times(3)).getPrice();
        Mockito.verify(ingredient, times(2)).getName();
        Mockito.verify(ingredient, times(2)).getType();
        Mockito.verify(ingredient, times(3)).getPrice();
        Mockito.verify(ingredient1, times(2)).getName();
        Mockito.verify(ingredient1, times(2)).getType();
        Mockito.verify(ingredient1, times(3)).getPrice();

    }

}
