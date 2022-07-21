package praktikum;

import org.junit.Test;
import praktikum.IngredientType;
import static org.junit.Assert.*;

public class IngredientTypeTests {

    @Test
    public void shouldReturnSauce(){
        final IngredientType expectedType = IngredientType.SAUCE;
        final IngredientType actualType = IngredientType.valueOf("SAUCE");
        assertEquals("Это разве соус?", expectedType, actualType);
    }

    @Test
    public void shouldReturnFilling(){
        final IngredientType expectedType = IngredientType.FILLING;
        final IngredientType actualType = IngredientType.valueOf("FILLING");
        assertEquals("Это разве начинка?", expectedType, actualType);
    }

    @Test
    public void shouldThrowExceptionWithNoData(){
        assertThrows(Exception.class, () -> IngredientType.valueOf(null));
    }

    @Test
    public void shouldThrowExceptionWithIncorrectData(){
        assertThrows(Exception.class, () -> IngredientType.valueOf("MUSTARD"));
    }

}
