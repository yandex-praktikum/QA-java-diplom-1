package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;
import static org.junit.Assert.assertEquals;


@RunWith(Parameterized.class)
public class BurgerGetPriceTest {
    Burger burger = new Burger();
    private Bun bun = Mockito.mock(Bun.class);
    private Ingredient filling = Mockito.mock(Ingredient.class);
    private Ingredient sauce = Mockito.mock(Ingredient.class);

    private float bunPrice;
    private float fillingPrice;
    private float saucePrice;
    private float expectedSumPrice;

    public BurgerGetPriceTest(float bunPrice, float fillingPrice, float saucePrice, float expectedSumPrice) {
        this.bunPrice = bunPrice;
        this.fillingPrice = fillingPrice;
        this.saucePrice = saucePrice;
        this.expectedSumPrice = expectedSumPrice;
    }

    private Burger cookBurger() {
        burger.setBuns(bun);
        burger.addIngredient(filling);
        burger.addIngredient(sauce);
        Mockito.when(bun.getPrice()).thenReturn(bunPrice);
        Mockito.when(filling.getPrice()).thenReturn(fillingPrice);
        Mockito.when(sauce.getPrice()).thenReturn(saucePrice);
        return burger;
    }

    @Parameterized.Parameters
    public static Object[] testData(){
        return new Object[][] {
                {0f, 0f, 0f, 0f},
                {1f, 1f, 1f, 4f},
                {-1f, 1f, 1f, 0f},
        };
    }

    @Test
    public void getPrice() {
        cookBurger();
        assertEquals(expectedSumPrice, burger.getPrice(),0);
    }
}