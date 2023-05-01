package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    Burger burger = new Burger();

    @Mock
    Bun bun;

    @Mock
    Ingredient ingredient;

    @Mock
    Ingredient ingredient2;

    @Test
    public void setBunsTest(){
        burger.setBuns(bun);
        assertEquals("Булочка должна соответстовать переданной", bun, burger.bun);
    }

    @Test
    public void addIngredientTest(){
        burger.addIngredient(ingredient);
        assertEquals("Ингридиент не соответствует добавленному", burger.ingredients.get(0), ingredient);
        assertEquals("Ингридиент не добавлен", burger.ingredients.size(), 1);
    }

    @Test
    public void removeIngredientTest(){
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        assertEquals("Ингридиент не удален", burger.ingredients.size(), 0);
    }

    @Test
    public void moveIngredientTest(){
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient2);
        burger.moveIngredient(0, 1);
        assertEquals("Ингридиент 1 не поменял индекс на указанный", burger.ingredients.get(1), ingredient);
        assertEquals("Ингридиент 2 не поменял индекс на указанный", burger.ingredients.get(0), ingredient2);
    }

    @Test
    public void getPriceTest(){
        burger.addIngredient(ingredient);
        burger.setBuns(bun);
        Mockito.when(ingredient.getPrice()).thenReturn(50.00F);
        Mockito.when(bun.getPrice()).thenReturn(100.00F);
        assertEquals("Не корректный расчет стоимости", burger.getPrice(), 250, 0);
        Mockito.verify(bun, Mockito.times(1)).getPrice();
        Mockito.verify(ingredient, Mockito.times(1)).getPrice();
    }

    @Test
    public void getRecipientTest(){
        burger.addIngredient(ingredient);
        burger.setBuns(bun);
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredient.getName()).thenReturn("Кетчуп");
        Mockito.when(bun.getName()).thenReturn("Тестовая булочка");

        String expected = "(==== Тестовая булочка ====)\r\n" +
                "= sauce Кетчуп =\r\n" +
                "(==== Тестовая булочка ====)\r\n" +
                "\r\nPrice: 0,000000\r\n";

        String actual = burger.getReceipt();
        assertEquals("Полученая строка не соответствует ожидаемой", expected, actual);
    }
}