import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;

public class BunTest {
    private Bun bun;

    @Before
    public void setBun(){
        bun = new Bun("Кунжутная", 50);
    }

    @Test
    public void getNameBunName(){
        Assert.assertEquals("Такой булочки нет", "Кунжутная", bun.getName());
    }

    @Test
    public void getPriceReturnBunPrice(){
        Assert.assertEquals("Неверная цена булочки", 50, bun.getPrice(), 0);
    }
}
