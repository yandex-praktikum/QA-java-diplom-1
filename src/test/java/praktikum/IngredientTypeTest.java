package praktikum;

import org.junit.Assert;
import org.junit.Test;

public class IngredientTypeTest {

    @Test
    public void quantityIngredientType() {
        int expected = 2;
        int actual = IngredientType.values().length;

        Assert.assertEquals(expected,actual);
        }

    @Test
    public void getIngredientTypeSauce() {

        String expected = "SAUCE";

        String actual= IngredientType.valueOf("SAUCE").toString();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void getIngredientTypeFilling() {

        String expected = "FILLING";

        String actual= IngredientType.valueOf("FILLING").toString();
        Assert.assertEquals(expected,actual);
    }


}
