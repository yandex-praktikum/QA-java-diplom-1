import org.junit.Assert;
import org.junit.Test;
import praktikum.Bun;

public class BunTest {
    @Test
    public void getNameReturnsBunName() {
        Bun bun = new Bun("black bun", 100);
        String actual = bun.getName();
        Assert.assertEquals("Не отображается корректное имя булочки", "black bun", actual);
    }

    @Test
    public void getPriceReturnsBunPrice() {
        Bun bun = new Bun("black bun", 100.01f);
        float actual = bun.getPrice();
        Assert.assertEquals("Не отображается корректная цена булочки", 100.01f, actual, 0);
    }}
