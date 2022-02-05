package praktikum;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import java.util.EnumSet;

import static org.junit.jupiter.api.Assertions.*;

public class IngredientTypeTest {

    @ParameterizedTest
    @EnumSource(value = IngredientType.class, names = {"SAUCE", "FILLING"})
    public void ingredientTypeIncludeTest(IngredientType ingredientType) {
        assertTrue(EnumSet.allOf(IngredientType.class).contains(ingredientType));
    }
}