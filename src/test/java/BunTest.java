import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;
import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class BunTest {

    private final Bun bunValue;
    private final String bunName;
    private final String bunNameError;
    private final float bunPrice;
    private final float bunPriceError;

    public BunTest(Bun bunValue, String bunName, String bunNameError, float bunPrice, float bunPriceError) {
        this.bunValue = bunValue;
        this.bunName = bunName;
        this.bunNameError = bunNameError;
        this.bunPrice = bunPrice;
        this.bunPriceError = bunPriceError;
    }

    @Parameterized.Parameters
    public static Object[][] getValue() {
        return new Object[][] {
                {new Bun("black bun", 100), "black bun", "gray bun", 100, 150},
                {new Bun("white bun", 200), "white bun", "gray bun", 200, 150},
                {new Bun("red bun", 300), "red bun", "gray bun", 300, 150},
                {new Bun("gray bun", 60000), "gray bun", "blue bun", 60000, 150},
        };
    }

    @Test
    public void getNameReturn(){
        String actualName = bunValue.getName();
        assertEquals(bunName,actualName);
    }

    @Test
    public void getNameNotReturn(){
        String actualName = bunValue.getName();
        assertNotEquals(bunNameError,actualName);
    }

    @Test
    public void getPriceReturn(){
        float actualPrice = bunValue.getPrice();
        assertEquals(bunPrice,actualPrice,0);
    }

    @Test
    public void getPriceNotReturn(){
        float actualPrice = bunValue.getPrice();
        assertNotEquals(bunPriceError,actualPrice,0);
    }
}