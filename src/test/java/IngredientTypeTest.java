import org.junit.Test;
import praktikum.IngredientType;

import static praktikum.IngredientType.*;

public class IngredientTypeTest {
    IngredientType ingredientType;

    @Test
    public void getIngredientTypeSAUCEPositiveTest() {
        ingredientType = SAUCE;
        ingredientType.equals(SAUCE);
    }

    @Test
    public void getIngredientTypeFILLINGPositiveTest() {
        ingredientType = FILLING;
        ingredientType.equals(FILLING);
    }
}
