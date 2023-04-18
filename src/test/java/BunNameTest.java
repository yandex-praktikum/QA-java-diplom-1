import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;


@RunWith(Parameterized.class)
public class BunNameTest {
    private Bun bun;
    private final String name;

    public BunNameTest(String name) {
        this.name = name;

    }

    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][] {
                {""},
                {null},
                {"veryLongStringVeryLongStringVeryLongStringVeryLongStringVeryLongString"},
                {"`()!@#$%^&*[]{}|;:',./.,?><"},
        };
    }

    @Test
    public void getNameReturnsCorrectValue() {
        bun = new Bun(name, 20.00f);
        Assert.assertEquals(name, bun.getName());
    }
}
