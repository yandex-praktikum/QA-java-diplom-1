import org.junit.Test;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

public class BunTest {

    String bunName = "Булка с корицей";
    float bunPrice = 134.44f;
    Bun bun = new Bun(bunName, bunPrice);

    @Test
    public void getNameTest(){
        assertEquals(bunName, bun.getName());
    }

    @Test
    public void getPriceTest(){
        assertEquals(bunPrice, bun.getPrice(), 0);
    }
}
