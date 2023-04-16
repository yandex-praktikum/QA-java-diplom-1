package praktikum;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.lenient;
import static praktikum.IngredientType.*;


@ExtendWith(MockitoExtension.class)
public class BurgerTest {

    private static Burger burger;

    @BeforeEach
    void setUp() {
        burger = new Burger();
    }

    @ParameterizedTest
    @MethodSource("provideIngredients")
    void shouldAddIngredient(IngredientType type, String name, float price, @Mock Ingredient ingredient) {
        lenient().when(ingredient.getType()).thenReturn(type);
        lenient().when(ingredient.getName()).thenReturn(name);
        lenient().when(ingredient.getPrice()).thenReturn(price);
        burger.addIngredient(ingredient);
        assertTrue(burger.ingredients.contains(ingredient));
    }

    @Test
    void shouldRemoveIngredient(@Mock Ingredient sauce, @Mock Ingredient filling) {
        // Arrange
        lenient().when(sauce.getType()).thenReturn(SAUCE);
        lenient().when(sauce.getName()).thenReturn("Соус с шипами Антарианского плоскоходца");
        lenient().when(sauce.getPrice()).thenReturn(88F);
        lenient().when(filling.getType()).thenReturn(FILLING);
        lenient().when(filling.getName()).thenReturn("Мини-салат Экзо-Плантаго");
        lenient().when(filling.getPrice()).thenReturn(4400F);
        burger.addIngredient(sauce);
        burger.addIngredient(filling);
        // Act
        burger.removeIngredient(0);
        // Assert
        assertAll("Only certain ingredient removed",
                () -> assertFalse(burger.ingredients.contains(sauce)),
                () -> assertTrue(burger.ingredients.contains(filling))
        );
    }

    @Test
    void shouldMoveIngredient(@Mock Ingredient sauce, @Mock Ingredient filling) {
        // Arrange
        lenient().when(sauce.getType()).thenReturn(SAUCE);
        lenient().when(sauce.getName()).thenReturn("Соус с шипами Антарианского плоскоходца");
        lenient().when(sauce.getPrice()).thenReturn(88F);
        lenient().when(filling.getType()).thenReturn(FILLING);
        lenient().when(filling.getName()).thenReturn("Мини-салат Экзо-Плантаго");
        lenient().when(filling.getPrice()).thenReturn(4400F);
        burger.addIngredient(sauce);
        burger.addIngredient(filling);
        // Act
        burger.moveIngredient(1, 0);
        // Assert
        assertAll("Ingredients are swapped",
                () -> assertEquals(0, burger.ingredients.indexOf(filling)),
                () -> assertEquals(1, burger.ingredients.indexOf(sauce))
        );
    }

    @Test
    void shouldReturnPrice(@Mock Bun bun, @Mock Ingredient sauce, @Mock Ingredient filling) {
        // Arrange
        lenient().when(bun.getPrice()).thenReturn(988F);
        lenient().when(sauce.getPrice()).thenReturn(90F);
        lenient().when(filling.getPrice()).thenReturn(4400F);
        burger.setBuns(bun);
        burger.addIngredient(sauce);
        burger.addIngredient(filling);
        // Assert
        assertEquals(988 * 2 + 90 + 4400, burger.getPrice());
    }

    @Test
    void shoutReturnReceipt(@Mock Bun bun, @Mock Ingredient sauce, @Mock Ingredient filling) {
        // Arrange
        lenient().when(bun.getPrice()).thenReturn(988F);
        lenient().when(bun.getName()).thenReturn("Флюоресцентная булка R2-D3");
        lenient().when(sauce.getPrice()).thenReturn(90F);
        lenient().when(sauce.getName()).thenReturn("Соус Spicy-X");
        lenient().when(sauce.getType()).thenReturn(SAUCE);
        lenient().when(filling.getPrice()).thenReturn(4400F);
        lenient().when(filling.getName()).thenReturn("Мини-салат Экзо-Плантаго");
        lenient().when(filling.getType()).thenReturn(FILLING);
        burger.setBuns(bun);
        burger.addIngredient(sauce);
        burger.addIngredient(filling);
        String receipt = burger.getReceipt();
        assertAll("Check receipt contents",
                () -> assertTrue(receipt.contains("Флюоресцентная булка R2-D3")),
                () -> assertTrue(receipt.contains("Соус Spicy-X")),
                () -> assertTrue(receipt.contains("Мини-салат Экзо-Плантаго")),
                () -> assertTrue(receipt.contains(String.valueOf(988F * 2 + 90F + 4400F)))
        );
    }

    private static Stream<Arguments> provideIngredients() {
        return Stream.of(
                Arguments.of(SAUCE, "Соус Spicy-X", 90F),
                Arguments.of(FILLING, "Биокотлета из марсианской Магнолии", 424F)
        );
    }
}
