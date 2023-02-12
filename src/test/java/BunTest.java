import org.junit.Test;
import praktikum.Bun;

import java.util.Random;

import static org.junit.Assert.assertEquals;

public class BunTest {
    private final String testName = "testName";
    private final float testPrice = new Random().nextFloat();
    private final Bun bun = new Bun(testName,testPrice);

    @Test
    public void getNameReturnsTrueName(){
        assertEquals(testName,bun.getName());
    }
    @Test
    public void getPriceReturnsTruePrice(){
        assertEquals(testPrice,bun.getPrice(),0);
    }
}
