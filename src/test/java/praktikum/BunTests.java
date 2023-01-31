package praktikum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BunTests {
    Bun bun;

    @Test
    public void testEqualBunObjects() {
        bun = new Bun("black bun", 100.0F);
        Bun bun1 = new Bun("black bun", 100.0F);
        assertEquals(bun1, bun);

    }

    @Test (expected = Exception.class)
    public void testGetBunNameIsNull() {
            try {
                bun = new Bun(null, 100.F);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    @Test (expected = Exception.class)
    public void testGetBunNameIsSpace() {
            try {
                bun = new Bun("   ", 100.F);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    @Test (expected = Exception.class)
    public void testGetBunNameIsBlank() {
        try {
            bun = new Bun("", 100.F);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test (expected = Exception.class)
    public void testGetBunPriceIsNegative() {
        try {
            bun = new Bun("black bun", -0.01F);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}