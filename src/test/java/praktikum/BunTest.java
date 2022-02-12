package praktikum;

import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.assertEquals;

public class BunTest {

    @Mock
    float priceMock;
    String nameMock;

    @Test
    public void getNameEqualsBlack() {
        String name = "Black";
        Bun bun = new Bun(name, priceMock);

        String actualName = bun.getName();
        String expectedName = "Black";
        assertEquals(expectedName, actualName);
    }

    @Test
    public void getPriceEqualsFive() {
        float price = 5;
        Bun bun = new Bun(nameMock, price);

        float actualPrice = bun.getPrice();
        float expectedPrice = 5;
        assertEquals(expectedPrice, actualPrice, 0);
    }
}
