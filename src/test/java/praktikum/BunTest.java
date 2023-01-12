package praktikum;

import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class BunTest {

    @Mock
    Bun bun;

   /* @org.junit.Test
    public void getName() {
    bun.getName("Флюоресцентная булка R2-D3");
        Mockito.verify(bun).getName(Mockito.anyString());
    }*/

    @org.junit.Test
    public void getPrice() {
    }
}