import org.junit.Assert;
import org.junit.Test;
import praktikum.Bun;

public class BunTest {
    @Test
    public void createInstanceBunAndCheckMethodsPositiveTest() {
        Bun bun = new Bun("Булочка с маком", 22);
        String actualName = bun.getName();
        Assert.assertEquals("Булочка с маком", actualName);

        float actualPrice = bun.getPrice();
        Assert.assertEquals(22, actualPrice, 0.0f);
    }
}
