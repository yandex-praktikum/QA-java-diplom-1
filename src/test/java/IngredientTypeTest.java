import org.junit.Test;
import praktikum.IngredientType;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class IngredientTypeTest {

    @Test
    public void shouldIngredientTypes(){
        assertThat(IngredientType.valueOf("SAUCE"), is(notNullValue()));
        assertThat(IngredientType.valueOf("FILLING"), is(notNullValue()));
    }


}
