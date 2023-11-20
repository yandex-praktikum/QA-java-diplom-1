package praktikum;

import org.junit.Test;

public class IngredientTypeTest {

    @Test
    public void testSauce() {
        assert IngredientType.SAUCE != null;
    }
    @Test
    public void testFilling() {
        assert IngredientType.FILLING != null;
    }
}