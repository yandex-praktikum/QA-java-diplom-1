import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class BunTest {

    final int DELTA = 3;
    @Test
    public void getNameBun() {
        Bun bun = new Bun("Black", 100);
        String actual = bun.getName();
        String expected = "Black";
        assertEquals(expected, actual);
    }

    @Test
    public void getPriceBun() {
        Bun bun = new Bun("Black", 100);
        float actual = bun.getPrice();
        float expected = 100;
        assertEquals(actual, expected, DELTA );
    }

}
