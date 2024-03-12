package praktikum;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class BunTest {
    Database database = new Database();

    Bun bun = new Bun(database.availableBuns().get(0).getName(), database.availableBuns().get(0).getPrice());

    @Test
    public void getBunsNameTest() {

        Assert.assertEquals("black bun", bun.getName());

    }

    @Test
    public void getBunsPriceTest() {

        Assert.assertEquals(100F, bun.getPrice(), 0.0);

    }
}