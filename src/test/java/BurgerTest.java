import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.*;
import praktikum.Burger;
import praktikum.Ingredient;

import static praktikum.IngredientType.*;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    Ingredient ingredient;
    Ingredient ingredient2;

    @Before
    public void setUp (){
        Mockito.when(ingredient.getType()).thenReturn(FILLING);
        Mockito.when(ingredient.getName()).thenReturn("Сыр");
        Mockito.when(ingredient.getPrice()).thenReturn(50f);

        Mockito.when(bun.getName()).thenReturn("Harry's");
        Mockito.when(bun.getPrice()).thenReturn(100f);
    }

    @Test
    public void addIngredientTest() {
        //Arrange
        Burger burger = new Burger();

        //Act
        burger.addIngredient(ingredient);

        //Assert
        Assert.assertTrue("Ингредиент не был добавлен!", burger.ingredients.contains(ingredient));
    }

    @Test
    public void removeIngredientTest() {
        //Arrange
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        int index = burger.ingredients.indexOf(ingredient);

        //Act
        burger.removeIngredient(index);

        //Assert
        Assert.assertEquals("Ингредиент не был удален!", 0, burger.ingredients.size());
    }
    @Test
    public void moveIngredientTest() {
        //Arrange
        Burger burger = new Burger();
        burger.addIngredient(ingredient);

        burger.addIngredient(ingredient2);
        int index = burger.ingredients.indexOf(ingredient);
        int newindex = index+1;

        //Act
        burger.moveIngredient(index, newindex);

        //Assert
        Assert.assertEquals("Ингредиент не был перемещен!", newindex, burger.ingredients.indexOf(ingredient));
    }

    @Mock
    Bun bun;

    @Test
    public void getPriceTest() {
        Burger burger = new Burger();

        //Arrange
        float expected = bun.getPrice()*2 + ingredient.getPrice();

        //Act
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        float actual = burger.getPrice();
        System.out.println("expected = "+expected + "    actual =" + actual );

        //Assert
        Assert.assertEquals("Цена не верная!", expected, actual, 0f);
    }

    @Test
    public void getReceiptTest() {
        Burger burger = new Burger();

        //Arrange
        String expected =
                "(==== Harry's ====)\r\n" +
                        "= filling Сыр =\r\n" +
                        "(==== Harry's ====)\r\n" +
                        "\r\nPrice: 250,000000\r\n";

        //Act
        burger.setBuns(bun);
        burger.addIngredient(ingredient);

        String actual = burger.getReceipt();

        //Assert
        Assert.assertEquals("Рецепт не верный!", expected, actual);
    }
}