import org.junit.Assert;
import org.junit.Test;
import praktikum.IngredientType;

public class TestIngredientType {

    @Test
    public void testSauce() {
        Assert.assertEquals(IngredientType.valueOf("SAUCE"), IngredientType.SAUCE);
    }

    @Test
    public void testFilling() {
        Assert.assertEquals(IngredientType.valueOf("FILLING"), IngredientType.FILLING);
    }
}