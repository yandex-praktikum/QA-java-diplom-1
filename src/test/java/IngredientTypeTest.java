import net.bytebuddy.matcher.ElementMatcher;
import org.junit.Test;
import praktikum.IngredientType;

import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.mockito.ArgumentMatchers.isNull;

public class IngredientTypeTest {
    @Test
    public void getIngredientTypeSauce() {
        assertThat(IngredientType.valueOf("SAUCE"), is(notNullValue()));
    }

    @Test
    public void getIngredientTypeFilling() {
        assertThat(IngredientType.valueOf("FILLING"), is(notNullValue()));
    }

    @Test(expected = Exception.class)
    public void getIngredientTypeZero() {
        assertThat(IngredientType.valueOf("ZERO"), isNull());
    }

    private void assertThat(IngredientType sauce, ElementMatcher.Junction<Object> objectJunction) {
    }
}