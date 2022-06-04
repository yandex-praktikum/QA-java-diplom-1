package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.SAUCE;

/**
 * Author: Alexey Bondarenko
 * Date: 03.06.2022
 */
@RunWith(Parameterized.class)
public class BurgerMoveIngredientParameterizedTest {

    private final static String INGREDIENT_NAME = "Space Workflow";
    private final static float PRICE = 2.0F;

    private final List<Integer> checkedData;
    private final String expected;
    private Burger burger;

    public BurgerMoveIngredientParameterizedTest(List<Integer> checkedData, String expected) {
        this.checkedData = checkedData;
        this.expected = expected;
    }

    @Parameterized.Parameters(name = "Test data: {0}")
    public static Object[][] getData() {
        return new Object[][]{
                {List.of(0, 0), "Test should pass"},
                {List.of(0, 1), "Test should pass"},
                {List.of(0, 2), "Index: 2, Size: 1"},
                {List.of(0, -1), "Index: -1, Size: 1"},
                {List.of(2, 0), "Index 2 out of bounds for length 2"},
                {List.of(-1, 0), "Index -1 out of bounds for length 2"}
        };
    }

    @Before
    public void init() {
        burger = new Burger();
        burger.addIngredient(new Ingredient(SAUCE, INGREDIENT_NAME, PRICE));
        burger.addIngredient(new Ingredient(SAUCE, INGREDIENT_NAME, PRICE));
    }

    @Test
    public void checkMoveIngredientWithWrongIndex() {
        try {
            burger.moveIngredient(checkedData.get(0), checkedData.get(1));
        } catch (IndexOutOfBoundsException e) {
            assertEquals(expected, e.getMessage());
        }
    }
}
