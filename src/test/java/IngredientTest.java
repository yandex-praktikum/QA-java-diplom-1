
import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;
import static org.junit.Assert.*;

public class IngredientTest {
   @Test
    public void getPriceValue(){
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, "cutlet", 5.99f);
        float expected = 5.99f;
        float actual = ingredient.getPrice();
       assertEquals(expected, actual, 0.01f);
    }
    @Test
    public void getNameValue(){
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "chili sauce", 1.50f);
        String expected = "chili sauce";
        String actual = ingredient.getName();
        assertEquals(expected, actual);
    }
    @Test
    public void getTypeIngredientValue(){
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, "dinosaur", 3.25f);
        IngredientType expected = IngredientType.FILLING;
        IngredientType actual = ingredient.getType();
        assertEquals(expected, actual);
    }

}
