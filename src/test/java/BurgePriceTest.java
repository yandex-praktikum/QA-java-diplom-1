import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class BurgePriceTest {

    Burger burger;
    Ingredient filling;
    Ingredient sauce;
    Bun bun;

    @Before
    public void setUp() {
        burger = new Burger();
        bun = new Bun("black bun", 100);
        filling = new Ingredient(IngredientType.FILLING, "cutlet", 100);
        sauce = new Ingredient(IngredientType.SAUCE, "sour cream", 200);
        burger.addIngredient(sauce);
        burger.addIngredient(filling);
    }

    @Test
    public void shouldGetBurgerPrice() {
        burger.setBuns(bun);
        float expected = 500F;
        float actual = burger.getPrice();
        assertEquals("Цены должны совпадать", expected, actual, 0.01);
    }
}
