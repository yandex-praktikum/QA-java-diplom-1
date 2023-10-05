package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class IngredientTypeTest {
    private IngredientType type;
    private String name;
    private float price;

    public IngredientTypeTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters(name = "Type: {0}")
    public static Object[][] getData() {
        return new Object[][]{
                {IngredientType.SAUCE, "Соус", 10.0f},
                {IngredientType.FILLING, "Начинка", 5.0f}
        };
    }

    @Test
    public void getTypeShouldReturnDifferentTypeOfIngredient() {
        Ingredient ingredient = new Ingredient(type, name, price);
        IngredientType actual = ingredient.getType();
        assertEquals("Неправильный тип ингредиента", type, actual);
    }
}
