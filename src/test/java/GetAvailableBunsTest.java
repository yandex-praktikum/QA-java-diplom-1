

import org.junit.Assert;
import org.junit.Test;
import praktikum.Bun;
import praktikum.Database;

public class GetAvailableBunsTest {
    Bun bun;

    @Test
    public void getAvailableBuns(){
        Database database = new Database();
        database.availableBuns().add(bun);
        Assert.assertTrue(database.availableBuns().contains(bun));
    }
}