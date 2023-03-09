package praktikum;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BurgerParameterizedTest extends BaseTest {

    Bun bun;
    List<Ingredient> ingredients;

    public BurgerParameterizedTest(String name, Bun bun, List<Ingredient> ingredients) {
        this.bun = bun;
        this.ingredients = ingredients;
    }

    @Parameterized.Parameters(name = "Ингридиенты: {0}")
    public static Object[][] getKittensData() {
        return new Object[][]{
                {
                        "бургер с одним ингридиентом",
                        new Bun(RandomStringUtils.randomAlphabetic(8), RandomUtils.nextFloat()),
                        List.of(
                                new Ingredient(IngredientType.FILLING, RandomStringUtils.randomAlphabetic(8), RandomUtils.nextFloat())
                        ),

                },
                {
                        "бургер с несколькими ингридиентами",
                        new Bun(RandomStringUtils.randomAlphabetic(8), RandomUtils.nextFloat()),
                        List.of(
                                new Ingredient(IngredientType.FILLING, RandomStringUtils.randomAlphabetic(8), RandomUtils.nextFloat()),
                                new Ingredient(IngredientType.SAUCE, RandomStringUtils.randomAlphabetic(8), RandomUtils.nextFloat())
                        ),

                }
        };
    }

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void getReceipt() {
        StringBuilder expected = new StringBuilder();

        Burger burger = new Burger();
        burger.setBuns(bun);

        expected.append(String.format("(==== %s ====)%n", bun.getName()));

        for (Ingredient ingredient :
                ingredients) {
            burger.addIngredient(ingredient);
            expected.append(String.format("= %s %s =%n", ingredient.getType().name().toLowerCase(), ingredient.getName()));
        }

        expected.append(String.format("(==== %s ====)%n", bun.getName()));
        expected.append(String.format("%nPrice: %f%n", burger.getPrice()));

        assertEquals("Неверный чек", expected.toString(), burger.getReceipt());
    }
}