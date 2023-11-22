package praktikum;

import org.junit.Assert;
import org.junit.Test;

public class BunTest {
    Database database = new Database();

    Bun bun = new Bun(database.availableBuns().get(1).getName(), database.availableBuns().get(1).getPrice());


    @Test
    public void getName() {

        Assert.assertEquals("white bun", bun.getName());

    }

    @Test
    public void getPrice() {

        Assert.assertEquals(200F, bun.getPrice(), 0.0);

    }

}
