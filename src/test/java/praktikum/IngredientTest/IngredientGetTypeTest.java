package praktikum.IngredientTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class IngredientGetTypeTest {
    private final IngredientType ingredientType;
    private final IngredientType expectedIngredientType;

    public IngredientGetTypeTest(IngredientType ingredientType, IngredientType expectedIngredientType) {
        this.ingredientType = ingredientType;
        this.expectedIngredientType = expectedIngredientType;
    }

    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][]{
                {IngredientType.FILLING, IngredientType.FILLING},
                {IngredientType.SAUCE, IngredientType.SAUCE}
        };
    }

    @Test
    public void shouldCheckGetIngredientTypeReturnExactIngredientType() {
        Ingredient ingredient = new Ingredient(ingredientType, "hot sauce", 100.f);
        IngredientType actualIngredientType = ingredient.getType();
        assertEquals("return invalid ingredientType", expectedIngredientType, actualIngredientType);
    }

}
