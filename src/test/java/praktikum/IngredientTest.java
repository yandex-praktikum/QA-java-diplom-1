package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;

public class IngredientTest {

    @Mock
    private IngredientType type;


    @Test
    public void checkGetPriceForIngredient(){

        Ingredient ingredient = new Ingredient(type,"Onion", 33.0f);
        float actualPrice = ingredient.getPrice();
        float expectedPrice = 33.0f;

        Assert.assertEquals("Ingredient price is incorrect", expectedPrice, actualPrice, 0);
    }

}
