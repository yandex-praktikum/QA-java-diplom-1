import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Ingredient;
import praktikum.IngredientType;

@RunWith(MockitoJUnitRunner.class)
public class IngredientTest {

    @Test
    public void getIngredientTypeTest(){
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "ketchup", 0);
        Assert.assertEquals("Incorrect ingredient type", ingredient.getType(), IngredientType.SAUCE);
    }

    @Test
    public void getIngredientNameTest(){
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "ketchup", 0);
        Assert.assertEquals("Incorrect ingredient name", "ketchup", ingredient.getName());
    }

    @Test
    public void getIngredientPriceTest(){
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "sauce", 100);
        Assert.assertEquals("Wrong ingredient price", ingredient.getPrice(), 100, 0.0f);
    }
}