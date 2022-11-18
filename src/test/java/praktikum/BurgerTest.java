package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    Burger burger;
    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient_type1;
    @Mock
    Ingredient ingredient_type2;

    @Test
    public void addIngredientTest() {
        burger = new Burger();
        burger.addIngredient(ingredient_type1);
        Assert.assertEquals("Ингредиент не добавился", 1, burger.ingredients.size());
    }

    @Test
    public void removeIngredientTest() {
        burger = new Burger();
        burger.addIngredient(ingredient_type1);
        burger.addIngredient(ingredient_type2);
        burger.removeIngredient(0);
        Assert.assertEquals("Ингредиент не удалился", 1, burger.ingredients.size());
    }

    @Test
    public void moveIngredientTest() {
        burger = new Burger();
        burger.addIngredient(ingredient_type1);
        burger.addIngredient(ingredient_type2);
        burger.moveIngredient(0, 1);
        Assert.assertEquals("Ингредиент не переместился", 1, burger.ingredients.indexOf(ingredient_type1));
    }

    @Test
    public void getPriceTest() {
        burger = new Burger();
        Mockito.when(bun.getPrice()).thenReturn(1F);
        Mockito.when(ingredient_type1.getPrice()).thenReturn(2F);
        Mockito.when(ingredient_type2.getPrice()).thenReturn(3F);
        burger.setBuns(bun);
        burger.addIngredient(ingredient_type1);
        burger.addIngredient(ingredient_type2);
        burger.moveIngredient(0, 1);
        Assert.assertEquals("Сумма посчиталась неверно", 7F, burger.getPrice(), 0.01);
    }

    @Test
    public void getReceiptTest() {
        burger = new Burger();
        String expectedReceipt = "(==== black bun ====)\r\n" +
                "= sauce sour cream =\r\n" +
                "= filling cutlet =\r\n" +
                "(==== black bun ====)\r\n\r\n" +
                "Price: 7,000000\r\n";
        Mockito.when(bun.getName()).thenReturn("black bun");
        Mockito.when(ingredient_type1.getName()).thenReturn("sour cream");
        Mockito.when(ingredient_type2.getName()).thenReturn("cutlet");
        Mockito.when(ingredient_type1.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredient_type2.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(bun.getPrice()).thenReturn(1F);
        Mockito.when(ingredient_type1.getPrice()).thenReturn(2F);
        Mockito.when(ingredient_type2.getPrice()).thenReturn(3F);
        burger.setBuns(bun);
        burger.addIngredient(ingredient_type1);
        burger.addIngredient(ingredient_type2);
        Assert.assertEquals("Рецепт вывелся неверно", expectedReceipt, burger.getReceipt());

    }
}