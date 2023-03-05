import praktikum.Bun;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class BunTest {
    @Mock
    Bun bun;
    @Test
    public void getNameReturnBunName() {
        Bun bun = new Bun("wheat", 1);
        String expectedName = "wheat";
        String actualName = bun.getName();
        assertEquals ("Wrong return name", expectedName, actualName);
    }
    @Test
    public void getPriceReturnBunPrice() {
        Bun bun = new Bun("wheat", 1);
        float expectedPrice = 1;
        float actualPrice = bun.getPrice();
        assertEquals("Wrong return price", expectedPrice, actualPrice, 0);
    }
}
