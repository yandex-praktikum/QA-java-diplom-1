import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

public class IngredientTest {

    Ingredient ingredient = new Ingredient(IngredientType.FILLING, "Mini salad Exo-Plantago",4400);

    @Test
    public void getIngredientPrice(){
        float actual = ingredient.getPrice();
        float expected = 4400;
        assertEquals(0, expected, actual);
    }

    @Test
    public void getIngredientNameTest(){
        String actual = ingredient.getName();
        String expected = "Mini salad Exo-Plantago";
        assertEquals("we don't have this topping name", expected, actual);
    }

    @Test
    public void getIngredientTypeTest(){
        IngredientType actual = ingredient.getType();
        IngredientType expected = IngredientType.FILLING;
        assertEquals("we don't have this topping", expected, actual);
    }

}
