package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTest {
    private final String expectedName;
    private final IngredientType expectedType;
    private final float expectedPrice;

    Ingredient ingredient;

    @Before
    public void createIngredient(){
        ingredient = new Ingredient(expectedType, expectedName, expectedPrice);
    }

    public IngredientTest(String expectedName, IngredientType expectedType, float expectedPrice){

        this.expectedName = expectedName;
        this.expectedType = expectedType;
        this.expectedPrice = expectedPrice;
    }

    @Parameterized.Parameters (name = "{index}: expectedName = {0}, expectedType = {1}, expectedPrice = {2}")
    public static Object[][] checkIngredient() {

        return new Object[][] {
                {"chili sauce", IngredientType.SAUCE, 5},
                {"hot sauce", IngredientType.SAUCE, 4},
                {"sour cream", IngredientType.SAUCE, 4},
                {"cutlet", IngredientType.FILLING, 25},
                {"dinosaur", IngredientType.FILLING, 25}
        };
    }

    @Test
    public void getPriceIngredientTest() {
        float actualPrice = ingredient.getPrice();

        assertEquals("Некорректное отображение цены", expectedPrice, actualPrice, 0.0f);
    }

    @Test
    public void getNameIngredientTest() {
        String actualName = ingredient.getName();

        assertEquals("Некорректное отображение названия", expectedName, actualName);
    }

    @Test
    public void getTypeIngredientTest() {
        IngredientType actualType = ingredient.getType();

        assertEquals("Некорректное отображение типа ингредиента", expectedType, actualType);
    }
}
