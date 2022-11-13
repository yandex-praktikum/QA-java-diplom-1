import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

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
        return new Object[][]{
                {IngredientType.SAUCE, "Соус традиционный галактический", 15},
                {IngredientType.FILLING, "Хрустящие минеральные кольца", 300}
        };
    }

    @Test
    public void getPriceIngredientTest() {
        Ingredient ingredient = new Ingredient(type, name, price);
        float actual = ingredient.getPrice();
        float expected = ingredient.price;
        assertEquals("Цена ингредиента отличается от ожидаемой",
                expected, actual, 0);
    }

    @Test
    public void getNameIngredientTest() {
        Ingredient ingredient = new Ingredient(type, name, price);
        String actual = ingredient.getName();
        String expected = ingredient.name;
        assertEquals("Название ингредиента отличается от ожидаемого",
                expected, actual);
    }

    @Test
    public void getTypeIngredientTest() {
        Ingredient ingredient = new Ingredient(type, name, price);
        IngredientType actual = ingredient.getType();
        IngredientType expected = ingredient.type;
        assertEquals("Тип ингредиента отличается от ожидаемого",
                expected, actual);
    }
}