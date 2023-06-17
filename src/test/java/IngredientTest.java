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
public class IngredientTest {

    private final String name;
    private final float price;
    private Ingredient ingredient;
    private final IngredientType type;

    public IngredientTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters(name = "Вариант: {0} {1}")
    public static Object[][] getData() {
        return new Object[][]{
                {SAUCE, "Spicy-X", 1},
                {SAUCE, "Space Sauce", 2},
                {SAUCE, "Традиционный галактический", 3},
                {SAUCE, "Соус с шипами Антарианского плоскоходца", 4},
                {FILLING, "Мясо бессмертных моллюсков Protostomia", 1},
                {FILLING, "Говяжий метеорит (отбивная)", 2},
                {FILLING, "Плоды Фалленианского дерева", 3},
                {FILLING, "Сыр с астероидной плесенью", 4}
        };
    }

    @Before
    public void testStart() {
        ingredient = new Ingredient(type, name, price);
    }

    @Test
    public void testType() {
        Assert.assertEquals(type, ingredient.getType());
    }

    @Test
    public void testName() {
        Assert.assertEquals(name, ingredient.getName());
    }

    @Test
    public void testPrice() {
        Assert.assertEquals(price, ingredient.getPrice(), 0.0);
    }

}