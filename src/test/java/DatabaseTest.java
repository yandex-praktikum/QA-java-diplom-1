import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import praktikum.*;

import java.util.Random;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.of;
import static praktikum.IngredientType.*;

public class DatabaseTest {

    Database db = new Database();
    private static Random random = new Random();
    private static Stream<Arguments> getDataForBuns() {
        return Stream.of(
                of(new Bun("black bun", 100), "black bun", 100),
                of(new Bun("white bun", 200), "white bun", 200),
                of(new Bun("red bun", 300), "red bun", 300)
        );
    }

    @ParameterizedTest(name = "Проверка списка булок")
    @MethodSource("getDataForBuns")
    public void availableBunsTest(Bun bun, String expectedName, float expectedPrice) {
        Integer actualAmount = db.availableBuns().size();
        String actualName = bun.getName();
        float actualPrice = bun.getPrice();
        assertAll(
                ()-> assertEquals(3, actualAmount),
                ()-> assertEquals(expectedName, actualName),
                ()-> assertEquals(expectedPrice, actualPrice)
        );
    }
    private static Stream<Arguments> getDataForIngredients() {
        return Stream.of(
                of(new Ingredient(SAUCE, "hot sauce", 100), SAUCE, "hot sauce", 100),
                of(new Ingredient(SAUCE, "sour cream", 200), SAUCE, "sour cream", 200),
                of(new Ingredient(FILLING, "cutlet", 100), FILLING, "cutlet", 100),
                of(new Ingredient(FILLING, "sausage", 300), FILLING, "sausage", 300)
        );
    }

    @ParameterizedTest(name = "Проверка списка ингридиентов")
    @MethodSource("getDataForIngredients")
    public void availableIngredientsTest(Ingredient ingredient, IngredientType type, String expectedName, float expectedPrice) {
        Integer actualAmount = db.availableIngredients().size();
        IngredientType actualType = ingredient.getType();
        String actualName = ingredient.getName();
        float actualPrice = ingredient.getPrice();
        assertAll(
                ()-> assertEquals(6, actualAmount),
                ()-> assertEquals(type, actualType),
                ()-> assertEquals(expectedName, actualName),
                ()-> assertEquals(expectedPrice, actualPrice)
        );
    }
}
