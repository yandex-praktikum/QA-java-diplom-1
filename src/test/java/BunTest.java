
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;


@RunWith(MockitoJUnitRunner.class)
public class BunTest {


    @Test
    public void getNameTest() {
        Bun bun = new Bun("bulka", 100);
        String expected = "bulka";
        String actual = bun.getName();
        Assert.assertEquals("Incorrect BunName", expected, actual);

    }

    @Test
    public void getPriceTest() {
        Bun bun = new Bun("bulka", 100);
        float expected = 100;
        float actual = bun.getPrice();
        Assert.assertEquals("Incorrect BunPrice", expected, actual, 0);
    }
}
