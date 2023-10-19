import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;


@RunWith(Parameterized.class)
public class IngredientTest
{
    private Ingredient ingredient;
    private final String name;
    private final float price;
    private final IngredientType type;

    public IngredientTest(IngredientType type, String name, float price)
    {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] getData()
    {
        return new Object[][]{
                {IngredientType.SAUCE, "sauce традиционный галактический Ызшсу-Ч и длинным именем и ценой", 107878787.6f},
                {IngredientType.SAUCE, " ", 0},
                {IngredientType.SAUCE, "null", 99},
                {IngredientType.FILLING, "Мясо бессмертных моллюcков Protostomia (отбивная) Экро-плантаго", 1337},
                {IngredientType.FILLING, " ", 107878787.6f},
                {IngredientType.FILLING, "null", 300},
        };
    }

    @Before
    public void setUp()
    {
        ingredient = new Ingredient(type, name, price);
    }

    @Test
    public void getNameTest()
    {
        Assert.assertEquals(name, ingredient.getName());
    }

    @Test
    public void getPriceTest()
    {
        Assert.assertEquals(price, ingredient.getPrice(), 0.001);
    }

    @Test
    public void getTypeTest()
    {
        Assert.assertEquals(type, ingredient.getType());
    }
}
