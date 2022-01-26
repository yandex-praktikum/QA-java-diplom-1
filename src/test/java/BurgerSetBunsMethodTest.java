import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class BurgerSetBunsMethodTest{
    Burger burger;
    @Mock
    Bun mBun;
    @Before
    public void before(){
         burger = new Burger();
    }
    @Test
    public void testThatBunFieldIsSetBySetter(){
        burger.setBuns(mBun);
        assertEquals("Булка после сеттера определена",mBun,burger.bun);
    }
}
