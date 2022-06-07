import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import praktikum.*;
import org.mockito.junit.MockitoJUnitRunner;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    Database database = Mockito.mock(Database.class);

    @Test
    public void addIngredientTest() {
        //объявили экземпляр класса burger
        Burger burger = new Burger();
        //объявили список ингридиентов
        List<Ingredient> ingredients = new ArrayList<>();
        //добавили ингридиент, чтобы имитировать работу бд
        ingredients.add(new Ingredient(IngredientType.SAUCE, "hot sauce", 100));
        //имитировали ответ от базы
        Mockito.when(database.availableIngredients())
                .thenReturn(ingredients);
        //добавили в бургер ингридиент
        burger.addIngredient(database.availableIngredients().get(0));
        //сравнили полученное с ожидаемым
        assertEquals(burger.ingredients.size(), 1);
    }

    @Test
    public void removeIngredientTest() {
        Burger burger = new Burger();

        burger.addIngredient(new Ingredient(IngredientType.SAUCE, "hot sauce", 100));
        burger.removeIngredient(0);
        assertEquals(burger.ingredients.isEmpty(), true);
    }

    @Test
    public void moveIngredientTest() {
        //объявили экземпляр класса burger
        Burger burger = new Burger();

        burger.addIngredient(new Ingredient(IngredientType.SAUCE, "hot sauce", 100));
        burger.addIngredient(new Ingredient(IngredientType.FILLING, "cutlet", 100));
        burger.moveIngredient(0, 1);

        assertEquals(burger.ingredients.get(1).getName(), "hot sauce");
    }

    @Test
    public void getPriceTest() {
        Burger burger = new Burger();
        burger.setBuns(new Bun("white bun", 200));
        burger.addIngredient(new Ingredient(IngredientType.SAUCE, "hot sauce", 200));

        float actual = burger.getPrice();
        float expected = 600;
        assertEquals(expected, actual, 0);
    }

    @Test
    public void getReceiptTest() {
        Burger burger = new Burger();
        burger.setBuns(new Bun("white bun", 200));
        burger.addIngredient(new Ingredient(IngredientType.SAUCE, "hot sauce", 200));
        String act = burger.getReceipt();

        StringBuilder sb = new StringBuilder(String.format("(==== white bun ====)%n"))
                .append(String.format("= sauce hot sauce =%n"))
                .append(String.format("(==== white bun ====)%n"))
                .append(String.format("%nPrice: 600,000000%n"));

        assertEquals(sb.toString().equals(act), true);
    }
}