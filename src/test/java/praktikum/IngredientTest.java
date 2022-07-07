package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class IngredientTest {

    private IngredientType type;
    private String name;
    private float price;
    private Ingredient ingredient;

    @Parameterized.Parameters(name = "Тестовые данные: {0} {1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {IngredientType.SAUCE, "hot sauce", 100},
                {IngredientType.FILLING, "cutlet", 100}
        });
    }

    public IngredientTest(IngredientType type, String name, float price){
        this.type = type;
        this.name = name;
        this.price = price;
        this.ingredient = new Ingredient(type, name, price);
    }

    @Test
    public void getPrice() {
        assertTrue(price == ingredient.getPrice());
    }

    @Test
    public void getName() {
        assertEquals(name, ingredient.getName());
    }

    @Test
    public void getType() {
        assertEquals(type, ingredient.getType());
    }
}