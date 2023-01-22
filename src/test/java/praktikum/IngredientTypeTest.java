package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class IngredientTypeTest {
    @Test
    public void testIngredientType() {
        IngredientType sauce = IngredientType.SAUCE;
        IngredientType filling = IngredientType.FILLING;

        assertEquals("SAUCE", sauce.name());
        assertEquals("FILLING", filling.name());}
}
