import org.junit.Test;
import praktikum.Bun;
import static org.junit.Assert.assertEquals;


public class BunTest {
    String expectedName = "Булочка";

    float expectedPrice = 100f;
    Bun bun = new Bun(expectedName , expectedPrice);

    @Test
    public void testGetName(){
        assertEquals(expectedName, bun.getName());
      //  System.out.println(bun.getName());
    }


    @Test
    public void testGetPrice() {
        assertEquals(expectedPrice, bun.getPrice(), 0);
     //    System.out.println(bun.getPrice());
    }
}
