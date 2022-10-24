import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

public class IngredientTest {

    private final IngredientType sauceType = IngredientType.SAUCE;
    private final String name = "hot sauce";
    private final float price = 100;

    Ingredient ingredient = new Ingredient(sauceType, name, price);

    @Test
    public void getSauceType(){
        assertEquals(sauceType, ingredient.getType());
    }

    @Test
    public void getRightName(){
        assertEquals(name, ingredient.getName());
    }

    @Test
    public void getRightPrice(){
        float delta = 0;
        assertEquals(price, ingredient.getPrice(), delta);
    }
}