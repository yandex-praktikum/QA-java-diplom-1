import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.List;
import java.util.Random;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    Bun bun;

    @Mock
    Ingredient ingredient;

    @Mock
    List<Ingredient> ingredients;

    @Test
    public void setBunsTest(){
        Burger burger = new Burger();
        burger.setBuns(bun);
        Assert.assertEquals("Добавленая булочка не соответствует переданной", bun, burger.bun);
    }

    @Test
    public void addIngredientsTest(){
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        Assert.assertTrue("Бургер не содержит добавленного ингредиента", burger.ingredients.contains(ingredient));
    }

    @Test
    public void removeIngredientTest(){
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        Assert.assertFalse("Ингредиент не удалился", burger.ingredients.contains(ingredient));
    }

    @Test
    public void moveIngredientTest(){
        Burger burger = new Burger();
        burger.ingredients = ingredients;
        int newIndex = 1;
        int index = 0;
        burger.moveIngredient(index, newIndex);
        Mockito.verify(ingredients).add(newIndex, ingredients.remove(index));
    }

    @Test
    public void getPriceTest(){
        Burger burger = new Burger();
        float bunPrice = new Random().nextFloat();
        float ingredientPrice = new Random().nextFloat();
        Mockito.when(bun.getPrice()).thenReturn(bunPrice);
        Mockito.when(ingredient.getPrice()).thenReturn(ingredientPrice);

        burger.setBuns(bun);
        burger.addIngredient(ingredient);

        float actualResult = burger.getPrice();

        Assert.assertEquals("Цена бургера не соответствует ожидаемой", ((bunPrice * 2) + ingredientPrice), actualResult, 0);
    }

    @Test
    public void getReceiptTest(){
        Burger burger = new Burger();
        Mockito.when(bun.getName()).thenReturn("Black BUN");
        Ingredient sauce = new Ingredient(IngredientType.SAUCE, "tomatoes", 300f);

        burger.setBuns(bun);
        burger.addIngredient(sauce);

        String expected = "(==== Black BUN ====)\r\n" +
                "= sauce tomatoes =\r\n" +
                "(==== Black BUN ====)\r\n" +
                "\r\n" +
                "Price: 300,000000\r\n";

        String actual = burger.getReceipt();

        Assert.assertEquals(expected, actual);
    }

}
