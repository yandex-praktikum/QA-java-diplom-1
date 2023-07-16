import org.junit.Test;
import praktikum.IngredientType;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;

public class IngredientTypeTest {

    @Test
    public void checkIngredientTypeHasNotNullValueTest() {
        assertThat(IngredientType.valueOf("SAUCE"), notNullValue());
        assertThat(IngredientType.valueOf("FILLING"), notNullValue());
    }

    @Test
    public void checkValueOfSauceTest() {
        assertEquals(IngredientType.SAUCE, IngredientType.valueOf("SAUCE"));
    }

    @Test
    public void checkValueOfFillingTest() {
        assertEquals(IngredientType.FILLING, IngredientType.valueOf("FILLING"));
    }
}