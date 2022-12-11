import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.SAUCE;

public class IngredientTest {

    private String name = "hot sauce";
    private float price = 100;

    @Test
    public void returnNameOfIngredient(){
        Ingredient ingredient = new Ingredient(SAUCE, name, price);
        String result = ingredient.getName();
        assertEquals(name, result);
    }

    @Test
    public void returnPriceOfIngredient(){
        Ingredient ingredient = new Ingredient(SAUCE, name, price);
        Float result1 = ingredient.getPrice();
        assertEquals(price, result1, 0);
    }

    @Test
    public void returnTypeOfIngredient(){
        Ingredient ingredient = new Ingredient(SAUCE, name, price);
        IngredientType type = ingredient.getType();
        assertEquals(type, SAUCE);
    }


}
