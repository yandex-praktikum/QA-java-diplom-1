import org.junit.Test;
import org.mockito.Mock;
import praktikum.Ingredient;
import praktikum.IngredientType;
import static org.junit.Assert.assertNotEquals;

public class NegativeIngredientTest {
    private final static float UNEXPECTEDPRICE = 456.0f;
    @Mock
    Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "hot sauce", 100);


    @Test
    public void testGetNameNegative() {
        assertNotEquals("ketchup", ingredient.getName());
    }

    @Test
    public void testGetPrice() {
        assertNotEquals(UNEXPECTEDPRICE, ingredient.getPrice(), 0.001);
    }
    @Test
    public void testGetType(){
        assertNotEquals(IngredientType.FILLING, ingredient.getType());
    }

}

