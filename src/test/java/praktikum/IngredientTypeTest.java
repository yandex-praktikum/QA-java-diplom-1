package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

/**
 * Тесты для класса /src/main/java/Ingredient
 * /src/main/java/IngredientType.
 */
@RunWith(Parameterized.class)
public class IngredientTypeTest {

    private Ingredient ingredient;
    private final String nameBun;
    private final float priceBun;
    private final IngredientType ingredientType;

    public IngredientTypeTest(IngredientType ingredientType, String nameBun, float priceBun) {
        this.nameBun = nameBun;
        this.priceBun = priceBun;
        this.ingredientType = ingredientType;
    }

    @Parameterized.Parameters(name = "ingredientType: {0}, nameBun: {1}, priceBun: {2}")
    public static Object[][] getIngredientData() {
        return new Object[][]{
                {IngredientType.FILLING, "Меркурианская", 10.50f},
                {IngredientType.SAUCE, "Space", 0.5f},
                {null, "777", 100},
                {IngredientType.SAUCE, "@#$%", 1525.3999f},
                {IngredientType.FILLING, null, 0},
                {IngredientType.SAUCE, "", 0},
        };
    }

    @Before
    public void setUp() {
        ingredient = new Ingredient(ingredientType, nameBun, priceBun);
    }

    @Test
    public void getPriceIngredientTest() {
        float actualResult = ingredient.getPrice();
        assertEquals(priceBun, actualResult, 0);
    }

    @Test
    public void getNameIngredientTest() {
        String actualResult = ingredient.getName();
        assertEquals(nameBun, actualResult);
    }

    @Test
    public void getTypeIngredientTest() {
        IngredientType actualResult = ingredient.getType();
        assertEquals(ingredientType, actualResult);
    }

    @Test
    public void valuesSauce() {
        IngredientType actual = IngredientType.SAUCE;
        IngredientType excepted = IngredientType.valueOf("SAUCE");
        assertEquals("Error valuesSauce",excepted,actual);
    }

    @Test
    public void valueFilling() {
        IngredientType actual = IngredientType.FILLING;
        IngredientType excepted = IngredientType.valueOf("FILLING");
        assertEquals("Error valueFilling",excepted,actual);
    }
}