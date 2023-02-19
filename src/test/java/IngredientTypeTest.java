import org.junit.Test;
import praktikum.IngredientType;
import static org.junit.Assert.assertEquals;

public class IngredientTypeTest {

    private IngredientType ingredientType;

    @Test
    public void checkingValueSauceTest(){
        IngredientType actualResult = ingredientType.valueOf("SAUCE");
        IngredientType expectedResult = ingredientType.SAUCE;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void checkingValueFillingTest(){
        IngredientType actualResult = ingredientType.valueOf("FILLING");
        IngredientType expectedResult = ingredientType.FILLING;
        assertEquals(expectedResult, actualResult);
    }
}
