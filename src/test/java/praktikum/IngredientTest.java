package praktikum;

import net.bytebuddy.description.field.FieldDescription;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class IngredientTest {

    private final IngredientType type;
    private final String name;
    private final float price;
    private Ingredient ingredient;

    public IngredientTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
        this.ingredient = new Ingredient(type, name, price);
    }

    @Parameterized.Parameters(name = "Test data: {0}")
    public static Collection<Object[]> getTestData() {
        return Arrays.asList(new Object[][] {
                {IngredientType.SAUCE, "hot sauce", 100},
                {IngredientType.SAUCE, "sour cream", 200},
                {IngredientType.SAUCE, "chili sauce", 300},
                {IngredientType.SAUCE, "", 1000000000F},
                {IngredientType.FILLING, "cutlet", 100},
                {IngredientType.FILLING, "dinosaur", 200},
                {IngredientType.FILLING, "sausage", 300},
                {IngredientType.FILLING, "hotsauceissohotforthisproject", -1},
                {IngredientType.FILLING, null, 0}

        });
    }

    @Test
    public void getPriceReturnsPrice() {
        Ingredient ingredient = new Ingredient(type, name, price);
        assertEquals(price,ingredient.getPrice(), 0.00001);
    }

    @Test
    public void getNameReturnsName() {

        assertEquals("The ingredient name is not equals", name, ingredient.getName());
    }

    @Test
    public void getTypeReturnsType() {

        assertEquals(type, ingredient.getType());
    }

}