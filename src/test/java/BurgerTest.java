import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;
import static praktikum.IngredientType.SAUCE;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {





    @Mock
    private Bun bun;

    @Mock
    private Ingredient ingredient;

    @Mock
    private Burger burger;


    @Test
    public void getPriceTest() {
        Mockito.when(bun.getPrice()).thenReturn(200f);
        Mockito.when(ingredient.getPrice()).thenReturn(300f);
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        float expected = 700f;
        assertEquals(expected, burger.getPrice(), 0.0f);
    }

}
