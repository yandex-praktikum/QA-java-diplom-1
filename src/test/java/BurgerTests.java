import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;

import java.util.ArrayList;
import java.util.List;

import static praktikum.IngredientType.FILLING;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTests {

    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient;
    @Mock
    Ingredient secondIngredient;


    @Test
    public void addIngredientTest() {
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        Assert.assertEquals("Список ингридиентов должын содержать 1 элемент",
                1, burger.ingredients.size());
    }

    @Test
    public void removeIngredientTest() {
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        Assert.assertEquals("Список ингридиентов должен быть пустой",
                0, burger.ingredients.size());
    }

    @Test
    public void moveIngredientTest() {
        Burger burger = new Burger();
        burger.ingredients.add(ingredient);
        burger.ingredients.add(secondIngredient);
        List<Ingredient> expected = new ArrayList<>();
        expected.add(secondIngredient);
        expected.add(ingredient);
        burger.moveIngredient(0, 1);
        Assert.assertEquals(expected, burger.ingredients);
    }

    @Test
    public void setBunsTest() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        Assert.assertEquals(bun, burger.bun);
    }

    @Test
    public void getPriceTest() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.ingredients.add(ingredient);
        Mockito.when(bun.getPrice()).thenReturn(50.0F);
        Mockito.when(ingredient.getPrice()).thenReturn(20.0F);
        Assert.assertEquals("Бургер должен стоить 120 рублей",
                120.0, burger.getPrice(), 0.0);
    }

    @Test
    public void getReceiptTest() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.ingredients.add(ingredient);
        Mockito.when(bun.getName()).thenReturn("Ржаная");
        Mockito.when(bun.getPrice()).thenReturn(60.0F);
        Mockito.when(ingredient.getType()).thenReturn(FILLING);
        Mockito.when(ingredient.getName()).thenReturn("Бекон");
        Mockito.when(ingredient.getPrice()).thenReturn(100.0F);
        String expected = "(==== Ржаная ====)\r\n" +
                "= filling Бекон =\r\n" +
                "(==== Ржаная ====)\r\n" +
                "\r\n" +
                "Price: 220,000000\r\n";
        Assert.assertEquals(expected, burger.getReceipt());
    }
}
