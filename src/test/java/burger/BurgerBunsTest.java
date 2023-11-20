package burger;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class BurgerBunsTest {
    @Mock
    Bun bun;
    @Test
    public void setBunNameTest(){
        Burger burger = new Burger();
        burger.setBuns(bun);
        String expectedNameBun = "hot bun";
        Mockito.when(bun.getName()).thenReturn("hot bun");
        assertEquals("Fail",expectedNameBun,bun.getName());
}
    @Test
    public void setBunPriceTest(){
        Burger burger1 = new Burger();
        burger1.setBuns(bun);
        Mockito.when(bun.getPrice()).thenReturn(50.0F);
        Float expectedPriceBun = 50.0F;
        Float actual = bun.getPrice();
        assertEquals("Fail",expectedPriceBun,actual);
    }
}
