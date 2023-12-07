package praktikum;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BunTest {
    private final String NAME_BUN = "blackBun";
    private final float PRICE_BUN = 1.16f;
    private Bun bun;

    @Before
    public void setup() {
        bun = new Bun(NAME_BUN, PRICE_BUN);
    }

    @Test
    public void checkReturnValueName() {
        Assert.assertEquals("Наименование булочки некорректное", NAME_BUN, bun.getName());
    }

    @Test
    public void checkReturnValuePrice() {
        Assert.assertEquals("Цена за булочку некорректная", PRICE_BUN, bun.getPrice(), 0);
    }
}
