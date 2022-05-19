import org.junit.Test;
import praktikum.Ingredient;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;

public class IngredientTest {


    Ingredient ingredient = new Ingredient(FILLING, "cutlet", 100);

    @Test
    public void getPriceTest(){
        assertEquals(100, ingredient.getPrice(), 0.0f);
    }

    @Test
    public void getNameTest(){
        assertEquals("cutlet", ingredient.getName());
    }

    @Test
    public void getTypeTest(){
        assertEquals(FILLING, ingredient.getType());
    }
}
