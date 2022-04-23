import net.bytebuddy.utility.RandomString;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class IngredientTest {

    private Ingredient ingredient;
    private IngredientType ingredientType;
    private String type;
    private String name;
    private float price;

    @Before
    public void init() {
        MockitoAnnotations.openMocks(this);
        ingredientType = Mockito.mock(IngredientType.class);
        Mockito.when(ingredientType.toString()).thenReturn(type);
        ingredient = new Ingredient(ingredientType, name, price);
    }

    public IngredientTest(String type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] setData() {
        return new Object[][]{
                {"SAUCE", "hot sauce", 100f},
                {"FILLING", RandomString.make(75), Float.MAX_VALUE}, // Роберт Брингхерст в книге «Основы стиля в типографике» - оптимальное значение длины строки составляет от 45 до 75 знаков.
                {"SAUCE", RandomString.make(1), Float.MIN_VALUE},
        };
    }

    @Test
    public void checkName() {
        assertEquals(name, ingredient.getName());
    }

    @Test
    public void checkPrice() {
        assertEquals(price, ingredient.getPrice(), 0);
    }

    @Test
    public void checkType() {
        assertEquals(type, ingredient.getType().toString());
    }

}
