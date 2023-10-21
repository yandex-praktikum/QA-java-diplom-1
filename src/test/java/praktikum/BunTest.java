package praktikum;
import org.junit.Test;
import static junit.framework.TestCase.assertEquals;

public class BunTest {
    Bun bun = new Bun("red bun", 300);

    @Test
    public void testGetBunName() {
       assertEquals("red bun", bun.getName());
    }

    @Test
    public void testGetBunPrice(){
       assertEquals(300, bun.getPrice(),0); //добавляем дельту, так как тип float
    }
}