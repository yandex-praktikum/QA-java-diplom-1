package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class BurgerWithMockTest {
    @Spy
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
        float expected = 40F;
        Assert.assertEquals(actial,expected,0);

    }

    @Test
    public void getReceiptTest() {
        Mockito.when(bun.getName()).thenReturn("black bun");
        Mockito.when(ingredient.getName()).thenReturn(String.valueOf("hot sauce"));
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.SAUCE);
        String actual = burger.getReceipt();
        Mockito.verify(burger, Mockito.times(1)).getPrice();
        String expected = "(==== black bun ====)\r\n= sauce hot sauce =\r\n(==== black bun ====)\r\n\r\nPrice: 0,000000\r\n";
        Assert.assertEquals(actual,expected);

    }
}
