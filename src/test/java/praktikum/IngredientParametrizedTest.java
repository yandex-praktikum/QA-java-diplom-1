package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientParametrizedTest {
    private Ingredient ingredient;
    @Before
    public void createNewInstance() {
        ingredient = new Ingredient(IngredientType.SAUCE, "Соус традиционный галактический", 15.0f);
    }
    private final IngredientType type;
    private final String name;
    private final float price;

    public IngredientParametrizedTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }
    @Parameterized.Parameters(name = "{index} : type = {0}")
    public static Object[][] getIngredientData() {
        return new Object[][] {
                {IngredientType.SAUCE, "Соус с шипами Антарианского плоскоходца", 88.0f},
                {IngredientType.FILLING, "Говяжий метеорит (отбивная)", 3000.0f},
                {IngredientType.SAUCE, "Соус Spicy-X", 90.0f}
        };
    }

    @Test
    public void getType() {
        Ingredient ingredient = new Ingredient(type, name, price);
        IngredientType actual = ingredient.getType();

        assertEquals("Проверка ингредиентов", type, actual);
    }
}