package praktikum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;
@RunWith(Parameterized.class)

public class GetIngredientTypeParameterizedTest {

    private static final Object SAUCE = IngredientType.SAUCE;
    private static final Object FILLING = IngredientType.FILLING;
    private final Object type;
    private final String name;
    private final float price;
    private final Object expectedType;

    public GetIngredientTypeParameterizedTest(Object type, String name, float price, Object expectedType){
        this.type = type;
        this.name = name;
        this.price = price;
        this.expectedType = expectedType;

    }

    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][] {
                {SAUCE, "hot sauce", 100, SAUCE},
                {SAUCE, "sour cream", 200, SAUCE},
                {SAUCE, "chili sauce", 300, SAUCE},
                {FILLING, "cutlet", 100, FILLING},
                {FILLING, "dinosaur", 200, FILLING},
                {FILLING, "sausage", 300, FILLING}
        };
    }

    @Test
    public void getType() {
        Ingredient ingredient = new Ingredient((IngredientType) type, name, price);

        IngredientType actualType = ingredient.getType();

        assertEquals("Ожидаемый тип " + expectedType + ". Фактический " + actualType, expectedType, actualType);
    }

}
