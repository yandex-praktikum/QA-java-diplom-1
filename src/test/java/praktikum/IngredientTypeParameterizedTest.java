package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class IngredientTypeParameterizedTest {

    private final IngredientType ingredientType;

    public IngredientTypeParameterizedTest(IngredientType ingredientType) {
        this.ingredientType = ingredientType;
    }

    @Parameterized.Parameters(name = "Тип ингредиента: {0}")
    public static Object[] dataIngredientType() {
        return new Object[]
            {
                    IngredientType.SAUCE,
                    IngredientType.FILLING,
            };
    }

    @Test
    public void checkValuesEnumIngredientType() {
        IngredientType expected = ingredientType;
        IngredientType actual = IngredientType.valueOf(String.valueOf(ingredientType));
        assertThat(expected, is(actual));
    }
}