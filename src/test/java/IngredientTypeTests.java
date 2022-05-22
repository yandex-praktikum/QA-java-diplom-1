import org.junit.Test;
import praktikum.IngredientType;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class IngredientTypeTests {

    @Test
    public void doesFillingValueExist() {
        assertThat(IngredientType.valueOf("FILLING"), notNullValue());
    }
    @Test
    public void doesSauceValueExist() {
        assertThat(IngredientType.valueOf("SAUCE"), notNullValue());
    }
}
