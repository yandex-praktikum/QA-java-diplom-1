import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;

@RunWith(MockitoJUnitRunner.class)
public class SetBunTest {

    @Mock
    Burger burger;

    @Mock
    Bun bun;

    @Test
    public void canSetBunTest() {
        burger.setBuns(bun);
        Mockito.verify(burger).setBuns(bun);
    }
}