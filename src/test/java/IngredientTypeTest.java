import org.junit.Test;
import praktikum.IngredientType;


public class IngredientTypeTest {
    @Test
    public  void ingredientTypeSauceTest(){
        IngredientType.valueOf("SAUCE");
    }
    @Test
    public  void ingredientTypeFillingTest(){
        IngredientType.valueOf("FILLING");
    }
}
