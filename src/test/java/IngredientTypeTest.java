import praktikum.IngredientType;
import org.junit.Test;
import static org.junit.Assert.assertNotNull;

public class IngredientTypeTest {
    @Test
    public void testFillingIsNotNull() {
        assertNotNull(IngredientType.valueOf("FILLING"));
    }
    @Test
    public void testSauceIsNotNull() {
        assertNotNull(IngredientType.valueOf("SAUCE"));
    }
}
