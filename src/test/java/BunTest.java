import org.junit.Assert;
import org.junit.Test;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

public class BunTest {
    private final Bun bun = new Bun("Чёрствая", 5f);

    @Test
    public void getNamePositiveResult() {
        assertEquals("Не та булочка", "Чёрствая", bun.getName());
    }

    @Test
    public void getPricePositiveResultReturn5f() {
        float expected = 5f;
        Assert.assertEquals("Некорректная цена", expected, bun.getPrice(), 0);
    }
}