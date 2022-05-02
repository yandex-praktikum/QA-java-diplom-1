package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)

public class IngredientParametrizedTest {
    private IngredientType type;
    private String name;
    private float price;

    public IngredientParametrizedTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] getTypeData() {
        return new Object[][]{
                {IngredientType.FILLING, "Биокотлета из марсианской Магнолии", 424f},
                {IngredientType.SAUCE, "Соус Spicy-X", 90f},
        };
    }

    @Test
    public void getTypeTest() {
        Ingredient ingredient = new Ingredient(type, name, price);
        Assert.assertEquals("Тип ингридиента не совпадает", type, ingredient.getType());
    }
}