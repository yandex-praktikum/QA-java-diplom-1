import org.junit.Assert;
import org.junit.Test;
import praktikum.IngredientType;

public class IngredientTypeTests {

    @Test
    public void ingredientSauceTypeTest(){
        Assert.assertEquals(IngredientType.SAUCE, IngredientType.valueOf("SAUCE"));
    }

    @Test
    public void ingredientFillingTypeTest(){
        Assert.assertEquals(IngredientType.FILLING, IngredientType.valueOf("FILLING"));
    }

}