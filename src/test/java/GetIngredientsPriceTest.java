import org.junit.Assert;
import org.junit.Test;
import praktikum.Ingredient;
import java.util.Random;

import static praktikum.IngredientType.SAUCE;

public class GetIngredientsPriceTest {
    @Test
    public void canGetIngredientPrice(){
        float price = new Random().nextFloat();
        Ingredient ingredient = new Ingredient(SAUCE, "name", price);
        Assert.assertEquals(price, ingredient.getPrice(),price-ingredient.getPrice());
    }
}