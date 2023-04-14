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
    public void bunTestNegativePrice() {
        bun = new Bun(BUN_NAME, -1.0f);
    }
    @Test
    public void bunTestZeroPrice() {
        bun = new Bun(BUN_NAME, 0.0f);
    }
    @Test
    public void bunTestMinPositivePrice() {
        bun = new Bun(BUN_NAME, Float.MIN_VALUE);
        assertEquals("Incorrect price", Float.MIN_VALUE, bun.getPrice(), 0.0001);
    }
    @Test
    public void bunTestMaxPositivePrice() {
        bun = new Bun(BUN_NAME, Float.MAX_VALUE);
        assertEquals("Incorrect price", Float.MAX_VALUE, bun.getPrice(), 0.0001);
    }
    @Test
    public void bunTestNullName() {
        bun = new Bun(null, BUN_PRICE);
    }
    @Test
    public void bunTestEmptyName() {
        bun = new Bun("", BUN_PRICE);
        assertEquals("Incorrect name", "", bun.getName());
    }
    @Test
    public void bunTestLongName() {
        String longName = "A";
        for (int i = 0; i < 1000; i++) {
            longName += "a";
        }
        bun = new Bun(longName, BUN_PRICE);
        assertEquals("Incorrect name length", 1001, bun.getName().length());
    }
    @Test
    public void bunTestSpecialCharName() {
        bun = new Bun("!@#$%^*&^(*", BUN_PRICE);
        assertEquals("Incorrect name", "!@#$%^*&^(*", bun.getName());
    }

    @Test
    public void bunTestPrice() {
        assertThat("Incorrect price!", bun.getPrice(), is(BUN_PRICE));
    }
}
