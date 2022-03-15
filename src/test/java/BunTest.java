import org.junit.Test;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

public class BunTest {

    Bun bun = new Bun("Fluorescent bun R2-D3", 988);

    @Test
    public void getNameTest(){
        String actual = bun.getName();
        String expected = "Fluorescent bun R2-D3";
        assertEquals("condition not met", expected, actual);
    }

    @Test
    public void getPriceTest(){
        float actual = bun.getPrice();
        int expected = 988;
        assertEquals(0, expected, actual);
    }
}
