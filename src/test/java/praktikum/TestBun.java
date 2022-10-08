package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class TestBun {
    static DataManager bunManager = new DataManager();
    private final String commonName;
    private final float commonPrice;

    public TestBun(String commonName, float commonPrice) {
        this.commonName = commonName;
        this.commonPrice = commonPrice;
    }

    @Parameterized.Parameters
    public static Object[] data() {
        return new Object[][]{
                {bunManager.getAnyString(), bunManager.getAnyFloat()},
                {"", bunManager.getAnyFloat()},
                {" ", bunManager.getAnyFloat()},
                {null, bunManager.getAnyFloat()},
                {bunManager.getAnyString(), Float.MAX_VALUE},
                {"", Float.MAX_VALUE},
                {" ", Float.MAX_VALUE},
                {null, Float.MAX_VALUE},
                {bunManager.getAnyString(), Float.MIN_VALUE},
                {"", Float.MIN_VALUE},
                {" ", Float.MIN_VALUE},
                {null, Float.MIN_VALUE},
        };
    }

    @Test
    public void testGetName() {
        Bun bun = new Bun(commonName, commonPrice);
        String actualName = bun.getName();
        assertEquals(commonName, actualName);
    }

    @Test
    public void testGetPrice() {
        Bun bun = new Bun(commonName, commonPrice);
        float actualPrice = bun.getPrice();
        assertEquals(commonPrice, actualPrice, 0.001);
    }


}

