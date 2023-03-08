import org.junit.Assert;
import org.junit.Test;
import praktikum.Ingredient;

import static praktikum.IngredientType.SAUCE;

public class IngredientTest {

    private String expectedName = "Соус Spicy-X";

    private float expectedPrice = 120f;

    Ingredient ingredient = new Ingredient(SAUCE, expectedName, expectedPrice);


    @Test
    public void test1() {
        Assert.assertEquals(SAUCE, ingredient.getType());
    }

    @Test
    public void test2(){
        Assert.assertEquals(expectedName, ingredient.getName());
    }

    @Test
    public void test3(){
        Assert.assertEquals(expectedPrice, ingredient.getPrice(), 0);
    }


}
