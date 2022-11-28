import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.IngredientType;

@RunWith(Parameterized.class)
public class IngredientTypeTest {
    private final IngredientType ingredientType;
    private final String nameIngredientType;

    public IngredientTypeTest(IngredientType ingredientType, String stringIngredientType) {
        this.ingredientType = ingredientType;
        this.nameIngredientType = stringIngredientType;
    }

    @Parameterized.Parameters
    public static Object[][] getParameters() {
        return new Object[][]{
                {IngredientType.SAUCE, "SAUCE"},
                {IngredientType.FILLING, "FILLING"}
        };
    }

    @Test
    public void shouldReturnsCorrectEnumType(){
        Assert.assertEquals("Ошибка! Ожидается - " + ingredientType ,ingredientType, IngredientType.valueOf(nameIngredientType));
    }
}
