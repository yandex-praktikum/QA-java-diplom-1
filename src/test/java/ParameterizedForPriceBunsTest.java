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
public class ParameterizedForPriceBunsTest {
    Burger burger = new Burger();

    private final float expectedBunPriceResult;
    private final float mockDataForBunPrice;

    public ParameterizedForPriceBunsTest(float expectedBunPriceResult, float mockDataForBunPrice) {
        this.expectedBunPriceResult = expectedBunPriceResult;
        this.mockDataForBunPrice = mockDataForBunPrice;
    }

    @Parameterized.Parameters
    public static Object[] getDataForMockTest() {
        return new Object[][]{
                {200f, 100f},
                {600f, 300f},
                {0.2f, 0.1f},
                {-200, -100},
                {0, 0}
        };
    }

    @Before
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Mock
    Bun bun;

    @Test
    public void parameterizedGetPriceBunBurgerTest() {
        burger.setBuns(bun);
        when(bun.getPrice()).thenReturn(mockDataForBunPrice);
        assertEquals(expectedBunPriceResult, burger.getPrice(), 0);
    }
}

