import org.junit.Test;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

public class BunTest {


    @Test
    public void getNameReturnCorrect() {
        String name= "Черная";
        float price= (float) 1567.89;
        Bun bun=new Bun(name, price);
        assertEquals(name, bun.getName());
        assertEquals(price, bun.getPrice(),0);
    }
}
