package praktikum;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.assertEquals;


@RunWith(Parameterized.class)
public class BurgerRemoveTest {
    private final int index;
    private final Ingredient ingredient;
    private final boolean expected;
    private static Database db = new Database();
    private Burger burger;

    @Before
    public void init() {
        burger = new Burger();
        for (Ingredient ingredient : db.availableIngredients()) {
            burger.addIngredient(ingredient);
        }
    }

    public BurgerRemoveTest(int index, Ingredient ingredient) {
        this.index = index;
        this.ingredient = ingredient;
        this.expected = false;
    }

    @Parameterized.Parameters
    public static Object[][] getIndex() {
        int size = db.availableIngredients().size();
        Object[][] testData = new Object[size][2];
        for (int i = 0; i < size; i++) {
            testData[i][0] = i;
            testData[i][1] = db.availableIngredients().get(i);
        }

        return testData;
    }
    // Проверяем метод удаление ингредиентов
    @Test
    public void removeIngredient() {
        burger.removeIngredient(index);
        assertEquals(expected, burger.ingredients.contains(ingredient));
    }
}











































