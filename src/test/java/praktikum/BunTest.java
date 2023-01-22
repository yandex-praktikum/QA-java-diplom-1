package praktikum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import static org.junit.Assert.assertEquals;


@RunWith(MockitoJUnitRunner.class)
public class BunTest {

    @Mock
    Bun bun;

    @Test
    public void testGetName() {
        Bun bun = new Bun("black bun", 1f);
        assertEquals("black bun", bun.getName());
    }

    @Test
    public void testGetPrice() {
        Bun bun = new Bun("black bun", 1f);
        assertEquals(1f, bun.getPrice(), 0);
    }

}
