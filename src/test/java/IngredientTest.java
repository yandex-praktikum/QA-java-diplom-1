import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Ingredient;
import praktikum.IngredientType;

@RunWith(MockitoJUnitRunner.class)
public class IngredientTest {

    //Тест на получение типа ингредиента
    @Test
    public void getIngredientTypeTest(){
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "sauce", 0.0f);
        IngredientType expectedType = IngredientType.SAUCE;
        IngredientType actualType = ingredient.getType();

        Assert.assertEquals("Wrong ingredient type", actualType, expectedType);
    }

    //Тест на получение имени ингредиента
    @Test
    public void getIngredientNameTest(){
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "sauce", 0.0f);
        String expected = "sauce";
        String actual = ingredient.getName();

        Assert.assertEquals("Wrong ingredient name", actual, expected);
    }

    //Тест на получение цены ингредиента
    @Test
    public void getIngredientPriceTest(){
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "sauce", 0.0f);
        float expected = 0.0f;
        float actual = ingredient.getPrice();

        Assert.assertEquals("Wrong ingredient price", actual, expected, 0.0f);
    }
}
