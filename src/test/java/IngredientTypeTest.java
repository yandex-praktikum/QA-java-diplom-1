import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;
import static org.junit.Assert.assertEquals;

public class IngredientTypeTest {
    @Test
    public void testTypesAreValid(){
        assertEquals(IngredientType.FILLING.toString(),"FILLING");
        assertEquals(IngredientType.SAUCE.toString(),"SAUCE");
    }
}
