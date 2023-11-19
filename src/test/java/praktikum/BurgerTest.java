package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    @Mock
    Bun bun;
    Burger burger;
    @Mock
    Ingredient ingredient;
    @Mock
    Ingredient secondIngredient;

    @Before
    public void init() throws Exception {
        burger = new Burger();
    }

    @Test
    public void setBunsTest() {
        burger.setBuns(bun);
        boolean isTrue = burger.bun == bun;
        Assert.assertEquals("Булочка не совпадает", true, isTrue);
    }
    @Test
    public void addIngredientTest() {
        burger.addIngredient(ingredient);
        boolean isExists = burger.ingredients.contains(ingredient);
        Assert.assertEquals("Ингридиент не добавлен", true, isExists);
    }
    @Test
    public void removeIngredientTest() {
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        boolean isExists = burger.ingredients.contains(ingredient);
        Assert.assertEquals("Ингридиент не удален", false, isExists);
    }
    @Test
    public void moveIngredientTest() {
        burger.addIngredient(ingredient);
        burger.addIngredient(secondIngredient);
        burger.moveIngredient(0, 1);
        String ingredient_name = burger.ingredients.get(0).toString();
        Assert.assertEquals("Ингридиент не перемещен", "secondIngredient", ingredient_name);
    }
    @Test
    public void getPriceTest() {
        burger.addIngredient(ingredient);
        burger.addIngredient(secondIngredient);
        burger.setBuns(bun);
        Mockito.when(ingredient.getPrice()).thenReturn(100.0F);
        Mockito.when(secondIngredient.getPrice()).thenReturn(150.0F);
        Mockito.when(bun.getPrice()).thenReturn(50.0F);
        float price = burger.getPrice();
        Assert.assertEquals("Цена не совпадает",350.0F, price, 0);
    }
    @Test
    public void getReceiptTest() {
        burger.addIngredient(ingredient);
        burger.addIngredient(secondIngredient);
        burger.setBuns(bun);
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredient.getName()).thenReturn("Соус");
        Mockito.when(secondIngredient.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(secondIngredient.getName()).thenReturn("Начинка");
        Mockito.when(bun.getName()).thenReturn("Булочка");
        String receipt = burger.getReceipt();
        Assert.assertEquals("Чек не пришел", true, !receipt.isEmpty());
    }
}
