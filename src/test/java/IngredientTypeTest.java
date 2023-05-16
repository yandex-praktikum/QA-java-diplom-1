import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class IngredientTypeTest {

     @Test
    public void sauceTest() {
        assertEquals(IngredientType.SAUCE, IngredientType.valueOf("SAUCE"));}

    @Test
    public void fillingTest() {
        assertEquals(IngredientType.FILLING, IngredientType.valueOf("FILLING"));
    }
}
