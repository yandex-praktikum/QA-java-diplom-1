package praktikum;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static praktikum.DataForTests.*;

public class TestIngredientType {
    @Test
    public void testIngredientTypeIsSauce(){
        assertThat(IngredientType.SAUCE, is(notNullValue()));
        assertEquals(INGREDIENT_TYPE_ONE, IngredientType.SAUCE.name());
    }
    @Test
    public void testIngredientTypeIsFilling(){
        assertThat(IngredientType.FILLING, is(notNullValue()));
        assertEquals(INGREDIENT_TYPE_TWO, IngredientType.FILLING.name());
    }
}
