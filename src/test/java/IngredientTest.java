import org.junit.Test;
import org.mockito.Mock;
import praktikum.Ingredient;
import praktikum.IngredientType;
import static org.junit.Assert.assertEquals;

public class IngredientTest {

    IngredientType inredientType;
    final float PRICE = 1f;
    final String NAME = "name";
    Ingredient sauce = new Ingredient(IngredientType.SAUCE,NAME,PRICE);
    Ingredient filling = new Ingredient(IngredientType.FILLING,NAME,PRICE);
    @Test
    public void testGetPrice(){
        assertEquals("Проверка стоимости",PRICE, sauce.getPrice(),0);
    }
    @Test
    public void testGetName(){
        assertEquals("Проверка имени",NAME,sauce.getName());
    }
    @Test
    public void testTypeSauce(){
        assertEquals("Проверка типа соус", IngredientType.SAUCE,sauce.getType());
    }
    @Test
    public void testTypeFilling(){
        assertEquals("Проверка типа начинка", IngredientType.FILLING,filling.getType());
    }
}
