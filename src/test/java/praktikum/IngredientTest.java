package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class IngredientTest {
    private final IngredientType type;
    private final String name;
    private final float price;

    public IngredientTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[] getSumData() {
        return new Object[][] {
                { IngredientType.SAUCE, "Соус Spicy-X", 90},
                { IngredientType.FILLING, "Мини-салат Экзо-Плантаго", 4400}
        };
    }

    @Test
    public void getPriceIngredientTest() {
        Ingredient ingredient = new Ingredient(type, name, price);
        float actual = ingredient.getPrice();
        //System.out.println(actual);
        float expected = ingredient.price;
        assertEquals(expected, actual,0);
    }

    @Test
    public void getNameIngredientTest() {
        Ingredient ingredient = new Ingredient(type, name, price);
        String actual = ingredient.getName();
        //System.out.println(actual);
        String expected = ingredient.name;
        assertEquals(expected, actual);
    }

    @Test
    public void getTypeIngredientTest() {
        Ingredient ingredient = new Ingredient(type, name, price);
        IngredientType actual = ingredient.getType();
        //System.out.println(actual);
        IngredientType expected = ingredient.type;
        assertEquals(expected, actual);
    }
}