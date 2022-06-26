package praktikum;

import org.junit.Assert;
import org.junit.Test;

public class IngredientTypeTest {

IngredientType ingredientType;

    @Test
    public void values() {
        for (IngredientType actual : IngredientType.values()) {
            System.out.println(actual);
            Assert.assertEquals(actual.SAUCE, ingredientType.SAUCE);
            Assert.assertEquals(actual.FILLING, ingredientType.FILLING);
        }
    }

    @Test
    public void valueOfSauce() {
        String actual = String.valueOf(IngredientType.valueOf("SAUCE"));
        String expected = "SAUCE";
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void valueOfFilling() {
        String actual = String.valueOf(IngredientType.valueOf("FILLING"));
        String expected = "FILLING";
        Assert.assertEquals(actual, expected);
    }
}

//Не знаю как протестить перечисление. Вот такие тесты придумал.