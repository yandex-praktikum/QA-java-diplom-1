import org.junit.Before;
import praktikum.Ingredient;
import praktikum.IngredientType;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class IngredientTest {
    private final IngredientType type;
    private final String name;
    private final float price;

    Ingredient ingredient;
    public IngredientTest(IngredientType type,String name,float price){
        this.type = type;
        this.name = name;
        this.price = price;
    }
    @Parameterized.Parameters(name = "Ingredients. Test data: {0},{1},{2}")
    public static Object[][] IngredientType() {
        return new Object[][]{
                {IngredientType.FILLING,"Burger",2.05F},
                {IngredientType.SAUCE,"French fries",1.25F}
        };
    }
    @Before
    public void ingredient(){
    ingredient = new Ingredient(type,name,price);
}
    @Test
    public void getPrice() {
        Assert.assertEquals(price, ingredient.getPrice(),0);
    }
    @Test
    public void getName() {
        Assert.assertEquals(name, ingredient.getName());
    }
    @Test
    public void getType() {
        Assert.assertEquals(type, ingredient.getType());
    }
}