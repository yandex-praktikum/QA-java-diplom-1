package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class IngredientParametrizedTest {

    private final IngredientType type;
    private final String name;
    private final float price;
    private final IngredientType expectedType;
    private final String expectedName;
    private final float expectedPrice;
    private Ingredient ingredient;

    public IngredientParametrizedTest(IngredientType type,
                                      String name,
                                      float price,
                                      IngredientType expectedType,
                                      String expectedName,
                                      float expectedPrice) {
        this.type = type;
        this.name = name;
        this.price = price;
        this.expectedType = expectedType;
        this.expectedName = expectedName;
        this.expectedPrice = expectedPrice;
    }

    @Parameterized.Parameters(name = "{index} : type = {0}, name = {1}, price = {2}")
    public static Object[][] ingredientIsCreateData() {
        return new Object[][] {
                {SAUCE, "hot sauce", 100.1f, SAUCE, "hot sauce", 100.1f},
                {FILLING, "sour cream", 0.1f, FILLING, "sour cream", 0.1f}
        };
    }

    @Before
    public void setUp() {
        ingredient = new Ingredient(type, name, price);
        float actualPrice = ingredient.getPrice();
    }

    @Test
    public void initializeIngredientCheckIngredientTypeTrue(){
        IngredientType actualType = ingredient.getType();
        assertEquals("Тип ингредиента некорректный", expectedType, actualType);
    }

    @Test
    public void initializeIngredientCheckNameTrue(){
        String actualName = ingredient.getName();
        assertEquals("Имя ингредиента некорректное", expectedName, actualName);
    }

    @Test
    public void initializeIngredientCheckPriceTrue(){
        float actualPrice = ingredient.getPrice();
        assertEquals("Цена ингредиента некорректная", expectedPrice, actualPrice, 0);
    }
}
