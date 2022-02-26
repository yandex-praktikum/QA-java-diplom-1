import org.junit.Assert;
import org.junit.Test;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

public class BunTest {

    @Test
    public void getNameReturnNameTest(){
        Bun bun = new Bun("Биг-мак",169f);
        String actual = bun.getName();
        assertEquals("Биг-мак",actual);
    }

    @Test
    public void getPriceReturnPriceTest(){
        Bun bun = new Bun("Биг-мак",169f);
        float actual = bun.getPrice();
        assertEquals(169,actual,0);
    }


}
