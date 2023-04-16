package praktikum;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.*;
import static praktikum.IngredientType.*;


public class BurgerIngredientsTest {

    @ParameterizedTest
    @DisplayName("Название булки")
    @MethodSource("provideBunNames")
    void bunNameTest(String desc, String name) {
        float price = 1255F;
        Bun bun = new Bun(name, price);
        assertAll("Bun fields",
                () -> assertEquals(name, bun.getName()),
                () -> assertEquals(price, bun.getPrice())
        );
    }

    @ParameterizedTest
    @DisplayName("Цена булки")
    @MethodSource("provideBunPrices")
    void bunPriceTest(String desc, float price) {
        String name = "Краторная булка N-200i";
        Bun bun = new Bun(name, price);
        assertAll("Bun fields",
                () -> assertEquals(name, bun.getName()),
                () -> assertEquals(price, bun.getPrice())
        );
    }

    @ParameterizedTest
    @DisplayName("Ингредиент")
    @MethodSource("provideIngredients")
    void ingredientTest(IngredientType type, String name, float price) {
        Ingredient ingredient = new Ingredient(type, name, price);
        assertAll("Bun fields",
                () -> assertEquals(type, ingredient.getType()),
                () -> assertEquals(name, ingredient.getName()),
                () -> assertEquals(price, ingredient.getPrice())
        );
    }

    private static Stream<Arguments> provideIngredients() {
        return Stream.of(
                Arguments.of(SAUCE, "Соус Spicy-X", 5F),
                Arguments.of(SAUCE, "Соус традиционный галактический", 9.6F),
                Arguments.of(FILLING, "Биокотлета из марсианской Магнолии", 11F)
        );
    }

    private static Stream<Arguments> provideBunNames() {
        return Stream.of(
                Arguments.of("Типичное название", "Краторная булка N-200i"),
                Arguments.of("Со спецсимволами", "Булка\t`~§\n"),
                Arguments.of("Пустая строка", ""),
                Arguments.of("null", null),
                Arguments.of("Очень большая строка", RandomStringUtils.randomAscii(10000))
        );
    }

    private static Stream<Arguments> provideBunPrices() {
        return Stream.of(
                Arguments.of("Обычная", 1255F),
                Arguments.of("Ноль", 0),
                Arguments.of("Отрицательное значение", -10F),
                Arguments.of("Минимальная положительная", Float.MIN_VALUE),
                Arguments.of("Максимально возможная положительная", Float.MAX_VALUE),
                Arguments.of("Максимально возможная отрицательная", Float.MAX_VALUE * -1)
        );
    }
}
