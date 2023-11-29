package praktikum;

import org.junit.Test;

public class IngredientTypeTest {

    @Test
    public void testSauce() {
        assert IngredientType.valueOf("SAUCE") != null;
    }

    @Test
    public void testFilling() {
        assert  IngredientType.valueOf("FILLING") != null;
    }
}