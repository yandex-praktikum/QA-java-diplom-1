package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Spy;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class IngredientParamTest {

    private IngredientType type;
    private String name;
    private float price;

    static Database database = new Database();
    Ingredient ingredient;

    public IngredientParamTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][]{
                {
                        database.availableIngredients().get(3).getType(),
                        database.availableIngredients().get(3).getName(),
                        database.availableIngredients().get(3).getPrice(),
                },
                {
                        database.availableIngredients().get(1).getType(),
                        database.availableIngredients().get(1).getName(),
                        database.availableIngredients().get(1).getPrice(),
                },
                {
                        database.availableIngredients().get(5).getType(),
                        database.availableIngredients().get(5).getName(),
                        database.availableIngredients().get(5).getPrice(),
                },

        };
    }

    @Before
    public void setUp() {
        ingredient = new Ingredient(type, name, price);

    }

    @Test
    public void IngredientGetTypeTest() {
        Assert.assertEquals(type, ingredient.getType());
    }

    @Test
    public void IngredientGetNameTest() {
        Assert.assertEquals(name, ingredient.getName());
    }

    @Test
    public void IngredientGetPriceTest() {
        Assert.assertEquals(price, ingredient.getPrice(), 0);
    }

}