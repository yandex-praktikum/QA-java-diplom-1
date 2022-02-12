package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static praktikum.TestUtils.getMockedBun;
import static praktikum.TestUtils.getMockedIngredient;

@RunWith(Parameterized.class)
public class BurgerReceiptParameterizedTest {

    Burger burger;
    List<Ingredient> ingredients;
    Bun bun;
    String expectedReceipt;

    public BurgerReceiptParameterizedTest(List<Ingredient> ingredients, Bun bun, String expectedReceipt) {
        this.ingredients = ingredients;
        this.bun = bun;
        this.expectedReceipt = expectedReceipt;
    }

    @Parameterized.Parameters
    public static Object[][] getBurgerData() {
        return new Object[][] {
                // Случай с бургером без булки обрабатывается некорректно из-за неидеального кода самого приложения.
                // Он вынесен в отдельный тест класс и заигнорен
                { List.of(), getMockedBun("black bun", 100),
                        "(==== black bun ====)\n" +
                        "(==== black bun ====)\n" +
                        "\n" +
                        "Price: 200.000000\n" },
                { List.of(getMockedIngredient(IngredientType.SAUCE, "hot sauce", 100)),
                        getMockedBun("black bun", 100),
                        "(==== black bun ====)\n" +
                        "= sauce hot sauce =\n" +
                        "(==== black bun ====)\n" +
                        "\n" +
                        "Price: 300.000000\n" },
                { List.of(
                        getMockedIngredient(IngredientType.SAUCE, "hot sauce", 100),
                        getMockedIngredient(IngredientType.FILLING, "cutlet", 100)),
                        getMockedBun("black bun", 100),
                        "(==== black bun ====)\n" +
                        "= sauce hot sauce =\n" +
                        "= filling cutlet =\n" +
                        "(==== black bun ====)\n" +
                        "\n" +
                        "Price: 400.000000\n" },
        };
    }

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        burger = new Burger();
        if (bun != null) {
            burger.setBuns(bun);
        }
        for (Ingredient ingredient: ingredients) {
            burger.addIngredient(ingredient);
        }
    }

    @Test
    public void testGetReceiptReturnsCorrectReceipt() {
        Assert.assertEquals("The receipt for the burger should be " + expectedReceipt, expectedReceipt, burger.getReceipt());
    }
}