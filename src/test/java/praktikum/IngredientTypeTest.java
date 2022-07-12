package praktikum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

public class IngredientTypeTest {

    @Test
    public void shouldGetSauceFromEnum() {

        assertEquals("Ingredient type Sauce does not exist", "SAUCE", SAUCE.name());
    }

    @Test
    public void shouldGetFillingFromEnum() {

        assertEquals("Ingredient type Filling does not exist", "FILLING", FILLING.name());
    }

    @Test
    public void ingredientsTypeCountShouldBeEqualTwo() {
        int expected = 2;
        assertEquals("Wrong amount of ingredients types", expected, IngredientType.values().length);
    }
}
