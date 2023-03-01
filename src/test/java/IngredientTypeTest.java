import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTypeTest {

    private final String i_type;
    private final Integer i_index;

    public IngredientTypeTest(Integer i_index, String i_type) {
        this.i_index = i_index;
        this.i_type = i_type;
    }

    @Parameterized.Parameters
    public static Object[][] getIngredientsType() {
        return new Object[][]{
                {0, "SAUCE"},
                {1, "FILLING"}
        };
    }
    @Test
    public void enumTest() {
        assertEquals(IngredientType.values()[i_index].toString(), i_type);
    }
}
