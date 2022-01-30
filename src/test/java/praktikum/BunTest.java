package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static junit.framework.TestCase.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class BunTest {

    @Test
    public void getPriceReturnsBurgerPriceTest() {

        Bun bun = new Bun("white bun", 200);
        float actualPrice = bun.getPrice();
        float expectedPrice = 200;

        assertEquals("Ожидаемая цена " + expectedPrice + ". Фактическая " + actualPrice,
                expectedPrice, actualPrice);
    }

    @Test
    public void getNameReturnsBurgerNameTest() {

        Bun bun = new Bun("black bun", 100);
        String actualName = bun.getName();
        String expectedName = "black bun";

        assertEquals("Ожидаемое название булочки " + expectedName + ". Фактическое " + actualName,
                actualName, expectedName);
    }

}
