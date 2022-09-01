package praktikum.bun;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;
import praktikum.Bun;
import praktikum.Database;

public class BunTest {

    @Mock
    Database database;

    @Test public void getNameTest(){
        Bun bun = new Bun("Булка1", (float) 56.6);
        String actual = bun.getName();
        Assert.assertEquals(bun.name,actual);
    }

    @Test public void getNameTestFromDB(){
        Database database = new Database();
        Bun bun = database.availableBuns().get(1);
        String actual = bun.getName();
        Assert.assertEquals(bun.name,actual);
    }

    @Test public void getPriceTest(){
        Bun bun = new Bun("Булка1", (float) 56.6);
        float actual = bun.getPrice();
        Assert.assertEquals(bun.price,actual,0);
    }

    @Test public void getPriceTestFromDB(){
        Database database = new Database();
        Bun bun = database.availableBuns().get(1);
        float actual = bun.getPrice();
        Assert.assertEquals(bun.price,actual,0);
    }


}
