package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class BunTest {
    @Mock
    Bun bun;
    @Test
    public void getNameTest() {
        bun.getName();
        Mockito.verify(bun).getName();
    }
    @Test
    public void getPriceTest() {
        bun.getPrice();
        Mockito.verify(bun).getPrice();
    }
}