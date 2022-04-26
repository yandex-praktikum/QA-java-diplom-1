package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTest {

    Ingredient ingredient;
    IngredientType type;
    String name;
    float price;

    public IngredientTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] getBurgerData() {
        return new Object[][]{
                {IngredientType.SAUCE, "sauce", 1f},
                {IngredientType.FILLING, "filling", 2f},

        };
    }

    @Before
    public void setUp() {
        ingredient = new Ingredient (type, name, price);
    }

    @Test
    public void testGetPrice() {
        assertEquals ("Price doesn't match to expected one.", price, ingredient.price, 0);
    }

    @Test
    public void testTestGetName() {
        assertEquals ("Name doesn't match to expected one.", name, ingredient.getName ());
    }

    @Test
    public void testGetType() {
        assertEquals ("Type doesn't match to expected one.", type, ingredient.getType ());
    }
}