import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.IngredientType;

@RunWith(Parameterized.class)
public class IngredientTypeTest {
    IngredientType type;
    String expected;

    public IngredientTypeTest(IngredientType type, String expected) {
        this.type = type;
        this.expected = expected;
    }

    @Parameterized.Parameters(name = "Тестовые данные: IndegrientType = {0} expected = {1}")
    public static Object[][] getData() {
        return new Object[][]{
                {IngredientType.SAUCE, "SAUCE"},
                {IngredientType.FILLING, "FILLING"}
        };
    }

    @Test
    public void checkIngredientTypeFilling() {
        Assert.assertEquals(expected, type.name());
    }
}
