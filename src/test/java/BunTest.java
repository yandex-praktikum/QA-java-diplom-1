import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import praktikum.Bun;

@RunWith(MockitoJUnitRunner.class)
public class BunTest {

    @Mock
    private Bun bun;

    @Test
    public void getNameBunValue() {
        when(bun.getName()).thenReturn("black bun");
        assertEquals("black bun", bun.getName());
    }

    @Test
    public void getPriceBunValue() {
        when(bun.getPrice()).thenReturn(2.5f);
        assertEquals(2.5f, bun.getPrice(), 0.001);
    }

    @Test
    public void getNameAndPriceBunValue() {
        Bun bun = new Bun("black bun", 2.5f);
        assertEquals("black bun", bun.getName());
        assertEquals(2.5f, bun.getPrice(), 0.001);
    }
}
