

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;

@RunWith(MockitoJUnitRunner.class)

public class BunTest {





    @Test
    public void checkBunName(){
        Bun bunTest = new Bun("Бургерная", 100);
       String bunName = bunTest.getName();
        Assert.assertEquals("Бургерная",bunName);
    }

    @Test
    public void checkBunPrice(){
        Bun bunTest = new Bun("Бургерная", 500);
        float bunPrice = bunTest.getPrice();
        Assert.assertEquals(bunPrice,500,0);
    }
}
