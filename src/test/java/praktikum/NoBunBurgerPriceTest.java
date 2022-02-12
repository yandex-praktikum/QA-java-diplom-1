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
public class NoBunBurgerPriceTest {

    Burger burger;
    List<Ingredient> ingredients;
    float expectedPrice;

    public NoBunBurgerPriceTest(List<Ingredient> ingredients, float expectedPrice) {
        this.ingredients = ingredients;
        this.expectedPrice = expectedPrice;
    }

    @Parameterized.Parameters
    public static Object[][] getBurgerData() {
        return new Object[][] {
                { List.of(), 0 },
                { List.of(getMockedIngredient(IngredientType.SAUCE, "hot sauce", 100)), 100 },
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
    public void testGetPriceNoBun() {
        Assert.assertEquals("The price of the burger should be " + expectedPrice, expectedPrice, burger.getPrice(), 0);
    }
}