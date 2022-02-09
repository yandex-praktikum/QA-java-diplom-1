import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@RunWith(Parameterized.class)
public class IngredientTypeTests {

    private final IngredientType ingredientType;

    public IngredientTypeTests(IngredientType ingredientType) {
        this.ingredientType = ingredientType;
    }

    @Parameterized.Parameters
    public static Object[][] getIngredientTypes() {
        return new Object[][]{
                {IngredientType.FILLING},
                {IngredientType.SAUCE},
        };
    }

    @Test
    public void getIngredientType() {
        Ingredient ingredient = new Ingredient(ingredientType, "Test", 25.5f);
        IngredientType actual = ingredient.getType();
        assertThat("Метод getIngredientType возвращает неверное значение поля type", actual, equalTo(ingredientType));
    }
}
