import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class BunTest {
    @Mock
    Bun bun;

    @Test
    public void testgetName() {
        Bun bun = new Bun("red bun", 300);
        String actual = bun.getName();
        assertEquals("red bun", bun.getName());

    }
    @Test
    public void testgetPrice() {
        Bun bun = new Bun("red bun", 300);
       float actual = bun.getPrice();
        assertEquals(300, bun.getPrice(),1);
    }
}