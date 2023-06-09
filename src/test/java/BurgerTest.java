import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import praktikum.*;

import java.util.Random;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.of;
import static praktikum.IngredientType.*;

public class BurgerTest {
    private Burger burger;
    private  static Database db = new Database();
    private  static Random random = new Random();

    @BeforeEach
    public void setUpBurger() {
        burger = new Burger();
        Bun bun = db.availableBuns().get(random.nextInt(db.availableBuns().size()));
        Ingredient ingredient = db.availableIngredients().get(random.nextInt(db.availableIngredients().size()));
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
    }

    private static Stream<Arguments> getDataForIngredients() {
        return Stream.of(
                of(new Ingredient(SAUCE, "hot sauce", 100)),
                of(new Ingredient(SAUCE, "sour cream", 200)),
                of(new Ingredient(FILLING, "cutlet", 100)),
                of(new Ingredient(FILLING, "sausage", 300))
        );
    }
    @ParameterizedTest(name = "Проверка добавления ингридиентов")
    @MethodSource("getDataForIngredients")
    public void addIngredientTest(Ingredient ingredient) {
        Integer ingredientsAmountBefore = burger.ingredients.size();
        burger.addIngredient(ingredient);
        Integer ingredientsAmountAfter = burger.ingredients.size();
        assertEquals(1, ingredientsAmountAfter - ingredientsAmountBefore);
    }

    @Test
    @DisplayName("Проверка удаления ингридиентов")
    public void removeIngredientTest() {
        Integer ingredientsAmountBefore = burger.ingredients.size();
        burger.removeIngredient(random.nextInt(ingredientsAmountBefore));
        Integer ingredientsAmountAfter = burger.ingredients.size();
        assertEquals(-1, ingredientsAmountAfter - ingredientsAmountBefore);
    }

    @ParameterizedTest(name = "Проверка перемещения ингридиентов")
    @MethodSource("getDataForIngredients")
    public void moveIngredientTest(Ingredient ingredient2) {
        burger.addIngredient(ingredient2);
        String firstIngrName = burger.ingredients.get(0).getName();
        String secondIngrName = burger.ingredients.get(1).getName();
        burger.moveIngredient(1, 0);
        assertAll(
                ()-> assertEquals(secondIngrName, burger.ingredients.get(0).getName()),
                ()-> assertEquals(firstIngrName, burger.ingredients.get(1).getName())
        );
    }

    @Test
    public void receiptTest() {
        Bun bun = new Bun("red bun", 300);
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, "cutlet", 100);
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        String actualReceipt = burger.getReceipt();
        assertAll(
                ()-> assertTrue(actualReceipt.contains("red bun")),
                ()-> assertTrue(actualReceipt.contains("cutlet")),
                ()-> assertTrue(actualReceipt.contains("Price"))
        );
    }
}
