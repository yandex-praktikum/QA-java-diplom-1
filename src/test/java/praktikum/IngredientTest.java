package praktikum;

import net.bytebuddy.utility.RandomString;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Random;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTest {

    Ingredient ingredient;
    IngredientType ingredientType;

    static Random random = new Random();
    static RandomString randomAlphabetic = new RandomString();

    static String name = randomAlphabetic.nextString();
    static float price = random.nextFloat();


    @Before
    public void setUp() {
        ingredient = new Ingredient(ingredientType, name, price);
    }

    public IngredientTest(IngredientType type, String name, float price) {
        this.ingredientType = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters(name = "type:{0} name=:{1} price:{2}")
    public static Object[][] Ingredient() {
        return new Object[][]{
                {IngredientType.SAUCE, name, price},
                {IngredientType.FILLING, name, price}
        };
    }

    @Test
    public void getPrice() {
        assertEquals("Ожидаемая и фактическая цена не совпадают", price, ingredient.getPrice(), 0);
    }

    @Test
    public void getName() {
        assertEquals("Ожидаемое и фактическое имя не совпадают", name, ingredient.getName());
    }

    @Test
    public void getType() {
        assertEquals("Ожидаемый и фактический тип ингредиента не совпадают", ingredientType, ingredient.getType());
    }
}