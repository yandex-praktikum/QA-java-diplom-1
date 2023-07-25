package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class IngredientTest {
    public Ingredient ingredient;
    @Before
    public void setUp(){
        ingredient = new Ingredient(IngredientType.FILLING, "spicy-x", 90);
    }
    @Test
    public void getName(){
        String expected = "spicy-x";
        String actual = ingredient.getName();
        Assert.assertEquals("Неверное наименование",expected,actual);
    }
    @Test
    public void getPrice(){
        double ex = 90;
        double act = ingredient.getPrice();
        Assert.assertEquals("Неверный прайс", ex, act, 0);
    }
}