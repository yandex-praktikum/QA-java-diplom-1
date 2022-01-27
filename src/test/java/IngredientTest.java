import org.junit.Test;
import org.mockito.Mock;
import praktikum.Ingredient;
import praktikum.IngredientType;
import static org.junit.Assert.assertEquals;

public class IngredientTest {
    @Mock
    IngredientType inredientType;
    final float PRICE = 1f;
    final String NAME = "name";
    Ingredient sauce = new Ingredient(inredientType,NAME,PRICE);
    @Test
    public void testGetPrice(){
        assertEquals("Проверка стоимости",PRICE, sauce.getPrice(),0);
    }
    @Test
    public void testGetName(){
        assertEquals("Проверка имени",NAME,sauce.getName());
    }
}
