import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import praktikum.Bun;
import praktikum.Burger;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(Parameterized.class)
public class ParameterizedForMockBunsBurgerTest {
    Burger burger = new Burger();

    private float expectedResult;
    private float mockDataForTheBun;


    public ParameterizedForMockBunsBurgerTest(float expectedResult, float mockDataForTheBun ){
        this.expectedResult = expectedResult;
        this.mockDataForTheBun = mockDataForTheBun;
    }


    @Parameterized.Parameters
    public static  Object[] getDateForMockAndExpectedResult() {
        return new Object[][]{
                {200f, 100f},
                {300f, 150},
                {50, 25},
        };
    }

    @Before
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Mock
    Bun bun;

    @Test
    public void parameterizedBurgerTest(){
        burger.setBuns(bun);
        when(bun.getPrice()).thenReturn(mockDataForTheBun);
        assertEquals(expectedResult, burger.getPrice() , 0);

    }
}
