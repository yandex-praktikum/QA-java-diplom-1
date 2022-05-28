import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.*;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientParamsTest {
    private final IngredientType type;
    private final String name;
    private final float price;

    public IngredientParamsTest(IngredientType type,
                                String name,
                                float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters(name = "Тестовые данные: {0} {1}")
    public static Object[][] getIngredientData(){
        return new Object[][]{
                {IngredientType.SAUCE, "Mustard", 1.0f},
                {IngredientType.FILLING, "Cheese", 2.5f},
        };
    }

    @Test
    public void checkCorrectIngredientTypeIsReturned(){
        Ingredient ingredient = new Ingredient(type, name, price);
        IngredientType result = ingredient.getType();
        assertEquals(type, result);
    }
}
