import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

@RunWith(MockitoJUnitRunner.class)
public class BurgerReceiptTest {

    Ingredient filling;
    Ingredient sauce;

    Bun bun;
    @Spy
    Burger burgerSpy;

    @Before
    public void setUp() {
        burgerSpy = spy(Burger.class);
        bun = new Bun("black bun", 100);
        filling = new Ingredient(IngredientType.FILLING, "cutlet", 100);
        sauce = new Ingredient(IngredientType.SAUCE, "sour cream", 200);
        burgerSpy.addIngredient(sauce);
        burgerSpy.addIngredient(filling);
    }

    @Test
    public void getReceiptBunSauceFillingTrue() {
        burgerSpy.setBuns(bun);
        doReturn(500F).when(burgerSpy).getPrice();
        String expected = "(==== black bun ====)\r\n= sauce sour cream =" + "\r\n= filling cutlet =\r\n(==== black bun ====)\r\n\r\nPrice: 500,000000\r\n";
        String actual = burgerSpy.getReceipt();
        assertEquals("Рецепты должны совпадать", expected, actual);
    }
}