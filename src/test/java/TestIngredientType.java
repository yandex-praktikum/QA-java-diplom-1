import org.testng.annotations.Test;
import praktikum.IngredientType;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class TestIngredientType {
    @Test
    public void sauceTest() {
        assertThat(IngredientType.valueOf("SAUCE"), is(notNullValue()));
    }
    @Test
    public void fillingTest() {
        assertThat(IngredientType.valueOf("FILLING"), is(notNullValue()));
    }
}