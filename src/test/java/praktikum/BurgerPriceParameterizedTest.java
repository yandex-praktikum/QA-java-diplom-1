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
public class BurgerPriceParameterizedTest {

    Burger burger;
    List<Ingredient> ingredients;
    Bun bun;
    float expectedPrice;

    public BurgerPriceParameterizedTest(List<Ingredient> ingredients, Bun bun, float expectedPrice) {
        this.ingredients = ingredients;
        this.bun = bun;
        this.expectedPrice = expectedPrice;
    }

    @Parameterized.Parameters
    public static Object[][] getBurgerData() {
        return new Object[][] {
                // Случай с бургером без булки обрабатывается некорректно из-за неидеального кода самого приложения.
                // Он вынесен в отдельный тест класс и заигнорен
                { List.of(), getMockedBun("black bun", 100), 200 },
                { List.of(getMockedIngredient(IngredientType.SAUCE, "hot sauce", 100)),
                        getMockedBun("black bun", 100), 300 },
                { List.of(
                        getMockedIngredient(IngredientType.SAUCE, "hot sauce", 100),
                        getMockedIngredient(IngredientType.FILLING, "cutlet", 100)),
                        getMockedBun("black bun", 100), 400 },
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
    public void testGetPriceReturnsCorrectPrice() {
        Assert.assertEquals("The price of the burger should be " + expectedPrice, expectedPrice, burger.getPrice(), 0);
    }
}