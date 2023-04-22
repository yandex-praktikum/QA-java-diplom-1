import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;


public class BunTest {
    private Bun bun;

    @Before
    public void setUp() {
        bun = new Bun("black bun", 100);
    }

    @Test
    public void shouldReturnCorrectName() {
        String actual = "black bun";
        String expected = bun.getName();
        assertEquals("Метод вернул некорректное имя", actual, expected);

    }

    @Test
    public void shouldReturnCorrectPrice() {
        float actual = 100;
        float expected = bun.getPrice();
        assertEquals("Метод вернул некорректную цену", actual, expected, 0);
    }
}
