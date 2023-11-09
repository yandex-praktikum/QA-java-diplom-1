import org.junit.Assert;
import org.junit.Test;
import praktikum.Bun;
import praktikum.Database;

import java.util.List;

public class TestDatabase {
    Database database = new Database();
    @Test
    public void testAvailableBunsNotEmpty() {
        List<Bun> buns = database.availableBuns();
        Assert.assertFalse(buns.isEmpty());
    }

    @Test
    public void testAvailableBunsSize() {
        List<Bun> buns = database.availableBuns();
        int expected = 3;
        Assert.assertEquals(expected, buns.size());
    }
}
