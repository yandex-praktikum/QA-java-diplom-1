import org.apache.commons.lang3.RandomUtils;
import org.junit.Test;
import praktikum.Bun;
import praktikum.Database;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class BunTest {

    Database database = new Database();
    List<Bun> buns = database.availableBuns();

    int indexBuns = RandomUtils.nextInt(0, 3);

    Bun bun = buns.get(indexBuns);

    @Test
    public void BunNameTest() {
        assertEquals(buns.get(indexBuns).name, bun.getName());
    }

    @Test
    public void BunPriceTest() {
        assertEquals(buns.get(indexBuns).price, bun.getPrice(), 0);
    }
}
