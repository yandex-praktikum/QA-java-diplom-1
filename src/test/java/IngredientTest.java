import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;
import static org.junit.Assert.*;
import static praktikum.IngredientType.*;

@RunWith(Parameterized.class)
public class IngredientTest {

    private final Ingredient ingredientValue;
    private final IngredientType ingredientType;
    private final IngredientType ingredientTypeError;
    private final String ingredientName;
    private final String ingredientNameError;
    private final float ingredientPrice;
    private final float ingredientPriceError;

    public IngredientTest(Ingredient ingredientValue, IngredientType ingredientType, IngredientType ingredientTypeError, String ingredientName, String ingredientNameError, float ingredientPrice, float ingredientPriceError) {
        this.ingredientValue = ingredientValue;
        this.ingredientType = ingredientType;
        this.ingredientTypeError = ingredientTypeError;
        this.ingredientName = ingredientName;
        this.ingredientNameError = ingredientNameError;
        this.ingredientPrice = ingredientPrice;
        this.ingredientPriceError = ingredientPriceError;
    }

    @Parameterized.Parameters
    public static Object[][] getValue() {
        return new Object[][] {
                {new Ingredient(IngredientType.SAUCE, "hot sauce", 100), SAUCE, FILLING, "hot sauce", "sour cream", 100, 150},
                {new Ingredient(IngredientType.SAUCE, "sour cream", 200), SAUCE, FILLING, "sour cream", "hot sauce", 200, 150},
                {new Ingredient(IngredientType.FILLING, "cutlet", 100), FILLING, SAUCE, "cutlet", "dinosaur", 100, 150},
                {new Ingredient(IngredientType.FILLING, "dinosaur", 200), FILLING, SAUCE, "dinosaur", "cutlet", 200, 150},
        };
    }

    @Test
    public void getNameReturn(){
        String actualName = ingredientValue.getName();
        assertEquals(ingredientName,actualName);
    }

    @Test
    public void getNameNotReturn(){
        String actualName = ingredientValue.getName();
        assertNotEquals(ingredientNameError,actualName);
    }

    @Test
    public void getPriceReturn(){
        float actualPrice = ingredientValue.getPrice();
        assertEquals(ingredientPrice,actualPrice,0);
    }

    @Test
    public void getPriceNotReturn(){
        float actualPrice = ingredientValue.getPrice();
        assertNotEquals(ingredientPriceError,actualPrice,0);
    }

    @Test
    public void getTypeReturn(){
        IngredientType actualType = ingredientValue.getType();
        assertEquals(ingredientType, actualType);
    }

    @Test
    public void getTypeNotReturn(){
        IngredientType actualType = ingredientValue.getType();
        assertNotEquals(ingredientTypeError, actualType);
    }
}