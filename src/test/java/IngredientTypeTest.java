import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.IngredientType;

@RunWith(Parameterized.class)
public class IngredientTypeTest {

    private final String expected;
    private final int number;

    public IngredientTypeTest(String expected, int number) {
        this.expected = expected;
        this.number = number;
    }

    @Parameterized.Parameters
    public static Object[][] getTextData() {
        return new Object[][] {
                {"SAUCE", 0},
                {"FILLING", 1},
        };
    }

    @Test
    public void ingredientSauceTypeTest() {
        IngredientType[] types = IngredientType.values();
        Assert.assertEquals(expected, types[number].toString());
    }

}
