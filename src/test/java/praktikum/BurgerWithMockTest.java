package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class BurgerWithMockTest {

    Burger burger = new Burger();
    @Mock
    Bun bun = new Bun("black bun", 100);
    @Mock
    Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "hot sauce", 100);
    @Before
    public void createTestBurger(){
        burger.addIngredient(ingredient);
        burger.setBuns(bun);
}
    @Test
    public void getPriceTest() {
        Mockito.when(bun.getPrice()).thenReturn(10F);
        Mockito.when(ingredient.getPrice()).thenReturn(20F);
        float actial = burger.getPrice();
        System.out.println(actial);
        float expected = 40F;
        Assert.assertEquals(actial,expected,0);

    }
}
