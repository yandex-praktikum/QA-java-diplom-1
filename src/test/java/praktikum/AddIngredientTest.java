package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Collections;
import java.util.List;

@RunWith(Parameterized.class)
public class AddIngredientTest {
    private final int expectedSize;
    private final List<Ingredient> ingredients;

    public AddIngredientTest(int expectedSize, List<Ingredient> ingredients) {
        this.expectedSize = expectedSize;
        this.ingredients = ingredients;
    }

    @Parameterized.Parameters
    public static Object[][] ingredientsIncludeCheck() {
        return new Object[][]{
                {0, Collections.emptyList()},
                {1, Collections.singletonList(new Ingredient(IngredientType.FILLING, "name", 100500.0f))},
                {2, List.of(new Ingredient(IngredientType.FILLING, "name", 100500.0f), new Ingredient(IngredientType.FILLING, "name", 100500.0f))},
        };
    }

    @Test
    public void test() {
        Burger burger = new Burger();
        for (Ingredient ingredient : ingredients) {
            burger.addIngredient(ingredient);
        }
        Assert.assertEquals(expectedSize, burger.ingredients.size());
    }
}
