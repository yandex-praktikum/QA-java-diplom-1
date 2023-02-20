import org.junit.Assert;
import org.junit.Test;
import praktikum.IngredientType;
import static praktikum.IngredientType.SAUCE;

public class TestIngredientType {

    private final IngredientType ingredientType = SAUCE;
    private final String stringIngredientType = "SAUCE";


    @Test
    public void testReturnCorrectIngredientTypeWithValueOf() {

        IngredientType expectedIngredientType = ingredientType;
        IngredientType actualIngredientTypeAsString =  IngredientType.valueOf(stringIngredientType);
        Assert.assertEquals(expectedIngredientType, actualIngredientTypeAsString);
    }
}
