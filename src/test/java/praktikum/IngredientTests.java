package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTests {

    private final IngredientType type;
    private final String name;
    private final float price;
    Ingredient ingredient;

    public IngredientTests(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
        ingredient = new Ingredient(type, name, price);
    }

    @Parameterized.Parameters
    public static Object[][] setIngredients() {
        return new Object[][]{
                {IngredientType.SAUCE, "Coус Spicy-X", 90},
                {IngredientType.FILLING, "Хрустящие минеральные кольца", 300.5F},
                {IngredientType.FILLING, "Щупальца Ктулху в кляре", 255.25F}
        };
    }

    //Проверим, то метод gerPrice возвращает правильную цену ингредиента
    @Test
    public void testIngredientGetPrice() {
        assertEquals("Ингредиент бесценен!", price, ingredient.getPrice(), 0.005);
    }

    //Проверим, что метод getName возвращает правильное название игредиента
    @Test
    public void testIngredientGetName() {
        assertEquals("Безымянный ингредиент!", name, ingredient.getName());
    }

    //Проверим, что метод getType возвращает правильный тип ингредиента
    @Test
    public void testIngredientGetType() {
        assertEquals("Нетипичный ингредиент!", type, ingredient.getType());
    }
}
