package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class BunTest{

    @Test
    public void getNameTest(){
        Bun bun = new Bun("black bun", 100);

        assertEquals("black bun", bun.getName());
    }

    @Test
    public void getPriceTest(){
        Bun bun = new Bun("black bun", 100);

        assertEquals(100, bun.getPrice(), 0);
    }
}