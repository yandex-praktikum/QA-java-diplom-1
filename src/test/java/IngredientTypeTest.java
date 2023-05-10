import org.hamcrest.MatcherAssert;
import org.junit.Test;
import praktikum.IngredientType;

import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertEquals;

public class IngredientTypeTest {
    @Test
    public void checkEnumEqual(){
        String expected = "SAUCE";
        assertEquals("IngredientType SAUCE not equal SAUCE", expected, IngredientType.SAUCE.toString());
    }
    @Test
    public void checkEnumFillingNotNull(){
        MatcherAssert.assertThat(IngredientType.FILLING, notNullValue());
    }
}
