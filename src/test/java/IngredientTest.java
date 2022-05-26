import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;
import static org.junit.Assert.assertEquals;

public class IngredientTest {

    @Test
    public void returnIngredientNameTest(){
        Ingredient ingredient =new Ingredient(IngredientType.SAUCE, "BestBulochka", 0.66f);
        assertEquals("BestBulochka", ingredient.getName());
    }

    @Test
    public void returnIngredientPriceTest(){
        Ingredient ingredient =new Ingredient(IngredientType.FILLING, "TopBurdger", 0.67f);
        assertEquals(0.67f, ingredient.getPrice(),0);
    }

    @Test
    public void returnIngredientTypeTest(){
        Ingredient ingredient =new Ingredient(IngredientType.FILLING, "Delicious", 0.68f);
        assertEquals(IngredientType.FILLING, ingredient.getType());

    }
}
