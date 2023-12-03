package praktikum;

import org.junit.Before;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.Mockito;
import org.mockito.Mock;

import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(MockitoJUnitRunner.class)
public class BurgerIsolatedTests {
    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient;
    Burger burger = new Burger();

    //наполняем бургер булочкой и начинкой
    //делаем заглушку для типа бургера
    @Before
    public void fillBurger() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.valueOf("FILLING"));
    }

    //Проверяем, что подсчёте стоимости бургера используется метод getPrice для булки
    @Test
    public void getPriceBurgerMustUseGetPriceBun() {
        burger.getPrice();
        Mockito.verify(bun, Mockito.times(1)).getPrice();
    }

    //Проверяем, что при подсчёте стоимости бургера используется метод getPrice для ингредиента
    @Test
    public void getPriceBurgerMustUseGetPriceIngredient() {
        burger.getPrice();
        Mockito.verify(ingredient, Mockito.times(1)).getPrice();
    }

    //Проверяем, что при создании рецепта используется метод getName для булки
    @Test
    public void getReceiptMustUseGetNameBun() {
        burger.getReceipt();
        Mockito.verify(bun, Mockito.times(2)).getName();
    }

    //Проверяем, что при создании рецепта используется метод getName для ингредиента
    @Test
    public void getReceiptMustUseGetNameIngredient() {
        burger.getReceipt();
        Mockito.verify(ingredient, Mockito.times(1)).getName();
    }

    //Проверяем, что при создании рецепта используется метод getType для ингредиента
    @Test
    public void getReceiptMustUseGetTypeIngredient() {
        burger.getReceipt();
        Mockito.verify(ingredient, Mockito.times(1)).getType();
    }
}
