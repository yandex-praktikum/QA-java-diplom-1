package praktikum;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class IngredientTypeTest {
    @Test
    public void valueOfFillingType() {
       assertThat(IngredientType.FILLING, is(notNullValue()));
    }

    @Test
    public void valueOfSauceType() {
        assertThat(IngredientType.SAUCE, is(notNullValue()));
    }
}