import org.junit.Test;
import praktikum.Bun;
import praktikum.Database;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class DatabaseTest {

    @Test
    public void testAvailableBuns() {
        Database database = new Database();
        List<Bun> buns = database.availableBuns();
        assertNotNull(buns);
    }

    @Test
    public void testAvailableBunsSize() {
        Database database = new Database();
        List<Bun> buns = database.availableBuns();
        assertEquals(3, buns.size());
    }

}