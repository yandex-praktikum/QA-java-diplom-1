import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.IngredientType;

@RunWith(Parameterized.class)
public class TestIngredientType {

    private final String type;
    private final int expected;

    public TestIngredientType(String type, int expected) {
        this.type = type;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Object[][] getType() {
        return new Object[][]{
                {"SAUCE", 0},
                {"FILLING", 1}
        };
    }

    @Test
    public void ingredientTypeTest(){
        int actual = IngredientType.valueOf(IngredientType.class, type).ordinal();
        Assert.assertEquals(expected, actual);
    }
}
