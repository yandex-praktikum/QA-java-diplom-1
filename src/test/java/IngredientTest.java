import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;
import praktikum.Ingredient;
import praktikum.IngredientType;

public class IngredientTest {

    @Mock
    IngredientType ingredientType;

    //getPrice
    @Test
    public void getPriceReturnsCorrectPrice() {
        Ingredient ingredient = new Ingredient(null, null, 1.5f);
        float expectedPrice = 1.5f;
        float actualPrice = ingredient.getPrice();
        Assert.assertEquals(expectedPrice, actualPrice, 0.0f);
    }

    //getName
    @Test
    public void getNameReturnsCorrectName() {
        Ingredient ingredient = new Ingredient(null, "С кунжутом", 0);
        String expectedName = "С кунжутом";
        String actualName = ingredient.getName();
        Assert.assertEquals(expectedName, actualName);
    }

    //getType
    @Test
    public void getTypeReturnsCorrectType() {
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, null, 0);
        IngredientType expectedType = ingredientType.FILLING;
        IngredientType actualType = ingredient.getType();
        Assert.assertEquals(expectedType, actualType);
    }
}
