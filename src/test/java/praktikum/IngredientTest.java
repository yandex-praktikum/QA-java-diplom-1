package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;


@RunWith(Parameterized.class)
public class IngredientTest {

    private final IngredientType type;
    private final String name;
    private final float price;
    Ingredient ingredient;

    public IngredientTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] getBurgerData() {
        return new Object[][]{
                {IngredientType.FILLING, "dinosaur", 200},
                {IngredientType.SAUCE, "chili sauce", 300},
        };
    }

    @Before
    public void setUp() {
        ingredient = new Ingredient(type, name, price);
    }

    @Test
    public void getPriceIngredientTest() {
        float actual = ingredient.getPrice();
        Assert.assertEquals("Ожидаемая цена ингредиента " + price, price, actual, 0);
    }

    @Test
    public void getNameIngredientTest() {
        String actual = ingredient.getName();
        Assert.assertEquals("Ожидаемое название ингредиента - " + name, name, actual);
    }

    @Test
    public void getTypeIngredientTest() {
        IngredientType actual = ingredient.getType();
        Assert.assertEquals("Ожидаемый тип ингредиента -" + type, type, actual);
    }
}