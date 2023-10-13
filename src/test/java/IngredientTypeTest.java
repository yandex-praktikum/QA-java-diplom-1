import org.junit.Assert;
import org.junit.Test;
import praktikum.IngredientType;

public class IngredientTypeTest {

    private int EXPECTED_LENGTH = 2;

    @Test
    public void ingredientTypeCheck() {
        IngredientType[] ingredientTypes = IngredientType.values();
        Assert.assertEquals(EXPECTED_LENGTH, ingredientTypes.length);
    }
}