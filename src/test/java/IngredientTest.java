import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;
@RunWith(Parameterized.class)
public class IngredientTest {

    private final IngredientType type;
    private final String name;
    private final float price;
    private final IngredientType expectedType;
    private final String expectedName;
    private final float expectedPrice;

    public IngredientTest(IngredientType type, String name, float price, IngredientType expectedType, String expectedName, float expectedPrice) {
        this.type = type;
        this.name = name;
        this.price = price;
        this.expectedType = expectedType;
        this.expectedName = expectedName;
        this.expectedPrice = expectedPrice;
    }

    @Parameterized.Parameters
    public static Object[][] getIngredient() {
        return new Object[][]{
                {IngredientType.SAUCE, "Кетчуп", 100, IngredientType.SAUCE, "Кетчуп", 100},
                {IngredientType.FILLING, "Котлета", 100, IngredientType.FILLING, "Котлета", 100}
        };
    }

    @Test
    public void getNameReturnsValidParametrs(){
        Ingredient ingredient = new Ingredient(type, name, price);

        IngredientType actualType = ingredient.getType();
        String actualName = ingredient.getName();
        float actualPrice = ingredient.getPrice();

        assertEquals(expectedType, actualType);
        assertEquals(expectedName, actualName);
        assertEquals(expectedPrice, actualPrice, 0);
    }
}
