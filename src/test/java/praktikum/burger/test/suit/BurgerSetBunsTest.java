package praktikum.burger.test.suit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;

@RunWith(MockitoJUnitRunner.class)
public class BurgerSetBunsTest {
    @Mock
    Burger testBurger;
    @Mock
    Bun testBun;

    @Test
    public void burgerSetBunsTest() {
        testBurger.setBuns(testBun);
        Mockito.verify(testBurger).setBuns(testBun);
    }
}
