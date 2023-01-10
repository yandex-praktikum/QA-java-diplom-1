package praktikum;

import org.hamcrest.MatcherAssert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.hamcrest.CoreMatchers.equalTo;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class IngredientTest {
    public static IngredientType type;
    public static String name;
    public static float price;

    public IngredientTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters(name = "{index}:{0},{1}")
    public static Object[][] getIngredient() {
        return new Object[][]{
                {SAUCE, "Bun2", 100},
                {FILLING, "Bun2", 100},
        };
    }

    @Test
    public void getNameReturnsCorrectName() {
        Ingredient ingredient = new Ingredient(type, name, price);
        String expected = name;
        MatcherAssert.assertThat("Incorrect name was provided", ingredient.getName(), equalTo(expected));
    }

    @Test
    public void getPriceReturnsCorrectPrice() {
        Ingredient ingredient = new Ingredient(type, name, price);
        float expected = price;
        MatcherAssert.assertThat("Incorrect price or empty value is provided", ingredient.getPrice(), equalTo(expected));
    }

    @Test
    public void getTypeReturnsCorrectType() {
        Ingredient ingredient = new Ingredient(type, name, price);
        IngredientType expected = type;
        MatcherAssert.assertThat("Incorrect ingredient type is provided", ingredient.getType(), equalTo(expected));
    }

}