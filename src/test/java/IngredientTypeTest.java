import org.junit.Test;
import praktikum.IngredientType;
import static org.junit.Assert.assertEquals;

public class IngredientTypeTest {
    @Test
    public void thereAreOnlyTwoTypesOfIngredients(){
        int expectedResult = 2;
        IngredientType[] ingredientTypes = IngredientType.values();
        int actualResult = ingredientTypes.length;
        assertEquals(expectedResult, actualResult);
    }
}