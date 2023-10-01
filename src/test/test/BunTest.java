import org.junit.Assert;
import org.junit.Test;
import praktikum.Bun;

public class BunTest {

    private static final String expectedName = "Булочка с кунжутом";

    private static final float expectedPrice = 25.0f;

    private static final float testDelta = 0.0f;

    private static final Bun bun = new Bun(expectedName, expectedPrice);

    @Test
    public void getName() {
        Assert.assertEquals(expectedName, bun.getName());
    }

    @Test
    public void getPrice() {
        Assert.assertEquals(expectedPrice, bun.getPrice(), testDelta);
    }
}
