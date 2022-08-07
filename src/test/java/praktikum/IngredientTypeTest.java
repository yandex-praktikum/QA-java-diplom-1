package praktikum;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.List;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class IngredientTypeTest {
    private final IngredientType expected;
    private final IngredientType actual;

    public IngredientTypeTest(IngredientType expected, IngredientType actual) {
        this.expected = expected;
        this.actual = actual;
    }

    @Parameterized.Parameters (name = "index: {0}")
    public static Object[][] ingredientType() {
        List<Ingredient> ingredientList = List.of(new Ingredient(SAUCE, "hot sauce", 100f), new Ingredient(FILLING, "cutlet", 100f));
        return new Object[][]{
                {ingredientList.get(0).getType(), SAUCE},
                {ingredientList.get(1).getType(), FILLING}
        };
    }
    @Test
    public void checkIngredientType(){
        Assert.assertEquals(expected, actual);
    }
}
