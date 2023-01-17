import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;

public class BunTest {
    Bun bun;

    final String bunName = "fluorescent bun";
    final int bunPrice = 988;

    @Before
    public void setUp() {
        bun = new Bun(bunName, bunPrice);
    }

    @Test
    public void getNameBunTest() {
        String actualBunName = "fluorescent bun";
        String expectedBunName = bun.getName();
        Assert.assertEquals("Expected bun name - fluorescent bun", expectedBunName, actualBunName);
    }
}