package praktikum;

import org.junit.Assert;
import org.junit.Test;

public class IngredientTypeTest {

    @Test
    public void quantityIngredientType() {
        int expected = 2;
        int actual = IngredientType.values().length;

        Assert.assertEquals("Фактическое количество типов ингредиентов отличается от ожидаемого", expected, actual);
    }

    @Test
    public void checkIngredientTypeSauce() {
        String expected = "SAUCE";

        String actual = IngredientType.valueOf("SAUCE").toString();
        Assert.assertEquals("Фактическое название типа ингредиента отличается от ожидаемого", expected, actual);
    }

    @Test
    public void checkIngredientTypeFilling() {
        String expected = "FILLING";

        String actual = IngredientType.valueOf("FILLING").toString();
        Assert.assertEquals("Фактическое название типа ингредиента отличается от ожидаемого", expected, actual);
    }
}
