import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.emptyList;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    Bun bun;

    @Mock
    Ingredient ingredient;

    @Mock
    Ingredient ingredient2;

    @Test
    public void setBunsCalledWithBunTest(){
        Burger burger = new Burger();
        burger.setBuns(bun);
        assertThat("Метод не установил значение, переданное в аргументе.",burger.bun,is(bun));
    }

    @Test
    public void addIngredientTest(){
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        List<Ingredient> expected = new ArrayList<>();
        expected.add(ingredient);
        assertThat("Метод не добавил ингредиент.",burger.ingredients,is(expected));
    }

    @Test
    public void removeIngredientTest(){
        Burger burger = new Burger();
        burger.ingredients.add(ingredient);
        burger.removeIngredient(0);
        assertThat("Метод не удалил ингредиент.",burger.ingredients,is(emptyList()));
    }

    @Test
    public void moveIngredientTest(){
        Burger burger = new Burger();
        burger.ingredients.add(ingredient);
        burger.ingredients.add(ingredient2);
        burger.moveIngredient(1,0);
        assertThat("Метод не поменял местами ингредиенты.", burger.ingredients.get(0),is(ingredient2));
        assertThat("Метод не поменял местами ингредиенты.",burger.ingredients.get(1),is(ingredient));
    }

    @Test
    public void getPriceReturnPriceTest(){
        Burger burger = new Burger();
        burger.setBuns(bun);
        Mockito.when(bun.getPrice()).thenReturn(10f);
        float actual = burger.getPrice();
        assertThat("Метод вернул неверное значение цены.",actual,is(20f));
    }

    @Test
    public void getReceiptReturnReceiptTest(){
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.ingredients.add(ingredient);
        Mockito.when(bun.getName()).thenReturn("name bun");
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredient.getName()).thenReturn("name ingredient");
        Mockito.when(bun.getPrice()).thenReturn(11f);
        String actual = burger.getReceipt();
        String expected = "(==== name bun ====)\r\n= sauce name ingredient =\r\n(==== name bun ====)\r\n\r\nPrice: 22,000000\r\n";
        assertThat("Метод вернул неверные шаблон чека и/или значение в чеке.", actual,is(expected));
    }



}
