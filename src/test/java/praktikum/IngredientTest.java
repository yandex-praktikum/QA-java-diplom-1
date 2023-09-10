package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static praktikum.IngredientType.SAUCE;

public class IngredientTest {
    private Ingredient ingredient;

    @Before
    public void setUp() {
        ingredient = new Ingredient(SAUCE,"Кетчуп", 5.0F);
    }

    @Test
    public void getNameTest(){
        String name = ingredient.getName();
        Assert.assertEquals("Кетчуп", name);
    }

    @Test
    public void getPriceTest(){
        float price = ingredient.getPrice();
        Assert.assertEquals(5.0F, price, 0.001);
    }
}