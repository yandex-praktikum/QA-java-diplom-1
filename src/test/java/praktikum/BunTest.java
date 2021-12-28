package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;


public class BunTest {


    @Test
    public void getPriceTest() {
        Bun bun = new Bun("Лилёк", 100);
        float actualPrice = bun.getPrice();
        assertEquals("Крякря, ассерт не совпал!Что-то не так в цене!",100, actualPrice,0);

    }

    @Test
    public void getNameTest() {
        Bun bun = new Bun("Лилёк", 100);
        String actualName = bun.getName();
        assertEquals("Крякря, ассерт не совпал!Что-то не так в имени!", "Лилёк", actualName);
    }
}