import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;

@RunWith(MockitoJUnitRunner.class)
public class GetBurgerPriceTest {
    @Mock
    Bun bun;

    @Mock
    Ingredient ingredient;

    @Test
    public void getBurgerPriceTest(){
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);

        Mockito.when(bun.getPrice()).thenReturn(20F);
        Mockito.when(ingredient.getPrice()).thenReturn(20F);

        float actualBurgerPrice = burger.getPrice();
        Assert.assertEquals(60F,actualBurgerPrice, 60F-actualBurgerPrice);
    }
}