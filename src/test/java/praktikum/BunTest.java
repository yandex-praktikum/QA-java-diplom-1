package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class BunTest {
    @Mock
    Bun bun;
    Database database = new Database();

    @Test
    public void getNameTest() {
        Mockito.when(bun.getName()).thenReturn("Булочка с корицей");
        Assert.assertEquals("Булочка с корицей", bun.getName());
        Mockito.verify(bun, Mockito.times(1)).getName();

    }

    @Test
    public void getPriceTest() {
        Bun bunObject = database.availableBuns().get(0);
        Assert.assertEquals(100, bunObject.getPrice(), 0);

    }

}