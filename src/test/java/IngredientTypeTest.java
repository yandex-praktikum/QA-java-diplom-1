import org.junit.Test;
import praktikum.IngredientType;
import static org.junit.Assert.assertEquals;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)

public class IngredientTypeTest {
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

}

