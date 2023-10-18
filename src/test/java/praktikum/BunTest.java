package praktikum;

import com.sun.source.tree.AssertTree;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static praktikum.constants.Constants.*;


@RunWith(MockitoJUnitRunner.class)
public class BunTest {

    private Bun bun = new Bun(BUN_NAME, BUN_PRICE);

    @Test
    public void getNameSuccess() {
        assertEquals(
                BUN_NAME,
                bun.getName());
    }

    @Test
    public void getPriceSuccess()  {
        Assert.assertTrue(Math.abs(bun.getPrice()- BUN_PRICE) <= 0.00001);
    }
}
