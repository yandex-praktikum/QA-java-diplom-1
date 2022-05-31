package praktikum;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class ParametrizedBurgerTest {

    // создаем ингредиенты для дальнейшего использования в тестах
    static Ingredient ingredient1 = new Ingredient(IngredientType.FILLING, "Жареный лук", 155);
    static Ingredient ingredient2 = new Ingredient(IngredientType.SAUCE, "Томатный соус", 30);
    static Ingredient ingredient3 = new Ingredient(IngredientType.SAUCE, "Сливочный соус", 40);

    Burger burger;

    @Before // создаем объект бургер перед каждым тестом
    public void setup() {
        burger = new Burger();
    }

    @Parameters
    @Test // параметризованный тест перемещения ингредиентов
    public void shouldMoveIngredients(int index, int newIndex, List<Ingredient> ingredients) {
        burger.ingredients.addAll(Arrays.asList(ingredient1, ingredient2, ingredient3));
        burger.moveIngredient(index, newIndex);
        assertEquals(burger.ingredients, ingredients);
    }
    private Object[][] parametersForShouldMoveIngredients() {
        return new Object[][]{
                {0, 1, List.of(ingredient2, ingredient1, ingredient3)},
                {0, 2, List.of(ingredient2, ingredient3, ingredient1)},
                {1, 2, List.of(ingredient1, ingredient3, ingredient2)},
                {2, 0, List.of(ingredient3, ingredient1, ingredient2)},
                {2, 1, List.of(ingredient1, ingredient3, ingredient2)}
        };
    }

    @Parameters
    @Test // параметризованный тест удаления ингредиентов
    public void shouldRemoveIngredient(int index, List<Ingredient> ingredients) throws Exception {
        burger.ingredients.addAll(Arrays.asList(ingredient1, ingredient2, ingredient3));
        burger.removeIngredient(index);
        assertEquals(burger.ingredients, ingredients);
    }
    private Object[][] parametersForShouldRemoveIngredient() {
        return new Object[][]{
                {0, List.of(ingredient2, ingredient3)},
                {1, List.of(ingredient1, ingredient3)},
                {2, List.of(ingredient1, ingredient2)}
        };
    }
}
