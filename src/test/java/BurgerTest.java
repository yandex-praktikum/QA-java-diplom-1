import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;
import praktikum.Burger;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BurgerTest {
    Burger burger;

    final String bunName = "fluorescent bun";
    final float bunPrice = 988;


    public Bun getMockedBun(String name, float price) {
        Bun bun = mock(Bun.class);
        when(bun.getName()).thenReturn(name);
        when(bun.getPrice()).thenReturn(price);
        return bun;
    }

    @Before
    public void setUp() {
        burger = new Burger();
    }

    @Test
    public void setBunTest() {
        Bun expected = getMockedBun (bunName, bunPrice);
        burger.setBuns(expected);
        Assert.assertEquals(expected, burger.bun);
    }

}