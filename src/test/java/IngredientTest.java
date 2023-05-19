import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;
@RunWith(Parameterized.class)
public class IngredientTest {
    private IngredientType type;
    private IngredientType expectedType;
    private String name;
    private String expectedName;
    private float price;
    private float expectedPrice;
    private Ingredient ingredient;

    public IngredientTest(IngredientType type, IngredientType expectedType, String name, String expectedName, float price, float expectedPrice) {
        this.type = type;
        this.expectedType = expectedType;
        this.name = name;
        this.expectedName = expectedName;
        this.price = price;
        this.expectedPrice = expectedPrice;
    }

    @Parameterized.Parameters
    public static Object[][]getData(){
        return new Object[][]{
                {IngredientType.SAUCE, IngredientType.SAUCE, "Кетчуп", "Кетчуп", 145.09F, 145.09F},
                {IngredientType.FILLING, IngredientType.FILLING, "Bacon", "Bacon", 405F, 405F}
        };
    }

    @Before
    public void setUp(){
       ingredient = new Ingredient(type, name , price);
    }

    @Test
    public void getPriceTest(){
        Assert.assertEquals(expectedPrice, ingredient.getPrice(), 0);
    }

    @Test
    public void getNameTest(){
        Assert.assertEquals(expectedName, ingredient.getName());
    }

    @Test
    public void getTypeTest(){
        Assert.assertEquals(expectedType, ingredient.getType());
    }
}
