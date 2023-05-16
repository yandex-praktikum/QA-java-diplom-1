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
    public void nameGetBunTest() {
        String name = "Пшеничная";
        Bun bun = new Bun(name, 0);
        assertEquals("Названия должны быть равны",name, bun.getName());
    }

    @Test
    public void priceGetBunTest() {
        float price = 2.99f;
        Bun bun = new Bun("name", price);
        assertEquals("Цена должна быть равна",price, bun.getPrice(), 0);
    }
}
