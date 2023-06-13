import org.junit.Test;
import praktikum.Ingredient;
import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.SAUCE;

public class IngredientTest {


    @Test
    public void getPrice() {
        Ingredient ingredient = new Ingredient(SAUCE, "Spicy", 60);
        assertEquals("Get ingredient price error",60, ingredient.getPrice(),0.0);
    }
    @Test
    public void getName() {
        Ingredient ingredient = new Ingredient(SAUCE, "Spicy", 60);
        assertEquals("Get ingredient name error","Spicy", ingredient.getName());
    }
    @Test
    public void getType() {
        Ingredient ingredient = new Ingredient(SAUCE, "Spicy", 60);
        assertEquals("Get ingredient type error",SAUCE, ingredient.getType());
    }
}