import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

public class BunTest {

    @Test
    public void getNameTest(){
        Bun bun = new Bun("Abc_bun", 100);

        String actualBunName = bun.getName();

        assertEquals("Abc_bun", actualBunName);
    }

    @Test
    public void getPriceTest(){
        Bun bun = new Bun("Abc_bun", 100);

        float actualBunPrice = bun.getPrice();

        assertEquals(100, actualBunPrice,1e-8);
    }
}
