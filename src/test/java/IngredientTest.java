import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

public class IngredientTest {

    Ingredient ingredient;

    @Before
    public void ingridientCreation(){
        ingredient = new Ingredient(IngredientType.FILLING, "cutlet", 100);
    }

    @Test
    public void getNameReturnName(){
        String expectedResult = "cutlet";
        String actualResult = ingredient.getName();
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void getPriceReturnPrice(){
        float expectedResult = 100;
        float actualResult = ingredient.getPrice();
        Assert.assertEquals(expectedResult, actualResult, 0);
    }

    @Test
    public void getTypeReturnType(){
        IngredientType expectedResult = IngredientType.FILLING;
        IngredientType actualResult = ingredient.getType();
        Assert.assertEquals(expectedResult, actualResult);
    }
}
