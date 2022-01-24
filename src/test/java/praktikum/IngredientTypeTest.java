package praktikum;

import org.junit.Test;

public class IngredientTypeTest {

    @Test
    public void valueOf() {
        IngredientType.valueOf("SAUCE");
        IngredientType.valueOf("FILLING");
    }
}