import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTests {
    IngredientType type;
    String name;
    float price;

    Ingredient ingredient;

    public IngredientTests(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }
    @Parameterized.Parameters
    public static Object[][] getTestValues(){
        return new Object[][]{
                {IngredientType.SAUCE, "Соус1", 1},
                {IngredientType.FILLING, "Начинка1", 24.07f}
        };
    }
    @Before
    public void initIngredient() {
        ingredient = new Ingredient(type, name, price);
    }
    @Test
    public void checkGetName() {
        String expectedName = name;
        assertEquals(expectedName, ingredient.getName());
    }

    @Test
    public void checkGetPrice() {
        float expectedPrice = price;
        assertEquals(expectedPrice, ingredient.getPrice(), 0);
    }

    @Test
    public void checkGetType() {
        IngredientType expectedType= type;
        assertEquals(expectedType, ingredient.getType());
    }
}
