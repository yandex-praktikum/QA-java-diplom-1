import org.junit.Test;
import praktikum.Ingredient;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;

public class IngredientTest {


    Ingredient ingredient = new Ingredient(FILLING, "котлета", 5.2f);

    @Test
    public void getPriceTest(){
        assertEquals(5.2f, ingredient.getPrice(), 0.0f);
    }

    @Test
    public void getNameTest(){
        assertEquals("котлета", ingredient.getName());
    }

    @Test
    public void getTypeTest(){
        assertEquals(FILLING, ingredient.getType());
    }
}
