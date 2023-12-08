package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class BurgerIsolatedTests {
    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient;
    Burger burger = new Burger();

    @Before
    public void fillBurger() {
        //не используем методы, которые могут не работать
        burger.bun = bun;
        burger.ingredients.add(ingredient);
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.valueOf("FILLING"));
    }

    @Test
    public void getPriceBurgerMustUseGetPriceBun() {
        burger.getPrice();
        Mockito.verify(bun, Mockito.times(1)).getPrice();
    }

    @Test
    public void getPriceBurgerMustUseGetPriceIngredient() {
        burger.getPrice();
        Mockito.verify(ingredient, Mockito.times(1)).getPrice();
    }

    @Test
    public void getReceiptMustUseGetNameBun() {
        burger.getReceipt();
        Mockito.verify(bun, Mockito.times(2)).getName();
    }

    @Test
    public void getReceiptMustUseGetNameIngredient() {
        burger.getReceipt();
        Mockito.verify(ingredient, Mockito.times(1)).getName();
    }

    @Test
    public void getReceiptMustUseGetTypeIngredient() {
        burger.getReceipt();
        Mockito.verify(ingredient, Mockito.times(1)).getType();
    }
}
