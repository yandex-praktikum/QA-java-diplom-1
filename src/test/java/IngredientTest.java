import org.junit.Assert;
import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

public class IngredientTest {
    //забабахать параметризацию для IngredientType
    Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "hot sauce", 200);
    @Test
    public void getPriceTest(){
        Assert.assertEquals(200.0, ingredient.getPrice(), 0);
    }
    @Test
    public void getNameTest(){
        Assert.assertEquals("hot sauce", ingredient.getName());
    }
    @Test
    public void getTypeTest(){
        Assert.assertEquals(IngredientType.SAUCE, ingredient.getType());
    }
}
