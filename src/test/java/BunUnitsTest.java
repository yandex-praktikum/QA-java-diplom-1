import org.junit.Test;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

public class BunUnitsTest {
    Bun bun = new Bun("Piska", 7000.0F);
    @Test
    public void getName() throws Exception {
        String expected = bun.getName();
        String actual = "Piska";
        assertEquals(expected, actual);
        //return expected;
    }

    @Test
    public void getPrice() throws Exception {
        float expected = bun.getPrice();
        float actual = 7000.0F;
        double delta = 0.1F;
        assertEquals(expected, actual, delta);
        //return expected;
    }


    }
