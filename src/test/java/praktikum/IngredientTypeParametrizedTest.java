package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class IngredientTypeParametrizedTest {

    private IngredientType ingredientType;
    private int expectedIngredientIndex;

    public IngredientTypeParametrizedTest(IngredientType ingredientType,
                                          int expectedIngredientIndex) {
        this.ingredientType = ingredientType;
        this.expectedIngredientIndex = expectedIngredientIndex;
    }

    @Parameterized.Parameters(name = "Index of ")
    public static Object[][] ingredientTypeIndexData() {
        return new Object[][]{
                {SAUCE, 0},
                {FILLING, 1}
        };
    }

    @Test
    public void checkIndexOfIngredientTypeInt() {
        int actualIngredientIndex = ingredientType.ordinal();
        System.out.println(ingredientType.ordinal());
        assertEquals("Неправильный индекс типа ингредиента", expectedIngredientIndex, actualIngredientIndex);
    }

}
