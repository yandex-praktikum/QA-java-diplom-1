import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    public Burger burger;
    private final float BUN_PRICE = 18.4f;
    private final float INGREDIENT_PRICE = 7.6f;

    @Mock
    Bun bun1;

    @Mock
    Ingredient ingredient1;

    @Before
    public void setUp() {
        burger = new Burger();
        burger.setBuns(bun1);
        burger.addIngredient(ingredient1);
    }

    @Test
    public void getPriceTest() {
        Mockito.when(bun1.getPrice()).thenReturn(BUN_PRICE);
        Mockito.when(ingredient1.getPrice()).thenReturn(INGREDIENT_PRICE);
        assertEquals(BUN_PRICE * 2 + INGREDIENT_PRICE, burger.getPrice(), 0.0001);
    }

    @Test
    public void getReceiptTest() {
    }
}
