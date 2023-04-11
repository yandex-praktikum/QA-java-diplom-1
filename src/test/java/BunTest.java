import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class BunTest {
    private  Bun bun;
    private static final String BUN_NAME = "Краторная булка N-200i";
    private static final float BUN_PRICE = 200.0f;


    @Before
    public void bunInfo() {
        bun = new Bun(BUN_NAME, BUN_PRICE);
    }


    @Test
    public void bunTestName() {
        assertEquals("Incorrect bun name", BUN_NAME, bun.getName());

    }
    @Test
    public void bunTestPrice() {
        assertThat("Incorrect price!", bun.getPrice(), is(BUN_PRICE));
    }
}
