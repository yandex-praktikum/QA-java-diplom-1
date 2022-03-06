import org.junit.Assert;
import org.junit.Test;
import praktikum.Bun;

public class BunTest {

    private String bunName = "Булочка";
    private float bunPrice = 50.5F;

    @Test
    public void shouldGetBunName() {
        Bun bun = new Bun(bunName, bunPrice);
        Assert.assertEquals(bunName, bun.getName());
    }

    @Test
    public void shouldGetBunPrice() {
        Bun bun = new Bun(bunName, bunPrice);
        Assert.assertEquals(bunPrice, bun.getPrice(), 0);
    }

}
