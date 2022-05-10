package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.List;

@RunWith(Parameterized.class)
public class GetPriceTest {

    private final int bunIndex;
    private final List<Integer> ingredientsIndex;
    private final int expected;

    public GetPriceTest(int bunIndex, List<Integer> ingredientsIndex, int expected) {
        this.bunIndex = bunIndex;
        this.ingredientsIndex = ingredientsIndex;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Object[][] getPriceData() {
        return new Object[][]{
                {1, Arrays.asList(1, 3, 4), 900},
                {0, Arrays.asList(0, 2, 5, 1), 1100},
                {2, Arrays.asList(3, 4), 900},
        };
    }

    @Test
    public void getBurgerPriceTest() throws Exception {
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

        //Сравнием получившуюся стоимость с ожидаемой
        Assert.assertEquals(Math.round(burger.getPrice()), expected);
    }
}
