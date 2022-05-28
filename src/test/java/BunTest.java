import org.junit.Test;
import praktikum.*;
import static org.junit.Assert.*;

public class BunTest {

    @Test
    public void checkCorrectBunNameIsReturned(){
        Bun bun = new Bun ("BunName", 1.5f);
        String result = bun.getName();
        assertEquals("Ожидается другое значение ", "BunName", result);
    }

    @Test
    public void checkCorrectBunPriceIsReturned(){
        Bun bun = new Bun ("BunName", 1.5f);
        float result = bun.getPrice();
        assertEquals("Ожидается другое значение",1.5f, result, 0);
    }
}