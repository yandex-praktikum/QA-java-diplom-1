import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;

public class IngredientTest {

    @Test
    public void testGetPrice() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "Szechuan", 200.5F);
        assertThat(ingredient.getPrice(), equalTo(200.5F));
    }

    @Test
    public void testGetName() {
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, "pickles", 500.0F);
        assertThat(ingredient.getName(), equalTo("pickles"));
    }

    @Test
    public void testGetType() {
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, "pickles", 500.0F);
        assertThat(ingredient.getType(), equalTo(IngredientType.FILLING));
    }
}