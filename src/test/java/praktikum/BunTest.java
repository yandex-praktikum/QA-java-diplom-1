package praktikum;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class BunTest {
    Bun bun = new Bun ("Обычная", 50);

    @Test
    public void getNameTest(){
        String expected = "Обычная";
        String actual = bun.getName();
        assertEquals(expected, actual);
    }
    @Test
    public void getPriceTest(){
        float expected = 50;
        float actual = bun.getPrice();
        assertEquals(expected, actual, 0.001);
    }
}