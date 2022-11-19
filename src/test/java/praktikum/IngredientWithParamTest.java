package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientWithParamTest {

    private Ingredient ingredient;
    private IngredientType ingredientType;
    private String name;
    private float price;
    private String type;

    @Before
    public void init() {
        MockitoAnnotations.openMocks(this);
        ingredientType = Mockito.mock(IngredientType.class);
        Mockito.when(ingredientType.toString()).thenReturn(type);
        ingredient = new Ingredient(ingredientType, name, price);
    }

    public IngredientWithParamTest(String type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] ingredientParam() {
        return new Object[][] {
                {"SAUCE", "hot sauce", 100f},
                {"SAUCE", "sour cream", 200f},
                {"SAUCE", "chili sauce", 300f},
                {"FILLING", "cutlet", 100f},
                {"FILLING", "dinosaur", 200f},
                {"FILLING", "sausage", 300f}
        };
    }

    @Test
    public void getPriceTest() {
        assertEquals(price, ingredient.getPrice(), 0);
    }

    @Test
    public void getNameTest() {
        assertEquals(name, ingredient.getName());
    }

    @Test
    public void getTypeTest() {
        assertEquals(type, ingredient.getType().toString());
    }
}
