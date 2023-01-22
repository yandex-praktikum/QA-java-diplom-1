package praktikum;

import org.testng.annotations.Test;

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
