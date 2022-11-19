package praktikum;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;

public class IngredientTypeTest {

    @Test
    public void valueOf() {
        assertThat(IngredientType.valueOf("SAUCE"), is(notNullValue()));
        assertThat(IngredientType.valueOf("FILLING"), is(notNullValue()));
    }
}