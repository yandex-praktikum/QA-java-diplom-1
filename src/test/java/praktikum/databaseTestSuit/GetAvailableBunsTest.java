package praktikum.databaseTestSuit;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;
import praktikum.Bun;
import praktikum.Database;

public class GetAvailableBunsTest {
    @Mock
    Bun testBun;

    @Test
    public void getAvailableBunsTest() {
        Database testDatabase = new Database();
        testDatabase.availableBuns().add(testBun);
        Assert.assertTrue(testDatabase.availableBuns().contains(testBun));

    }
}
