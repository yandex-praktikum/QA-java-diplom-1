import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Database;

@RunWith(MockitoJUnitRunner.class)
public class BunTest {

    // rewrite for stab
    @Spy
    Database database;

    @Test
    public void getBunNamePositive(){
        Bun bun = database.availableBuns().get(0);
        Assert.assertEquals("У булочки другое название", bun.getName(), "black bun");
    }

    @Test
    public void getBunPricePositive(){
        Bun bun = database.availableBuns().get(1);
        Assert.assertEquals("У булочки другое название", 200f, bun.getPrice(), 0.001);
    }

    @Test
    public void createNewBunPositive(){
        Bun bun = new Bun("orange bun", 130);
        Assert.assertNotNull(bun);
    }
}
