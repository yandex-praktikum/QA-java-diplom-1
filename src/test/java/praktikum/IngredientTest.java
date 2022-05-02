package praktikum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import com.github.javafaker.Faker;
import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.*;

@RunWith(Parameterized.class)
public class IngredientTest {
    static Faker faker = new Faker();
    private IngredientType ingredientType;
    private final String name;
    private final float price;


    public IngredientTest(IngredientType ingredientType, String name, float price) {
        this.ingredientType = ingredientType;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][] {
                {SAUCE, faker.lorem().fixedString(1), 100 },
                {FILLING, faker.lorem().fixedString(100), 100 },
                {SAUCE, faker.lorem().fixedString(50), Float.MIN_NORMAL},
                {FILLING, faker.lorem().fixedString(50), Float.MAX_VALUE},
                {SAUCE, null, 100},
                {FILLING, "", 100},
                {SAUCE, faker.lorem().fixedString(50), 0},
        };
    }

    @Test
    public void shouldGetPrice() {
        Ingredient ingredient = new Ingredient(ingredientType, name, price);
        assertEquals(price, ingredient.getPrice(), 0);
    }

    @Test
    public void shouldGetName() {
        Ingredient ingredient = new Ingredient(ingredientType, name, price);
        assertEquals(name, ingredient.getName());
    }

    @Test
    public void shouldGetType() {
        Ingredient ingredient = new Ingredient(ingredientType, name, price);
        assertEquals(ingredientType, ingredient.getType());
    }
}