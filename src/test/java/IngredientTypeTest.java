import org.junit.Test;
import praktikum.IngredientType;
import static org.junit.Assert.assertEquals;

public class IngredientTypeTest {

    /* Тесты на соответствие значений в enum */
    @Test
    public void checkIngredientTypeSauce(){
        assertEquals("Значение SAUCE в enum IngredientType указано неверно.", IngredientType.SAUCE.name(), "SAUCE");
    }

    @Test
    public void checkIngredientTypeFilling(){
        assertEquals("Значение FILLING в enum IngredientType указано неверно.", IngredientType.FILLING.name(), "FILLING");
    }

    /* Тесты на соответствие порядка значений в enum */
    @Test
    public void checkIngredientTypeSauceIndexIs0(){
        assertEquals(0, IngredientType.SAUCE.ordinal());
    }

    @Test
    public void checkIngredientTypeFillingIndexIs1(){
        assertEquals(1, IngredientType.FILLING.ordinal());
    }




}
