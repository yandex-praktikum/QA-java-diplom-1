package praktikum.stellarburgers.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static praktikum.stellarburgers.model.IngredientType.FILLING;
import static praktikum.stellarburgers.model.IngredientType.SAUCE;
import static praktikum.stellarburgers.model.mock.BurgerDataGenerator.getRandomIngredientData;

@RunWith(Parameterized.class)
public class IngredientTest {
    private final IngredientType TYPE;
    private final String NAME;
    private final float PRICE;

    private Burger burger;
    private Ingredient ingredient;

    public IngredientTest(IngredientType type, String name, float price) {
        this.TYPE = type;
        this.NAME = name;
        this.PRICE = price;
    }

    @Parameterized.Parameters(name = "Ingredient test with data: ( {index} )")
    public static Object[][] getIngredientData() {
        return new Object[][] {
                getRandomIngredientData(SAUCE),
                getRandomIngredientData(FILLING),
                { SAUCE, "", 0},
                { FILLING, "", 0},
                { SAUCE, null, 0},
                { FILLING, null, 0},
                { SAUCE, "", Float.NaN},
                { FILLING, "", Float.NaN},
                { SAUCE, null, Float.NaN},
                { FILLING, null, Float.NaN},
        };
    }

    @Before
    public void initIngredient() {
        burger = new Burger();
        ingredient = new Ingredient(TYPE, NAME, PRICE);
    }

    @Test
    public void getTypeTest() {
        Assert.assertEquals(TYPE, ingredient.getType());
    }

    @Test
    public void getName() {
        Assert.assertEquals(NAME, ingredient.getName());
    }

    @Test
    public void getPrice() {
        Assert.assertEquals(PRICE, ingredient.getPrice(), 0);
    }
}
