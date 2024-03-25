import org.junit.Assert;
import org.junit.Test;
import praktikum.IngredientType;

public class IngredientTypeTest {

    @Test
    public void checkIngredientSauseTypeTest() {
        Assert.assertEquals("Expected result does not match the actual", IngredientType.valueOf("SAUCE"), IngredientType.SAUCE);
    }

    @Test
    public void checkIngredientFillingTypeTest() {
        Assert.assertEquals("Expected result does not match the actual", IngredientType.valueOf("FILLING"), IngredientType.FILLING);

    }

}
