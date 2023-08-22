import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;



@RunWith(MockitoJUnitRunner.class)
public class TestBun {

    @Mock
    Bun Bun;

    @Test
    public void getName() {
    Bun.getName();
    Mockito.verify(Bun).getName();
        }

    @Test
    public void getPrise() {
        Bun.getPrice();
        Mockito.verify(Bun).getPrice();
            }

}
