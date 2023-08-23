package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTest {
    private final String expectedName;
    private final float expectedPrice;
    private final IngredientType expectedType;

    private Ingredient ingredient;

    @Before
    public void setUp() {
        ingredient = new Ingredient(expectedType,expectedName, expectedPrice);
    }
    public IngredientTest(String expectedName, float expectedPrice, IngredientType expectedType) {
        this.expectedName = expectedName;
        this.expectedPrice = expectedPrice;
        this.expectedType = expectedType;
    }

    @Parameterized.Parameters(name = "Название: {0}, цена: {1}, тип: {2}")
    public static Object[][] createTestData() {
        return new Object[][]{
                {"Волшебный ананас", 500.5f, IngredientType.FILLING},
                {"Космический соус", 999, IngredientType.SAUCE},
        };
    }

    @Test
    public void getPriceReturnCorrectPrice(){
        assertEquals(expectedPrice, ingredient.getPrice(), 0);
    }
    @Test
    public void getNameReturnCorrectName(){
        assertEquals(expectedName, ingredient.getName());
    }
    @Test
    public void getTypeReturnCorrectType(){
        assertEquals(expectedType, ingredient.getType());
    }
}
