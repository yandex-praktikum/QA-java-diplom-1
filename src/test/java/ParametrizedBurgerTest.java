import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import java.util.Arrays;
import java.util.List;

import praktikum.*;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class ParametrizedBurgerTest {

    static Database database = new Database();
    static Ingredient ingredient1 = database.availableIngredients().get(1);
    static Ingredient ingredient2 = database.availableIngredients().get(3);
    static Ingredient ingredient3 = database.availableIngredients().get(5);

    Burger burger;

    @Before
    public void setup() {
        burger = new Burger();
        burger.ingredients.addAll(Arrays.asList(ingredient1, ingredient2, ingredient3));
    }

    @Parameters
    @Test
    public void shouldMoveIngredients(int index, int newIndex, List<Ingredient> ingredients) {
        burger.moveIngredient(index, newIndex);
        assertEquals(burger.ingredients, ingredients);
    }
    private Object[][] parametersForShouldMoveIngredients() {
        return new Object[][]{
                {0, 1, List.of(ingredient2, ingredient1, ingredient3)},
                {0, 2, List.of(ingredient2, ingredient3, ingredient1)},
                {1, 2, List.of(ingredient1, ingredient3, ingredient2)},
                {2, 0, List.of(ingredient3, ingredient1, ingredient2)},
                {2, 1, List.of(ingredient1, ingredient3, ingredient2)}
        };
    }

    @Parameters
    @Test
    public void shouldRemoveIngredient(int index, List<Ingredient> ingredients) throws Exception {
        burger.removeIngredient(index);
        assertEquals(burger.ingredients, ingredients);
    }
    private Object[][] parametersForShouldRemoveIngredient() {
        return new Object[][]{
                {0, List.of(ingredient2, ingredient3)},
                {1, List.of(ingredient1, ingredient3)},
                {2, List.of(ingredient1, ingredient2)}
        };
    }
}