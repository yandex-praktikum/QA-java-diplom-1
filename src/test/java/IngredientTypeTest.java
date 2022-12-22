import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.IngredientType;

@RunWith(Parameterized.class)
public class IngredientTypeTest {
    public String ingredientType;

    public IngredientTypeTest(String ingredientType) {
        this.ingredientType = ingredientType;
    }

    @Parameterized.Parameters
    public static Object[] getData() {
        return new Object[][]
                {
                        {"FILLING"},
                        {"SAUCE"},
                };
    }
    // Проверка FILLING и SAUCE в enum
    @Test
    public void ingredientTypeTest() {
        String expected = ingredientType;
        Assert.assertEquals(expected, IngredientType.valueOf(ingredientType).toString());
    }

}
