package praktikum;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class IngredientTypeTest {
    @Test
    public void sauceIsNotNullTest() {
        assertThat(IngredientType.valueOf("SAUCE"), notNullValue());
    }

    @Test
    public void fillingIsNotNullTest() {
        assertThat(IngredientType.valueOf("FILLING"), notNullValue());
    }

}