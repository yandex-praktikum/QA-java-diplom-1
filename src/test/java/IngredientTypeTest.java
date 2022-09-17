import jdk.jfr.Description;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import praktikum.IngredientType;

import java.util.Arrays;
import java.util.List;

public class IngredientTypeTest {
    @Test
    @DisplayName("Enum test")
    @Description("Тестирование Enum")
    public void enumTest() {
        List<IngredientType> ingredientTypes = Arrays.asList(IngredientType.SAUCE, IngredientType.FILLING);
        Assertions.assertTrue(ingredientTypes.contains(IngredientType.SAUCE));
    }
}
