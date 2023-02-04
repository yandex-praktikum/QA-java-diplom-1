package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class AddIngredientsTest {
    Burger burger;
    private final List<Ingredient> ingredients;
    private final int expectedResult;

    public AddIngredientsTest(List<Ingredient> ingredients, int expectedResult) {
        this.ingredients = ingredients;
        this.expectedResult = expectedResult;
    }

    @Parameterized.Parameters(name = "Number of ingredients " + "{1}")
    public static Object[][] getTestData() {
        return new Object[][] {
                {List.of(new Ingredient(IngredientType.FILLING, "test ingredient one", 100)), 1},

                {List.of(new Ingredient(IngredientType.FILLING, "test ingredient one", 100),
                        new Ingredient(IngredientType.FILLING, "test ingredient two", 200)), 2},

                {List.of(new Ingredient(IngredientType.FILLING, "test ingredient one", 100),
                        new Ingredient(IngredientType.FILLING, "test ingredient two", 200),
                        new Ingredient(IngredientType.FILLING, "test ingredient three", 300)), 3}
        };
    }

    @Before
    public void setUp() {
        burger = new Burger();
    }

    @Test
    public void addIngredientShouldChangeIngredientsListSize() {
        for (Ingredient ingredient : ingredients) {
            burger.addIngredient(ingredient);
        }
        assertEquals(expectedResult, burger.ingredients.size());
    }
}
