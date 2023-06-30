import org.junit.Assert;
import org.junit.Test;
import praktikum.IngredientType;

public class IngredientTypeTest {
    @Test
    public void testSauceAvailable(){
        Assert.assertNotNull("Такого соуса не существует", IngredientType.valueOf("SAUCE"));
    }
    @Test
    public void testFillingAvailable(){
        Assert.assertNotNull("Такой начинки нет", IngredientType.valueOf("FILLING"));
    }

}
