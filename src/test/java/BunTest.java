import org.junit.Test;

import praktikum.Bun;

import static org.junit.Assert.assertEquals;

public class BunTest {

 @Test
public void getNameTest(){
     Bun bun = new Bun("Булочка", 4646464);
     assertEquals("Булочка", bun.getName());
 }

    @Test
    public void getPriceTest(){
        Bun bun = new Bun("Булочка", 4646464);
        assertEquals(4646464, bun.getPrice(), 0);
    }
}
