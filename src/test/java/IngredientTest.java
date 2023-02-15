import org.junit.Assert;
import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

public class IngredientTest {
    private String name;
    private float price;
    private IngredientType type;
    @Test
    public void getPriceReturnsValidPrice(){
        Ingredient ingredient = new Ingredient(type, name, price);
        float actualResult = ingredient.getPrice();
        float expectedResult = price;
        Assert.assertEquals(expectedResult, actualResult, 0);
    }

    @Test
    public void getNameReturnsValidName(){
        Ingredient ingredient = new Ingredient(type, name, price);
        String  actualResult = ingredient.getName();
        String expectedResult = name;
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void getTypeReturnsValidType(){
        Ingredient ingredient = new Ingredient(type, name, price);
        IngredientType actualResult = ingredient.getType();
        IngredientType expectedResult = type;
        Assert.assertEquals(expectedResult, actualResult);
    }


}
