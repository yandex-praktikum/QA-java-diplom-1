package praktikum;

import org.junit.Test;

import static org.junit.Assert.*;

public class IngredientTypeTest {
    @Test
    public void testIngredientTypeSAUCENotNull() {
        assert IngredientType.SAUCE != null;
    }

    @Test
    public void testIngredientTypeFillingNotNull() {
        assert IngredientType.FILLING != null;
    }

}