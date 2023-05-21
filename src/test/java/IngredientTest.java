import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.Random;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.of;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

public class IngredientTest {
    private static Random random = new Random();
    private static Stream <Arguments> getDataForIngredients() {
        return Stream.of(
                of(SAUCE, RandomStringUtils.randomAlphabetic(1), random.nextFloat()),
                of(FILLING, RandomStringUtils.randomAlphabetic(99), random.nextFloat()),
                of(SAUCE, RandomStringUtils.randomAlphabetic(25), random.nextFloat()),
                of(FILLING, "Морковь немытая Россия", 1)
        );
    }
    @ParameterizedTest(name = "Проверка получения типа ингредиента: тип {0}, название {1}, цена {2}")
    @MethodSource("getDataForIngredients")
    public void checkIngredientType(IngredientType type, String name, float price) {
        Ingredient ingredient = new Ingredient(type, name, price);
        assertEquals(type, ingredient.getType());
    }

    @ParameterizedTest(name = "Проверка получения названия ингредиента: тип {0}, название {1}, цена {2}")
    @MethodSource("getDataForIngredients")
    public void checkIngredientName(IngredientType type, String name, float price) {
        Ingredient ingredient = new Ingredient(type, name, price);
        assertEquals(name, ingredient.getName());
    }

    @ParameterizedTest(name = "Проверка получения цены ингредиента: тип {0}, название {1}, цена {2}")
    @MethodSource("getDataForIngredients")
    public void checkIngredientPrice(IngredientType type, String name, float price) {
        Ingredient ingredient = new Ingredient(type, name, price);
        assertEquals(price, ingredient.getPrice());
    }
}
