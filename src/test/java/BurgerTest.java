import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;

import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

public class BurgerTest {

    @Before
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void setBunTest(){
        Burger burger = new Burger();
        Bun bun = new Bun("Флюоресцентная булка R2-D3", 988);

        burger.setBuns(bun);

        Assert.assertEquals("В бургер добавлена неверная булка", "Флюоресцентная булка R2-D3", burger.bun.getName());
    }

    @Test
    public void addIngredientTest(){
        Burger burger = new Burger();
        Ingredient ingredient = new Ingredient(SAUCE, "Соус Spicy-X", 90);

        burger.addIngredient(ingredient);

        Assert.assertEquals("Ингредиент добавлен некорректно", 1, burger.ingredients.size());
    }

    @Test
    public void removeIngredientTest(){
        Burger burger = new Burger();
        Ingredient ingredient = new Ingredient(SAUCE, "Соус Spicy-X", 90);
        burger.addIngredient(ingredient);

        burger.removeIngredient(0);

        Assert.assertEquals("Удаление ингредиентов работает некорректно", 0, burger.ingredients.size());
    }

    @Test
    public void moveIngredientTest(){
        Burger burger = new Burger();
        Ingredient ingredient1 = new Ingredient(SAUCE, "Соус Spicy-X", 90);
        Ingredient ingredient2 = new Ingredient(FILLING, "Мясо бессмертных моллюсков Protostomia", 1337);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);

        burger.moveIngredient(0, 1);

        Assert.assertEquals("Ингредиенты не меняются местами", FILLING, burger.ingredients.get(0).type);
    }

    @Test
    public void checkGetPriceTest(){
        Bun bun = Mockito.mock(Bun.class);
        Ingredient ingredient = Mockito.mock(Ingredient.class);

        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        Mockito.when(bun.getPrice()).thenReturn(140f);
        Mockito.when(ingredient.getPrice()).thenReturn(200f);

        float actualPrice = burger.getPrice();

        Assert.assertEquals("Цена посчитана неверно",480f, actualPrice, 0.01);
    }

    @Test
    public void checkGetReceiptTest(){
        Bun bun = new Bun("Флюоресцентная булка R2-D3", 100);
        Ingredient ingredient = new Ingredient(FILLING, "Мясо бессмертных моллюсков Protostomia", 150);
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);

        String actualReceipt = burger.getReceipt();

        Assert.assertTrue(actualReceipt.contains("Флюоресцентная булка R2-D3"));
        Assert.assertTrue(actualReceipt.contains("filling"));
        Assert.assertTrue(actualReceipt.contains("Мясо бессмертных моллюсков Protostomia"));
        Assert.assertTrue(actualReceipt.contains("350"));
    }
}
