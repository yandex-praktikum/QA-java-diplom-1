import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Database;
import praktikum.Ingredient;
import praktikum.IngredientType;

@RunWith(Parameterized.class)
public class IngredientTest {

    private IngredientType type;
    private String name;
    private float price;
    private int index;

    public IngredientTest(IngredientType type, String name, float price, int index) {
        this.type = type;
        this.name = name;
        this.price = price;
        this.index = index;
    }

    @Parameterized.Parameters
    public static Object[][] getTestData(){
        return new Object[][] {
                {database.availableIngredients().get(0).getType(), database.availableIngredients().get(0).getName(),
                database.availableIngredients().get(0).getPrice(), 0},
                {database.availableIngredients().get(1).getType(), database.availableIngredients().get(1).getName(),
                database.availableIngredients().get(1).getPrice(), 1},
                {database.availableIngredients().get(2).getType(), database.availableIngredients().get(2).getName(),
                database.availableIngredients().get(2).getPrice(), 2},
                {database.availableIngredients().get(3).getType(), database.availableIngredients().get(3).getName(),
                database.availableIngredients().get(3).getPrice(), 3},
                {database.availableIngredients().get(4).getType(), database.availableIngredients().get(4).getName(),
                database.availableIngredients().get(4).getPrice(), 4},
                {database.availableIngredients().get(5).getType(), database.availableIngredients().get(5).getName(),
                database.availableIngredients().get(5).getPrice(), 5}
        };
    }

    @Spy
    static Database database = new Database();

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void checkGetTypePositive(){
        Assert.assertEquals("У ингредиента другой тип", database.availableIngredients().get(index).getType(), type);
    }
    @Test
    public void checkGetNamePositive(){
        Assert.assertEquals("У ингредиента другой тип", database.availableIngredients().get(index).getName(), name);
    }
    @Test
    public void checkGetPricePositive(){
        Assert.assertEquals("У ингредиента другой тип", database.availableIngredients().get(index).getPrice(),
                price, 0.001f);
    }

    @Test
    public void createNewIngredientPositive(){
        Ingredient ingredient1 = new Ingredient(IngredientType.FILLING, "cream fresh", 100);
        Ingredient ingredient2 = new Ingredient(IngredientType.SAUCE, "tomato sause", 120);
        Assert.assertNotNull(ingredient1);
        Assert.assertNotNull(ingredient2);
    }
}
