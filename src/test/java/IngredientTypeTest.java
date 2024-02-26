import org.junit.Test;
import praktikum.IngredientType;
import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

public class IngredientTypeTest {
    @Test
    public void checkIngredientTypeSauce(){
        assertEquals(IngredientType.valueOf("SAUCE"), SAUCE);
    }

    @Test
    public void checkIngredientTypeSauceFilling(){
        assertEquals(IngredientType.valueOf("FILLING"), FILLING);
    }

}
