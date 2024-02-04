import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.*;

@RunWith(Parameterized.class)
public class IngredientTest {
    private final IngredientType ingredientType;
    private final String name;
    private final float price;

    public IngredientTest(IngredientType ingredientType, String name, float price){
        this.ingredientType = ingredientType;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {IngredientType.FILLING, "сыр", 27f},
                {IngredientType.SAUCE, "кетчуп", 6f}
        };
    }

    @Test
    public void getPriceIngredientTest(){
        Ingredient ingredient = new Ingredient(ingredientType, name, price);
        Assert.assertEquals(price, ingredient.getPrice(), 0.01f);
    }

    @Test
    public void getNameIngredientTest(){
        Ingredient ingredient = new Ingredient(ingredientType, name, price);
        Assert.assertEquals(name, ingredient.getName());
    }

    @Test
    public void getTypeIngredientTest(){
        Ingredient ingredient = new Ingredient(ingredientType, name, price);
        Assert.assertEquals(ingredientType, ingredient.getType());
    }
}
