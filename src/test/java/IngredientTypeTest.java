import org.hamcrest.MatcherAssert;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.IngredientType;
import static org.hamcrest.CoreMatchers.notNullValue;

@RunWith(Parameterized.class)
public class IngredientTypeTest {
    private final String enumValue;

    public IngredientTypeTest(String enumValue) {
        this.enumValue = enumValue;
    }

    @Parameterized.Parameters
    public static Object[][] getValue() {
        return new Object[][] {
                {"SAUCE"},
                {"FILLING"},
        };
    }

    @Test
    public void IngredientTypeExists() {
        IngredientType actual = IngredientType.valueOf(enumValue);
        Assert.assertEquals(enumValue, actual.toString());
    }

    @Test
    public void IngredientTypeNotNull(){
        IngredientType actual = IngredientType.valueOf(enumValue);
        MatcherAssert.assertThat(actual.name(), notNullValue());
    }
}