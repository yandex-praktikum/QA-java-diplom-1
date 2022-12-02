import org.junit.Test;
import praktikum.Bun;

import static junit.framework.TestCase.assertEquals;

public class BunTest {

    @Test
    public void checkBunName(){
        Bun bun = new Bun("someNewBun", 100.00F);
        String actual = bun.getName();
        assertEquals("someNewBun", actual);
    }

    @Test
    public void checkBunPrice(){
        Bun bun = new Bun("veryNewBun", 150.00F);
        float actual = bun.getPrice();
        assertEquals(150.00F, actual);
    }

}
