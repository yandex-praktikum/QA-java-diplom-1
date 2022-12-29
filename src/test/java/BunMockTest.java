import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;

@RunWith(MockitoJUnitRunner.class)
public class BunMockTest {

    @Mock
    Bun bunMock;

    @Test
    public void getNameBunTest() {
        bunMock.getName();
        bunMock.getName();
        Mockito.verify(bunMock, Mockito.times(2)).getName();
    }

    @Test
    public void getNameBunStabTest() {
        Mockito.when(bunMock.getName()).thenReturn("Круассан");
        Assert.assertEquals("Круассан", bunMock.getName());
    }

    @Test
    public void getPriceBunTest() {
        bunMock.getPrice();
        bunMock.getPrice();
        bunMock.getPrice();
        Mockito.verify(bunMock, Mockito.times(3)).getPrice();
    }

    @Test
    public void getPriceBunStabTest() {
        Mockito.when(bunMock.getPrice()).thenReturn(5000.0f);
        Assert.assertEquals(5000.0f, bunMock.getPrice(), 0);
    }
}
