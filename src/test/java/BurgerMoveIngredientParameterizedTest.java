import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BurgerMoveIngredientParameterizedTest {

    static private final Ingredient INGREDIENT_FIRST = new Ingredient(IngredientType.FILLING, "Filling ingredient", 5);
    static private final Ingredient INGREDIENT_SECOND = new Ingredient(IngredientType.SAUCE, "Sauce ingredient", 4);
    static private final Ingredient INGREDIENT_THIRD = new Ingredient(IngredientType.SAUCE, "New sauce ingredient", 6);
    private final int index;
    private final int newIndex;
    private final List<Ingredient> expectedIngredientsList;
    private Burger burger;

    public BurgerMoveIngredientParameterizedTest(int index, int newIndex, List<Ingredient> expectedIngredientsList) {
        this.index = index;
        this.newIndex = newIndex;
        this.expectedIngredientsList = expectedIngredientsList;
    }

    @Parameterized.Parameters(name = "{index}: \"index\": {0}; \"newIndex\": {1};")
    public static Object[][] getIndexData() {
        return new Object[][]{
                {0, 2, Arrays.asList(INGREDIENT_SECOND, INGREDIENT_THIRD, INGREDIENT_FIRST)},
                {2, 0, Arrays.asList(INGREDIENT_THIRD, INGREDIENT_FIRST, INGREDIENT_SECOND)},
                {0, 0, Arrays.asList(INGREDIENT_FIRST, INGREDIENT_SECOND, INGREDIENT_THIRD)},
                {0, 4, Arrays.asList(INGREDIENT_FIRST, INGREDIENT_SECOND, INGREDIENT_THIRD)},
                {4, 0, Arrays.asList(INGREDIENT_FIRST, INGREDIENT_SECOND, INGREDIENT_THIRD)},
        };
    }

    @Before
    public void setUp() {
        burger = new Burger();
        burger.addIngredient(INGREDIENT_FIRST);
        burger.addIngredient(INGREDIENT_SECOND);
        burger.addIngredient(INGREDIENT_THIRD);
    }

    @Test
    public void checkMoveIngredient() {
        try {
            burger.moveIngredient(index, newIndex);
            assertEquals("Список ингредиентов не совпал с ожидаемым", expectedIngredientsList, burger.ingredients);
        } catch (IndexOutOfBoundsException thrown) {
            assertEquals("Произошло исключение IndexOutOfBoundsException", "", thrown.getMessage());
        }
    }

}