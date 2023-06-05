import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import praktikum.*;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.of;
import static praktikum.IngredientType.*;

@ExtendWith(MockitoExtension.class)
public class BurgerPriceTest {
    private Burger burger;
    @Mock
    Ingredient ingredient1;
    @Mock
    Bun bun;

    @BeforeEach
    public void initBurger() {
        burger = new Burger();
    }

    private static Stream<Arguments> getDataForBuns() {
        return Stream.of(
                of(new Bun("black bun", 100), 200),
                of(new Bun("white bun", 200), 400),
                of(new Bun("red bun", 300), 600)
        );
    }

    @ParameterizedTest(name = "Проверка стоимости булочек в бургере")
    @MethodSource("getDataForBuns")
    public void burgerPriceTestBuns(Bun bun, float bunsPrice) {
        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        assertEquals(bunsPrice, burger.getPrice() - ingredient1.getPrice());
    }

    private static Stream<Arguments> getDataForIngredients() {
        return Stream.of(
                of(List.of (new Ingredient(SAUCE, "hot sauce", 100)), 100),
                of(List.of (new Ingredient(SAUCE, "sour cream", 200), new Ingredient(FILLING, "cutlet", 100)), 300),
                of(List.of(), 0)
        );
    }

    @ParameterizedTest(name = "Проверка стоимости ингридиентов")
    @MethodSource("getDataForIngredients")
    public void burgerPriceTestIngredients(List<Ingredient> ingredients, float ingredientsCost) {
        burger.setBuns(bun);
        for(Ingredient ingredient : ingredients) {
            burger.addIngredient(ingredient);
        } assertEquals(ingredientsCost, burger.getPrice() - bun.getPrice()*2);
    }

    @Test
    @DisplayName("Проверка финальной стоимости")
    public void finalPriceTest() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        Mockito.when(bun.getPrice()).thenReturn(200F);
        Mockito.when(ingredient1.getPrice()).thenReturn(300F);
        assertEquals(700, burger.getPrice());
    }
}
