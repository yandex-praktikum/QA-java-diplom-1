import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

@RunWith(Parameterized.class)
public class IngredientParameterizedTest {

    String name;
    float price;

    private final IngredientType type;;
    private final IngredientType expected;

    public IngredientParameterizedTest(IngredientType type, IngredientType expected) {
        this.type = type;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Object[][] getTypeData() {
        return new Object[][] {
                {IngredientType.SAUCE, IngredientType.SAUCE},
                {IngredientType.FILLING, IngredientType.FILLING},
        };
    }

    @Test
    public void testGetTypeReturnsType() {
        Ingredient ingredient = new Ingredient(type, name, price);
        IngredientType actual = ingredient.getType();
        Assert.assertEquals(expected, actual);
    }
}