import org.junit.Test;
import praktikum.Ingredient;
import java.util.Random;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.SAUCE;

public class GetIngredientsPriceTest {
    @Test
    public void canGetIngredientPrice(){
        float price = new Random().nextFloat();
        Ingredient ingredient = new Ingredient(SAUCE, "name", price);
        assertEquals(price, ingredient.getPrice(),price-ingredient.getPrice());
    }
}