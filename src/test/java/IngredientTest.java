import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)


public class IngredientTest {

    public IngredientTest(IngredientType ingredientIype) {
        this.ingredientIype = ingredientIype;
    }

    private final IngredientType ingredientIype;

    @Parameterized.Parameters
    public static Object[][] getPriceData() {
        return new Object[][]{
                {SAUCE},
                {FILLING},
        };
    }

    @Test
    public void getPriceTest() {
        Ingredient ingredient = new Ingredient(ingredientIype, "testName", 10F);
        float expected = 10F;
        float actual = ingredient.getPrice();
        assertEquals("Цены не совпадают", expected, actual, 0);
    }

    @Test
    public void getNameTest() {
        Ingredient ingredient = new Ingredient(ingredientIype, "testName", 10F);
        String expected = "testName";
        String actual = ingredient.getName();
        assertEquals("Имена не совпадают", expected, actual);

    }
    @Test
    public void getTypeTest() {
        Ingredient ingredient = new Ingredient(ingredientIype, "testName", 10F);
        IngredientType expected = ingredientIype;
        IngredientType actual = ingredient.getType();
        assertEquals("Типы не совпадают", expected, actual);

    }


}
