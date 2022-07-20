package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import static org.mockito.BDDMockito.given;

public class BurgerPriceMockTest {
    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Mock
    public Bun mockBun;

    @Mock
    public Ingredient mockIngredientFirst;

    @Mock
    public Ingredient mockIngredientSecond;

    @Before
    public void init() throws Exception {
        MockitoAnnotations.openMocks(this);
    }

    //Проверяем метод подсчета цены бургера
    @Test
    public void getPriceWithMocks() {
        Burger burger = new Burger();

        burger.setBuns(mockBun);
        burger.addIngredient(mockIngredientFirst);
        burger.addIngredient(mockIngredientSecond);

        given(mockBun.getPrice()).willReturn(50F);
        Mockito.when(mockIngredientFirst.getPrice()).thenReturn(25F);
        Mockito.when(mockIngredientSecond.getPrice()).thenReturn(200F);

        Assert.assertEquals(325F, burger.getPrice(), 0.0f);
    }
}
