import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

@RunWith(Parameterized.class)
public class IngredientTest {

    private final IngredientType ingredientType;
    private final String name;
    private final float price;

    private Ingredient ingredient;

    public IngredientTest(IngredientType ingredientType, String name, float price) {
        this.ingredientType = ingredientType;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] getParameters(){
        return new Object[][]{
                {IngredientType.FILLING, "Гауда", 6},
                {IngredientType.SAUCE, "Чесночный", 2}
        };
    }

    @Before
    public void initIngredient(){
        ingredient = new Ingredient(ingredientType,name,price);
    }

    @Test
    public void getNameReturnIngredientName(){
        Assert.assertEquals("Ожидание: "+name, name, ingredient.getName());
    }

    @Test
    public void getPriceReturnIngredientPrice(){
        Assert.assertEquals("Ожидание: "+price,price, ingredient.getPrice(), 0.1);
    }

    @Test
    public void getTypeReturnIngredientType(){
        Assert.assertEquals("Ожидание: "+ingredientType.toString(),ingredientType,ingredient.getType());
    }

}
