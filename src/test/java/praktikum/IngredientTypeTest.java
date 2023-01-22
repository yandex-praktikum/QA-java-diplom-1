package praktikum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IngredientTypeTest {
    @Test
    public void enumIngredientTypeS(){
        assertEquals(IngredientType.valueOf("SAUCE"), IngredientType.SAUCE);
    }

    @Test
    public void enumIngredientTypeF(){
        assertEquals(IngredientType.valueOf("FILLING"), IngredientType.FILLING);
    }
}
