import org.hamcrest.MatcherAssert;
import static org.hamcrest.CoreMatchers.notNullValue;
import org.junit.Test;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

public class IngredientTypeTest {

    // param?
    @Test
    public void shouldBeEnumEqual(){
        String expected = "SAUCE";  // ожидаемое значение
        assertEquals("IngredientType SAUCE not equal SAUCE", expected, IngredientType.SAUCE.toString());
     }
    @Test
    public void shouldBeEnumFilllingNotNull(){
        MatcherAssert.assertThat(IngredientType.FILLING, notNullValue());
    }
}
