package praktikum;


import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static praktikum.IngredientType.SAUCE;


public class IngredientTest {

    @Test
    public void testGetName() {
        Ingredient ingredient = new Ingredient(IngredientType.FILLING,"котлета",150);
        assertThat(ingredient.getName()).isEqualTo("котлета");
    }

    @Test
    public void testGetPrice() {
        Ingredient ingredient = new Ingredient(SAUCE,"чили",30);
        assertThat(ingredient.getPrice()).isEqualTo(30);
        }

    @Test
    public void testGetType() {
        IngredientType expected = SAUCE;
        Ingredient ingredient = new Ingredient(expected,"чили",30);
        assertThat(ingredient.getType()).isEqualTo(expected);
    }
}


