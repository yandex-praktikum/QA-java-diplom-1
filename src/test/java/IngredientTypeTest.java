import org.junit.Test;
import static org.junit.Assert.assertNotNull;
import praktikum.IngredientType;
public class IngredientTypeTest {

    @Test
    public void sauceNotNullTest() {
        assertNotNull("Don't even want ketchup!?", IngredientType.SAUCE);
    }

    @Test
    public void fillingNotNullTest() {
        assertNotNull("Falafel is amazing today! Or Meat?", IngredientType.FILLING);
    }

}
