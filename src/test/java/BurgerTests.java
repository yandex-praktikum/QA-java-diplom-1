import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.*;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.*;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTests {

    @Mock
    Bun bun;

    @Mock
    Ingredient ingredient;

    @Mock
    Ingredient ingredient2;

    @Test
    public void setBunsTest() {

        Burger burger = new Burger();
        burger.setBuns(bun);
        assertThat("Метод SetBuns неверно сетит объект Bun", burger.bun, equalTo(bun));
    }

    @Test
    public void addIngredientTest() {
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        assertThat("Метод addIngredient не добавляет эллемент в ArrayList",
                burger.ingredients.contains(ingredient), equalTo(true));
    }

    @Test
    public void removeIngredientTest() {
        Burger burger = new Burger();
        burger.ingredients.add(ingredient);
        burger.removeIngredient(0);
        assertThat("Метод removeIngredient не удаляет элемент в ArrayList-е", burger.ingredients.isEmpty(), equalTo(true));
    }

    @Test
    public void moveIngredientTest() {
        Burger burger = new Burger();
        burger.ingredients.add(ingredient);
        burger.ingredients.add(ingredient2);
        burger.moveIngredient(0, 1);
        assertThat("Метод moveIngredient неверно перемещает элементы в ArrayList-е", burger.ingredients.get(0), equalTo(ingredient2));
    }

    @Test
    public void getPriceTest() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.ingredients.add(ingredient);
        Mockito.when(bun.getPrice()).thenReturn(50f);
        Mockito.when(ingredient.getPrice()).thenReturn(50f);
        float actual = burger.getPrice();
        assertThat("Метод getPrice неверное считает общую стоимость бургера", actual, equalTo(150f));
    }

    @Test
    public void getReceiptTest() {
        Burger burger = new Burger();
        Bun bun = new Bun("Булка", 25.5f);
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "Курица", 35f);
        burger.setBuns(bun);
        burger.ingredients.add(ingredient);
        String actual = burger.getReceipt();
        String expected = "(==== Булка ====)\r\n= sauce Курица =\r\n(==== Булка ====)\r\n\r\nPrice: 86,000000\r\n";
        assertThat("Метод getReceipt возвращает не верный шаблон", actual, equalTo(expected));
    }

}
