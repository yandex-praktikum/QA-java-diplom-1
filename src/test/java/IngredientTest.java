import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class IngredientTest {
    Ingredient ingredient = new Ingredient(IngredientType.FILLING, "testName", 1.1f);

    @Test
    public void validatePrice() {
        assertThat(ingredient.getPrice(), is(1.1f));
    }

    @Test
    public void validateName() {
        assertThat(ingredient.getName(), is("testName"));
    }

    @Test
    public void validateType() {
        assertThat(ingredient.getType(), is(IngredientType.FILLING));
    }
}
