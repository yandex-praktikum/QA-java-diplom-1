package praktikum;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class IngredientTypeTest {
    @Test
    public void checkFillingIsNotEmpty(){
        assertThat(IngredientType.FILLING, is(notNullValue()));
    }

    @Test
    public void checkSauceIsNotEmpty(){
        assertThat(IngredientType.SAUCE, is(notNullValue()));
    }
}
