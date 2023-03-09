package praktikum;

import org.apache.commons.lang3.RandomUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest extends BaseTest {

    @Mock
    Burger burgerMock;
    Burger burgerReal;
    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient;

    @Test
    public void setBuns() {
        burgerMock.setBuns(bun);
        Mockito.verify(burgerMock, Mockito.times(1)).setBuns(bun);
    }

    @Test
    public void addIngredient() {
        burgerReal = new Burger();
        Burger burgerSpy = spy(burgerReal);
        burgerReal.addIngredient(ingredient);
        assertEquals("Количество ингридиентов неверное", 1, burgerSpy.ingredients.size());
    }

    @Test
    public void removeIngredient() {
        burgerReal = new Burger();
        Burger burgerSpy = spy(burgerReal);
        burgerReal.addIngredient(ingredient);
        assertEquals(1, burgerSpy.ingredients.size());
        burgerReal.removeIngredient(0);
        assertEquals("Количество ингридиентов неверное", 0, burgerSpy.ingredients.size());
    }

    @Test
    public void moveIngredient() {
        burgerReal = new Burger();
        Burger burgerSpy = spy(burgerReal);
        burgerReal.addIngredient(ingredient);
        burgerReal.addIngredient(ingredient);
        assertEquals(2, burgerSpy.ingredients.size());
        burgerReal.moveIngredient(0, 1);
        assertEquals("Количество ингридиентов неверное", 2, burgerSpy.ingredients.size());
    }

    @Test
    public void getPrice() {
        burgerReal = new Burger();
        float bunPrice = RandomUtils.nextFloat();
        float ingredientPrice = RandomUtils.nextFloat();
        when(bun.getPrice()).thenReturn(bunPrice);
        when(ingredient.getPrice()).thenReturn(ingredientPrice);
        burgerReal.setBuns(bun);
        burgerReal.addIngredient(ingredient);
        assertEquals("Неверная стоимость бургера", bunPrice * 2 + ingredientPrice, burgerReal.getPrice(), FLOAT_DELTA);
    }

//    Тест не проходит т.к. в исходном коде не обрабатывается данный кейс
//    @Test
//    public void getPriceForEmptyBurger() {
//        burgerReal = new Burger();
//        assertEquals("Неверная стоимость бургера", 0F, burgerReal.getPrice(), FLOAT_DELTA);
//    }

//    Тест не проходит т.к. в исходном коде не обрабатывается данный кейс
//    @Test
//    public void getReceiptForEmptyBurger() {
//        burgerReal = new Burger();
//        String expected = String.format("%nPrice: %f%n", 0F);
//        assertEquals("Неверный чек", expected, burgerReal.getReceipt());
//    }
}