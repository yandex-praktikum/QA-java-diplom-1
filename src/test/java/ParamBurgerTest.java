import org.hamcrest.MatcherAssert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.containsString;

@RunWith(Parameterized.class)
public class ParamBurgerTest {

    @Spy
    private final Bun bun;
    @Spy
    private final Ingredient ingredient;
    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    public ParamBurgerTest(Bun bun, Ingredient ingredient) {
        this.bun = bun;
        this.ingredient = ingredient;
    }

    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][]{
                {new Bun("Картон", 0f), new Ingredient(IngredientType.SAUCE, "Кепчук", 50)},
                {new Bun("Хлеб", 5f), new Ingredient(IngredientType.SAUCE, "Мазик", 5.5f)},
                {new Bun("Камень", 5.5f), new Ingredient(IngredientType.FILLING, "Жижа", 5)},
                {new Bun("Лаваш", 50f), new Ingredient(IngredientType.FILLING, "Воск", 0)},
        };
    }

    @Test
    public void whenCallGetReceiptThenReturnReceipt() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);

        String actual = burger.getReceipt();

        MatcherAssert.assertThat(actual, allOf(
                containsString(bun.getName()),
                containsString(ingredient.getName()),
                containsString(ingredient.getType().toString().toLowerCase())));
    }
}