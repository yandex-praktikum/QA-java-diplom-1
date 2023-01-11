import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import praktikum.Ingredient;
import praktikum.IngredientType;

@RunWith(DataProviderRunner.class)
public class IngredientsTest {


    @DataProvider
    public static Object[] Ingredients(){
        return new Object[][]{
                {IngredientType.SAUCE, "hot sauce", 100},
                {IngredientType.FILLING, "cutlet", 100}
        };
    }

    @Test
    @UseDataProvider("Ingredients")
    public void getPriceTest(IngredientType type, String name, float price){
        Ingredient ingredient = new Ingredient(type, name, price);
        float actualPrice = ingredient.getPrice();
        Assert.assertEquals(price,actualPrice,0);
    }

    @Test
    @UseDataProvider("Ingredients")
    public void getTypeTest(IngredientType type, String name, float price){
        Ingredient ingredient = new Ingredient(type, name, price);
        IngredientType actualType = ingredient.getType();
        Assert.assertEquals(type, actualType);
    }

    @Test
    @UseDataProvider("Ingredients")
    public void getNameTest(IngredientType type, String name, float price){
        Ingredient ingredient = new Ingredient(type, name, price);
        String actualName = ingredient.getName();
        Assert.assertEquals(name, actualName);
    }
}
