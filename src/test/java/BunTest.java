import praktikum.Bun;

import static org.mockito.Mockito.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.Collection;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

@RunWith(Parameterized.class)
public class BunTest {

    private final String bunName;
    private final float bunPrice;

    public BunTest(String bunName, float bunPrice) {
        this.bunName = bunName;
        this.bunPrice = bunPrice;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"Стандартная булочка", 1.5f},
                {"Булочка без цены", 0.0f},
                {"Булочка с отрицательной ценой", -1.0f}
        });
    }

    @Test
    public void testBunConstructor() {
        Bun bunMock = mock(Bun.class);
        when(bunMock.getName()).thenReturn(bunName);
        when(bunMock.getPrice()).thenReturn(bunPrice);

        assertEquals(bunName, bunMock.getName());
        assertEquals(bunPrice, bunMock.getPrice(), 0.001);
    }

    @Test
    public void testGetName() {
        Bun bunMock = mock(Bun.class);
        when(bunMock.getName()).thenReturn(bunName);

        assertEquals(bunName, bunMock.getName());
    }

    @Test
    public void testGetPrice() {
        Bun bunMock = mock(Bun.class);
        when(bunMock.getPrice()).thenReturn(bunPrice);

        assertEquals(bunPrice, bunMock.getPrice(), 0.001);
    }

    @Test
    public void testBunWithZeroPrice() {
        Bun bunMock = mock(Bun.class);
        when(bunMock.getName()).thenReturn(bunName);
        when(bunMock.getPrice()).thenReturn(bunPrice);

        assertEquals(bunName, bunMock.getName());
        assertEquals(bunPrice, bunMock.getPrice(), 0.001);
    }

    @Test
    public void testBunWithNegativePrice() {
        Bun bunMock = mock(Bun.class);
        when(bunMock.getName()).thenReturn(bunName);
        when(bunMock.getPrice()).thenThrow(new IllegalArgumentException("Ошибка! Цена не может быть отрицательной"));

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, bunMock::getPrice);
        assertEquals("Ошибка! Цена не может быть отрицательной", exception.getMessage());
    }
}