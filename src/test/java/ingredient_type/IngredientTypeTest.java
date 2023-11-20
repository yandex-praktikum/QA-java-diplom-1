package ingredient_type;

import org.junit.Test;
import praktikum.IngredientType;

import static org.junit.Assert.assertNotNull;

public class IngredientTypeTest {
    @Test
    public void fillingExistTest() {
        assertNotNull("Fail", IngredientType.FILLING);
    }
    @Test
    public void sauceExistTest(){
        assertNotNull("Fail", IngredientType.SAUCE);
    }
}
