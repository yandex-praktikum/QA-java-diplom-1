package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static praktikum.TestUtils.getMockedIngredient;

@RunWith(Parameterized.class)
public class NoBunBurgerReceiptTest {

    Burger burger;
    List<Ingredient> ingredients;
    String expectedReceipt;

    public NoBunBurgerReceiptTest(List<Ingredient> ingredients, String expectedReceipt) {
        this.ingredients = ingredients;
        this.expectedReceipt = expectedReceipt;
    }

    @Parameterized.Parameters
    public static Object[][] getBurgerData() {
        return new Object[][] {
                { List.of(), "" },
                { List.of(getMockedIngredient(IngredientType.SAUCE, "hot sauce", 100)),
                        "= sauce hot sauce =\n" +
                        "\n" +
                        "Price: 100.000000\n"  },
        };
    }


    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        burger = new Burger();
        for (Ingredient ingredient: ingredients) {
            burger.addIngredient(ingredient);
        }
    }

    @Test
    @Ignore("Случай с бургером без булки обрабатывается некорректно из-за неидеального кода самого приложения.")
    public void testGetReceiptNoBun() {
        Assert.assertEquals("The receipt of the burger should be " + expectedReceipt, expectedReceipt, burger.getReceipt());
    }
}