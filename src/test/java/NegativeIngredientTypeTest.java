import org.junit.Test;
import praktikum.IngredientType;
import static org.junit.Assert.assertNotEquals;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.Collection;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
@RunWith(Parameterized.class)
public class NegativeIngredientTypeTest {
    @Parameterized.Parameter
    public IngredientType ingredientType;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        Object[][] data = new Object[][] { { IngredientType.SAUCE }, { IngredientType.FILLING } };
        return Arrays.asList(data);
    }

    @Test
    public void testIngredientType() {
        assertEquals(ingredientType, IngredientType.valueOf(ingredientType.name()));
    }

    @Test
    public void testInvalidIngredientType() {
        assertThrows(IllegalArgumentException.class, () -> IngredientType.valueOf("INVALID_TYPE"));
    }

}
