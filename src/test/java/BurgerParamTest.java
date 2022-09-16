import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;
import praktikum.Bun;
import praktikum.Burger;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BurgerParamTest extends BurgerTest {

    private Burger burger;
    private String actualResult;
    private String expectedResult;


    BurgerParamTest(String actualResult, String expectedResult){
        this.actualResult = actualResult;
        this.expectedResult = expectedResult;
    }

    @Parameterized.Parameters
    public static Object[][] getData(){
        return new Object[][] {
            {BaseBurger.burger.getReceipt(), BUNS_ADDED_EXPECTED},
            {},
            {},

        };
    }

    @Test
    public void setBunsReturnRightBunsInReceipt(){
        Mockito.when(buns.get(0)).thenReturn(new Bun("black bun", 100));

        burger.setBuns(buns.get(0));


        assertEquals(BUNS_ADDED_EXPECTED, actualResult);
    }
}
