import org.junit.Test;
import praktikum.Bun;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class BunTest {

        @Test
        public void checkBunPricePositive(){
                Bun bun = new Bun("bun number 1", 100.0F);
                float expected = 100.0F;
                float actual = bun.getPrice();
                assertEquals("Price for bun is incorrect", expected, actual, 0.0001F);
        }

        @Test
        public void checkBunNamePositive(){
                Bun bun = new Bun("bun number 1", 100.0F);
                String expected = "bun number 1";
                String actual = bun.getName();
                assertEquals("Name for bun is incorrect", expected, actual);
        }

        @Test
        public void checkBunNameNegative(){
                Bun bun = new Bun("bun number 2", 200);
                String expected = "bun number 1";
                String actual = bun.getName();
                assertNotEquals("Name for bun is incorrect", expected, actual);
        }

    }
