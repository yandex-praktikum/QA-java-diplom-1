import org.junit.Assert;
import org.junit.Test;
import praktikum.Bun;

public class BunTest {
    Bun bun;
    private final String bunName = "Bulochka";
    private final float bunPrice = 90.94f;

    @Test
    public void bunGetsProperName() {
        Bun bun = new Bun(bunName, bunPrice);
        Assert.assertEquals("Название булочки не соответствует ожидаемому", bunName, bun.getName());
    }

    @Test
    public void bunGetsProperPrice() {
        Bun bun = new Bun(bunName,bunPrice);
        Assert.assertEquals("Стоимость булочки не соответствует ожидаемой", bunPrice, bun.getPrice(), 0.00f);
    }
}