package praktikum;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class IngredientTest {
    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(IngredientType.FILLING, "BLACK", -500),
                Arguments.of(IngredientType.SAUCE, "White snow", 48967),
                Arguments.of(IngredientType.FILLING, "red dog", 999),
                Arguments.of(IngredientType.FILLING, "Сat fat", 456)
        );
    }

    @ParameterizedTest
    @MethodSource("testData")
    void checkNamePriceType(IngredientType type, String name, float price) {
        Ingredient ingredient = new Ingredient(type, name, price);
        Assertions.assertEquals(name, ingredient.getName());
        Assertions.assertEquals(price, ingredient.getPrice());
        Assertions.assertEquals(type, ingredient.getType());
    }
}