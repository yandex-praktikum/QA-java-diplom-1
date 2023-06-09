import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.NullSource;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.Random;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.params.provider.Arguments.of;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

public class IngredientTest {
    private static Random random = new Random();
    private static Stream <Arguments> getDataForIngredients() {
        return Stream.of(
                of(SAUCE, RandomStringUtils.randomAlphabetic(3), random.nextFloat()),
                of(SAUCE, RandomStringUtils.randomAlphabetic(4), random.nextFloat()),
                of(FILLING, RandomStringUtils.randomAlphabetic(999), random.nextFloat()),
                of(SAUCE, RandomStringUtils.randomAlphabetic(1000), random.nextFloat()),
                of(FILLING, "Морковь немытая Россия", random.nextFloat()),
                of(SAUCE, RandomStringUtils.randomAlphabetic(100), 0.01F),
                of(FILLING, RandomStringUtils.randomAlphabetic(20), 999_999.99F)
        );
    }
    @ParameterizedTest(name = "Проверка получения типа ингредиента: тип {0}, название {1}, цена {2}")
    @MethodSource("getDataForIngredients")
    public void ingredientTypeTest(IngredientType type, String name, float price) {
        Ingredient ingredient = new Ingredient(type, name, price);
        assertEquals(type, ingredient.getType());
    }

    @ParameterizedTest(name = "Проверка получения названия ингредиента: тип {0}, название {1}, цена {2}")
    @MethodSource("getDataForIngredients")
    public void ingredientNameTest(IngredientType type, String name, float price) {
        Ingredient ingredient = new Ingredient(type, name, price);
        assertEquals(name, ingredient.getName());
    }

    @ParameterizedTest(name = "Проверка получения цены ингредиента: тип {0}, название {1}, цена {2}")
    @MethodSource("getDataForIngredients")
    public void ingredientPriceTest(IngredientType type, String name, float price) {
        Ingredient ingredient = new Ingredient(type, name, price);
        assertEquals(price, ingredient.getPrice());
    }

    private static Stream<Arguments> provideInvalidDataForIngredients(){
        String validName = RandomStringUtils.randomAlphabetic(10);
        float validPrice = random.nextFloat();
        return Stream.of(
                of(RandomStringUtils.randomAlphabetic(2), validPrice),
                of(RandomStringUtils.randomAlphabetic(1001), validPrice),
                of("SELECT*", validPrice),
                of("<script>alert('XSS')</script>", validPrice),
                of(RandomStringUtils.randomAlphanumeric(3), validPrice),
                of(validName, -0.01F),
                of(validName, 0),
                of(validName, 1_000_000),
                of(validName, 1_000_000.01F)
        );
    }

    @ParameterizedTest(name = "Проверка выброса исключений на невалидные данные")
    @MethodSource("provideInvalidDataForIngredients")
    public void checkThrowsExceptionsOnInvalidParameters(String name, float price){
        assertThrows(IllegalArgumentException.class, ()-> new Ingredient (FILLING, name, price));
    }

    @ParameterizedTest(name = "Проверка выброса исключений на невалидные данные")
    @NullAndEmptySource
    public void checkThrowsExceptionsOnNullName(String name){
        float validPrice = random.nextFloat();
        assertThrows(IllegalArgumentException.class, ()-> new Ingredient(SAUCE, name, validPrice));
    }

    @ParameterizedTest(name = "Проверка выброса исключений на невалидные данные")
    @NullSource
    public void checkThrowsExceptionsOnNullType(IngredientType type){
        String validName = RandomStringUtils.randomAlphabetic(10);
        float validPrice = random.nextFloat();
        assertThrows(IllegalArgumentException.class, ()-> new Ingredient(type, validName, validPrice));
    }
}
