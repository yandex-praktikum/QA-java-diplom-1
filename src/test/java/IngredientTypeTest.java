import org.junit.Test;
import praktikum.IngredientType;
import static junit.framework.TestCase.assertEquals;

public class IngredientTypeTest {


    @Test

    public void returnIngredientSauceNameTest(){
        IngredientType ingredientType=IngredientType.SAUCE;
        String e=ingredientType.toString();
        assertEquals(e,"SAUCE");

    }
    @Test

    public void returnIngredientFillingNameTest(){
        IngredientType ingredientType=IngredientType.FILLING;
        String e=ingredientType.toString();
        assertEquals(e,"FILLING");

    }
}
