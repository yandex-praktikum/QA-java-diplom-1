package ingredientparamtest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;
@RunWith(Parameterized.class)
public class IngredientParamPriceTest {
    private final  float expected;
    private final  String name;
    private final float price;
    private final IngredientType type;
    public IngredientParamPriceTest(float expected, float price, String name, IngredientType type) {
        this.expected = expected;
        this.price = price;
        this.name = name;
        this.type = type;
    }
    @Parameterized.Parameters
    public static Object[][] checkIngredientPrice() {
        return new Object[][]{
                {100,100,"hot sauce",SAUCE},
                {200,200,"sour cream",SAUCE},
                {300,300,"chili sauce",SAUCE},
                {100,100,"cutlet",FILLING},
                {200,200,"dinosaur",FILLING},
                {300,300,"sausage",FILLING},
        };
    }
    @Test
    public void checkIngredientPriceTest() {
        Ingredient ingredient = new Ingredient(type, name, price);
        float actual = ingredient.getPrice();
        assertEquals(expected, actual,0.0);
    }
}
