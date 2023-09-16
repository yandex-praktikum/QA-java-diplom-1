import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class BunTest {

    @Test
    public void getNameTest() {
        String expectedName = "Bun";
        float mockPrice = 2.0f;
        Bun bun = new Bun(expectedName, mockPrice);

        String actualName = bun.getName();

        assertEquals(expectedName, actualName);
    }

    @Test
    public void getPriceTest() {
        String mockName = "Bun";
        float expectedPrice = 2.0f;
        Bun bun = new Bun(mockName, expectedPrice);

        float actualPrice = bun.getPrice();

        assertEquals(expectedPrice, actualPrice, 0.001f);
    }
}
