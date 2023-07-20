import org.junit.Test;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;
public class IngredientTypeTest {

    @Test
    public void ingredientTypeSauceTest(){
        assertEquals(IngredientType.valueOf("SAUCE"), IngredientType.SAUCE);
    }

    @Test
    public void ingredientTypeFillingTest(){
        assertEquals(IngredientType.valueOf("FILLING"), IngredientType.FILLING);
    }
}
