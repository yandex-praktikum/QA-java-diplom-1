package praktikum;

import org.junit.Test;


public class IngredientTypeTest {

    @Test
    public void sauceTest() {
        assert IngredientType.SAUCE != null;
    }
    @Test
    public void fillingTest() {
        assert IngredientType.FILLING != null;
    }
}
