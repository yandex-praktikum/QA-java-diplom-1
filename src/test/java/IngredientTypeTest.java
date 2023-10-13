import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTypeTest {
    private Ingredient ingredient;
    private final IngredientType type;
    private final String name;
    private final float price;

    public IngredientTypeTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters()
    public static Object[][] dataIngredient() {
        return new Object[][]{
                {IngredientType.FILLING, "cutlet", 100.0F},
                {IngredientType.FILLING, "dinosaur", 200.0F},
                {IngredientType.SAUCE, "hot sauce", 100.0F},
                {IngredientType.SAUCE, null, 0.0F},
        };
    }

    @Before
    public void setup() {
        ingredient = new Ingredient(type, name, price);
    }

    @Test
    public void ingredientTypeTest() {
        assertEquals("Некорректные тип ингредиента", type, ingredient.getType());
    }
}
