

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;
import praktikum.Bun;
import praktikum.Database;

public class GetAvailableBunsTest {
    @Mock
    Bun bun;

    @Test
    public void getAvailableBuns(){
        Database database = new Database();
        database.availableBuns().add(bun);
        Assert.assertTrue(database.availableBuns().contains(bun));
    }
}