import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import praktikum.Bun;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
public class BunTest {
    private static final float DELTA = 0.001f;
    @Mock
    private Bun mockBun;
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }
    @Test
    public void testGetName() {
        // Настраиваем мок-объект на возвращение значения "Простая булочка" при вызове метода getName()
        when(mockBun.getName()).thenReturn("Простая булочка");
        assertEquals("Простая булочка", mockBun.getName());
    }
    @Test
    public void testGetPrice() {
        // Настраиваем мок-объект на возвращение значения 2.5 при вызове метода getPrice()
        when(mockBun.getPrice()).thenReturn(2.5f);
        assertEquals(2.5f, mockBun.getPrice(), DELTA);
    }
    @Test
    public void testConstructor() {
        // Создаем объект Bun с заданными значениями
        Bun bun = new Bun("Хлебная булка", 3.0f);
        assertEquals("Хлебная булка", bun.getName());
        assertEquals(3.0f, bun.getPrice(), DELTA);
    }
}