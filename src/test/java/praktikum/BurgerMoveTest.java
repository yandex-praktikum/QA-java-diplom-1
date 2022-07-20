package praktikum;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.assertEquals;


@RunWith(Parameterized.class)
public class BurgerMoveTest {
    private final int index;
    private final int newIndex;
    private final Ingredient ingredient;
    private static Database db = new Database();
    private Burger burger;

    @Before
    public void init() {
        burger = new Burger();
        for (Ingredient ingredient : db.availableIngredients()) {
            burger.addIngredient(ingredient);
        }
    }

    public BurgerMoveTest(int index, int newIndex, Ingredient ingredient) {
        this.index = index;
        this.newIndex = newIndex;
        this.ingredient = ingredient;
    }

    @Parameterized.Parameters
    public static Object[][] getIndex() {
        int size = db.availableIngredients().size();
        Object[][] testData = new Object[size*size][3];
        int k = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                testData[k][0] = i;
                testData[k][1] = j;
                testData[k][2] = db.availableIngredients().get(i);
                k++;
            }
        }
        return testData;
    }
    // Проверяем метод изменения порядка ингредиентов
    @Test
    public void moveIngredient() {
        burger.moveIngredient(index,newIndex);
        assertEquals(ingredient, burger.ingredients.get(newIndex));
    }
}
