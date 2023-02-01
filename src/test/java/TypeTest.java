import org.junit.Assert;
import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static java.lang.String.valueOf;

public class TypeTest {

    @Test
    public void fillingTypeTest(){
        Assert.assertEquals("FILLING", valueOf(IngredientType.FILLING));
    }

    @Test
    public void sauceTypeTest(){
        Assert.assertEquals("SAUCE", valueOf(IngredientType.SAUCE));
    }
}
