package praktikum;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IngredientParametrizedTest {

    @ParameterizedTest
    @MethodSource("nameDataProvider")
    public void getNameCorrectValueReturned(String expected, IngredientType type, String name, float price) {
        Ingredient ingredient = new Ingredient(type, name, price);
        assertEquals(expected, ingredient.getName(), "Incorrect Name value returned");
    }

    private static Stream<Arguments> nameDataProvider() {
        return Stream.of(
                Arguments.of("Test", IngredientType.FILLING, "Test", 0.01f),
                Arguments.of("Test name", IngredientType.FILLING, "Test name", 0.01f),
                Arguments.of("Test", IngredientType.FILLING, " Test", 0.01f),
                Arguments.of("Test", IngredientType.FILLING, "Test ", 0.01f)

        );
    }

    @ParameterizedTest
    @MethodSource("priceDataProvider")
    public void getPriceCorrectValueReturned(double expected, IngredientType type, String name, float price) {
        Ingredient ingredient = new Ingredient(type, name, price);
        assertEquals(expected, ingredient.getPrice(), "Incorrect Price value returned");
    }

    private static Stream<Arguments> priceDataProvider() {
        return Stream.of(
                Arguments.of(0f, IngredientType.FILLING, "Test", 0),
                Arguments.of(0.01f, IngredientType.FILLING, "Test", 0.01f),
                Arguments.of(1f, IngredientType.FILLING, "Test", 1),
                Arguments.of(12.23f, IngredientType.FILLING, "Test", 12.23f),
                Arguments.of(0f, IngredientType.FILLING, "Test", -12.23f)
        );
    }

    @ParameterizedTest
    @MethodSource("typeDataProvider")
    public void geTypeCorrectValueReturned(IngredientType expected, IngredientType type, String name, float price) {
        Ingredient ingredient = new Ingredient(type, name, price);
        assertEquals(expected, ingredient.getType(), "Incorrect Type value returned");
    }

    private static Stream<Arguments> typeDataProvider() {
        return Stream.of(
                Arguments.of(IngredientType.FILLING, IngredientType.FILLING, "Test", 1.12f),
                Arguments.of(IngredientType.SAUCE, IngredientType.SAUCE, "Test", 1.12f)
        );
    }
}