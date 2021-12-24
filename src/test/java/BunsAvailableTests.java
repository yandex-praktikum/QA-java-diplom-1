import org.junit.Test;
import praktikum.Bun;
import praktikum.Database;

import static org.junit.Assert.assertEquals;

public class BunsAvailableTests {
    @Test
    public void AvailableBunsReturnAllElementsTest() {
        Database database = new Database();
        int actual = database.availableBuns().size();
        assertEquals(3, actual);
    }

    @Test
    public void AvailableBunsReturnCorrectListOfElementsTest() {
        Database database = new Database();
        Object actual = database.availableBuns().get(1).getClass();
        assertEquals(Bun.class, actual);
    }
}
