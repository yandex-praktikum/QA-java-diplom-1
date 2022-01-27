package praktikum;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

class IngredientTypeTest {
    @ParameterizedTest
    @EnumSource(IngredientType.class)
    void testWithEnumSource(IngredientType type) {
        Assertions.assertNotNull(type);
    }
}