package praktikum;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.*;
import static praktikum.IngredientType.*;


public class BurgerIngredientsTest {

    @Test
    void bunTest() {
        String name = "TestBun";
        float price = 10.5F;
        Bun bun = new Bun(name, price);
        assertAll("Bun fields",
                () -> assertEquals(name, bun.getName()),
                () -> assertEquals(price, bun.getPrice())
        );
    }

    @ParameterizedTest
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
                Arguments.of(SAUCE, "Соус Spicy-X", 5),
                Arguments.of(SAUCE, "Соус традиционный галактический", 9.6F),
                Arguments.of(FILLING, "Биокотлета из марсианской Магнолии", 11)
        );
    }
}
