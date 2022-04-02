import org.junit.Test;
import praktikum.Database;

import static org.junit.Assert.*;

public class DatabaseTest {

    Database database = new Database();
    int expectedSizeBuns = 3;

    @Test
    public void availableBuns() {
        assertEquals("Buns incorrect", expectedSizeBuns, database.availableBuns().size());

    }
}