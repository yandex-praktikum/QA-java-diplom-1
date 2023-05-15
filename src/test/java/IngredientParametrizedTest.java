import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class IngredientParametrizedTest {
    private final IngredientType type;
    private final String name;
    private final float price;
    Ingredient ingredient;

    public IngredientParametrizedTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters(name = "Тестовые данные: {0} {1}")
    public static Object[][] getTestData() {
        return new Object[][]{
                {SAUCE, "sweet chilli sauce", -1},
                {SAUCE, "барбекю", 54376736},
                {SAUCE, "майонез", Float.MIN_VALUE},
                {FILLING, "колтека из свинины с говядинной в пропорции 50/50", Float.MAX_VALUE},
                {FILLING, "dinosaur", 200},
                {FILLING, "sausage", 300},
                {null, "котлетка", 456},
                {FILLING, "", 0},
                {FILLING, null, 23.1111f}
        };
    }

    @Before
    public void setUp() {
        ingredient = new Ingredient(type, name, price);
    }

    @Test
    public void checkPriceWithValidData() {
        Assert.assertEquals(price, ingredient.getPrice(), 0.001f);
    }

    @Test
    public void checkNameWithValidData() {
        Assert.assertEquals(name, ingredient.getName());
    }

    @Test
    public void checkTypeWithValidData() {
        Assert.assertEquals(type, ingredient.getType());

    }

}