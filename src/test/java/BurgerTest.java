import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Database;
import praktikum.Ingredient;

import java.util.Random;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.of;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

public class BurgerTest {
    private Burger burger = new Burger();
    private  static Database db = new Database();
    private  static Random random = new Random();

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
    public void removeIngredientTest() {
        Ingredient ingredient = db.availableIngredients().get(random.nextInt(db.availableIngredients().size()));
        burger.addIngredient(ingredient);
        Integer ingredientsAmountBefore = burger.ingredients.size();
        burger.removeIngredient(random.nextInt(ingredientsAmountBefore));
        Integer ingredientsAmountAfter = burger.ingredients.size();
        assertEquals(-1, ingredientsAmountAfter - ingredientsAmountBefore);
    }

    @Test
    public void moveIngredientTest() {
        Ingredient ingredient1 = db.availableIngredients().get(random.nextInt(db.availableIngredients().size()));
        Ingredient ingredient2 = db.availableIngredients().get(random.nextInt(db.availableIngredients().size()));
        burger.addIngredient(ingredient1);
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
    public void burgerPriceTest() {
        Bun bun = db.availableBuns().get(random.nextInt(db.availableBuns().size()));
        Ingredient ingredient = db.availableIngredients().get(random.nextInt(db.availableIngredients().size()));
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        float expectedPrice = (bun.getPrice() * 2) + ingredient.getPrice();
        assertEquals(expectedPrice, burger.getPrice());
    }


}
