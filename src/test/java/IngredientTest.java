import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import praktikum.Ingredient;
import praktikum.IngredientType;


@RunWith(DataProviderRunner.class)
public class IngredientTest {

    @DataProvider
    public static Object[] Ingredients() {
        return new Object[][]{
                {IngredientType.SAUCE, "hot sauce", 200},
                {IngredientType.FILLING, "sausage", 300}
        };
    }

    @Test
    @UseDataProvider("Ingredients")
    public void getPriceReturnTest(IngredientType type, String name, float price) {
        Ingredient ingredient = new Ingredient(type, name,price);
        float actualResult = ingredient.getPrice();
        float expectedResult = price;

        Assert.assertEquals(expectedResult, actualResult, 0);
    }

    @Test
    @UseDataProvider("Ingredients")
    public void getNameReturnTest(IngredientType type, String name, float price) {
        Ingredient ingredient = new Ingredient(type, name,price);
        String actualResult = ingredient.getName();
        String expectedResult = name;

        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    @UseDataProvider("Ingredients")
    public void getTypeReturnTest(IngredientType type, String name, float price) {
        Ingredient ingredient = new Ingredient(type, name,price);
        IngredientType actualResult = ingredient.getType();
        IngredientType expectedResult = type;

        Assert.assertEquals(expectedResult, actualResult);
    }
}
