package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.List;

@RunWith(Parameterized.class)
public class GetReceiptTest {

    private final int bunIndex;
    private final List<Integer> ingredientsIndex;
    private final String expected;

    public GetReceiptTest(int bunIndex, List<Integer> ingredientsIndex, String expected) {
        this.bunIndex = bunIndex;
        this.ingredientsIndex = ingredientsIndex;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Object[][] getPriceData() {
        return new Object[][]{
                {1, Arrays.asList(1, 3, 4), "(==== white bun ====)\r\n" +
                        "= sauce sour cream =\r\n" +
                        "= filling cutlet =\r\n" +
                        "= filling dinosaur =\r\n" +
                        "(==== white bun ====)\r\n" +
                        "\r\n" +
                        "Price: 900,000000\r\n"},
                {0, Arrays.asList(0, 2, 5, 1), "(==== black bun ====)\r\n" +
                        "= sauce hot sauce =\r\n" +
                        "= sauce chili sauce =\r\n" +
                        "= filling sausage =\r\n" +
                        "= sauce sour cream =\r\n" +
                        "(==== black bun ====)\r\n" +
                        "\r\n" +
                        "Price: 1100,000000\r\n"},
                {2, Arrays.asList(3, 5), "(==== red bun ====)\r\n" +
                        "= filling cutlet =\r\n" +
                        "= filling sausage =\r\n" +
                        "(==== red bun ====)\r\n" +
                        "\r\n" +
                        "Price: 1000,000000\r\n"},
        };
    }

    @Test
    public void getReceiptTest() throws Exception {
        Database database = new Database();
        // Считаем список доступных булок из базы данных
        List<Bun> buns = database.availableBuns();

        // Считаем список доступных ингредиентов из базы данных
        List<Ingredient> ingredients = database.availableIngredients();

        Burger burger = new Burger();
        burger.setBuns(buns.get(bunIndex));

        //Добавляем необходимые ингридиенты в бургер
        for (int ingredientIndex : ingredientsIndex) {
            burger.addIngredient(ingredients.get(ingredientIndex));
        }

        //Сравнием получившийся чек заказа с ожидаемым
        Assert.assertEquals(burger.getReceipt(), expected);
    }
}
