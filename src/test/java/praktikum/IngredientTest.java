package praktikum;

import org.junit.Assert;
import org.junit.Test;

public class IngredientTest {

    @Test
    public void getPrice() {
        Ingredient ingredient = new Ingredient(null,null,15.2f);
        float actual = ingredient.getPrice();
        float expected = 15.2f;
        Assert.assertEquals("Error getPrice",expected,actual,0);
    }

    @Test
    public void getName() {
        Ingredient ingredient = new Ingredient(null,"Космо-повидло",0);
        String actual = ingredient.getName();
        String expected = "Космо-повидло";
        Assert.assertEquals("Error getName",expected,actual);
    }

    @Test
    public void getType() {

        Ingredient ingredient = new Ingredient(IngredientType.valueOf("SAUCE"),null,0);
        IngredientType actual = ingredient.getType();
        IngredientType excepted = IngredientType.valueOf("SAUCE");
        Assert.assertEquals("Error getType",excepted,actual);
    }
}