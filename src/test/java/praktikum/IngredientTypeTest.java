package praktikum;

import org.junit.Test;

public class IngredientTypeTest {

    @Test
    public void ingredientSauceNotNull() {
        assert IngredientType.SAUCE != null;
    }

    @Test
    public void ingredientFillingNotNull() {
        assert IngredientType.FILLING != null;
    }
}