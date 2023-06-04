import org.junit.Assert;
import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

public class IngredientTest {

    Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "Test", 10);

    @Test
    public void getPriceReturnActualPrice(){
        Assert.assertEquals(10, ingredient.getPrice(), 0);
    }

    @Test
    public void getNameReturnActualName(){
        Assert.assertEquals("Test", ingredient.getName());
    }

    @Test
    public void getTypeReturnActualType(){
        Assert.assertEquals(IngredientType.SAUCE, ingredient.getType());
    }

}
