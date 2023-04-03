import org.junit.Assert;
import org.junit.Test;
import praktikum.Bun;
import praktikum.Database;

import java.util.List;

public class DatabaseTest {

    Database database = new Database();

    @Test
    public void availableBunsTest() {
        List<Bun> response = database.availableBuns();
        Assert.assertEquals(response.stream().count(), 3);
    }
}

