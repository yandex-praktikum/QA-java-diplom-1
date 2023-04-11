import org.junit.Test;
import praktikum.IngredientType;


import static org.junit.Assert.*;

public class IngredientTypeTest {

    @Test
    public void testSauceToString() {
        assertEquals("SAUCE", IngredientType.SAUCE.toString());
    }
    @Test
    public void testFillingToString() {
        assertEquals("FILLING", IngredientType.FILLING.toString());
    }
    @Test
    public void ingredientTypeTestFillingName() {
        assertEquals("SAUCE", IngredientType.SAUCE.name());
    }
    @Test
    public void ingredientTypeTestSauceName() {
        assertEquals("FILLING", IngredientType.FILLING.name());
    }
}
