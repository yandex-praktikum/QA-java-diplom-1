package praktikum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BunTest {
    Bun bun;

    @Test
    public void testEqualBunObjects() {
        bun = new Bun("black bun", 100.0F);
        Bun bun1 = new Bun("black bun", 100.0F);
        assertEquals(bun1, bun);

    }

    @Test (expected = Exception.class)
    public void testGetBunNameIsNull()  throws  Exception{
            bun = new Bun(null, 100.F);
        }

    @Test (expected = Exception.class)
    public void testGetBunNameIsSpace()  throws  Exception{
            bun = new Bun("   ", 100.F);
        }

    @Test (expected = Exception.class)
    public void testGetBunNameIsBlank() throws Exception {
        bun = new Bun("", 100.F);
    }

    @Test (expected = Exception.class)
    public void testGetBunPriceIsNegative() {
        bun = new Bun("black bun", -0.01F);
    }

}