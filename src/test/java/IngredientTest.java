import org.junit.Test;
import praktikum.*;
import static org.junit.Assert.assertEquals;
public class IngredientTest {

    @Test
    public void checkCorrectIngredientNameIsReturned(){
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "SauceName", 3.3f);
        String result = ingredient.getName();
        assertEquals("SauceName", result);
    }

    @Test
    public void checkCorrectIngredientPriceIsReturned(){
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, "FillingName", 1.1f);
        float result = ingredient.getPrice();
        assertEquals(1.1f, result, 0);
    }
}