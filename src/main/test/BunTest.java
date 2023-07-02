import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class BunTest {

    Bun bun;

    @Before
    public void init() {
        bun = new Bun("Булка", 228);
    }

    @Test
    public void getNameTest(){
        assertEquals("Булка", bun.getName());
    }

    @Test
    public void getPriceTest() {
        assertEquals(228, bun.getPrice(), 0);
    }
}
