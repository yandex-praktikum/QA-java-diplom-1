import org.junit.Test;
import praktikum.Bun;
import static org.junit.Assert.*;

public class BunTest {

    private Bun bun = new Bun("Black bun", 150.00f);


    @Test
    public void getNameReturnsRightName(){
        String actualResult = bun.getName();
        assertEquals("Black bun", actualResult);
    }

    @Test
    public void getPriceReturnsRightPrice(){
        float actualResult = bun.getPrice();
        assertEquals(150, actualResult, 0);
    }
}
