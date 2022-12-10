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

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    @Mock
    Bun bun;
    @Mock
    Ingredient firstIngredient;
    @Mock
    Ingredient secondIngredient;
    @Test
    public void getPriceReturnsCorrectValueTest(){
        Burger burger = new Burger();
        Mockito.when(bun.getPrice()).thenReturn(100.00f);
        Mockito.when(firstIngredient.getPrice()).thenReturn(200.00f);
        Mockito.when(secondIngredient.getPrice()).thenReturn(50f);
        burger.setBuns(bun);
        burger.addIngredient(firstIngredient);
        burger.addIngredient(secondIngredient);
        Assert.assertEquals("Incorrect price",450.00f,burger.getPrice(),0);
    }

    @Test
    public void getReceiptReturnsCorrectStringTest() {
        Burger burger = new Burger();
        Mockito.when(bun.getName()).thenReturn("bulka");
        Mockito.when(firstIngredient.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(firstIngredient.getName()).thenReturn("ketchup");
        Mockito.when(secondIngredient.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(secondIngredient.getName()).thenReturn("kotletos");
        Mockito.when(bun.getPrice()).thenReturn(100.0f);
        Mockito.when(firstIngredient.getPrice()).thenReturn(50.0f);
        Mockito.when(secondIngredient.getPrice()).thenReturn(200.0f);

        burger.addIngredient(firstIngredient);
        burger.addIngredient(secondIngredient);
        burger.setBuns(bun);

        String expectedResult = "(==== bulka ====)\r\n" +
                "= sauce ketchup =\r\n" +
                "= filling kotletos =\r\n" +
                "(==== bulka ====)\r\n" +
                "\r\n" +
                "Price: 450,000000\r\n";
        String actualResult = burger.getReceipt();

        Assert.assertEquals("Incorrect receipt", actualResult, expectedResult);
    }

    @Test
    public void removeIngredientTest(){
        Burger burger = new Burger();

        burger.addIngredient(firstIngredient);
        burger.addIngredient(secondIngredient);

        burger.removeIngredient(0);

        int expectedResult = 1;
        int actualResult = burger.ingredients.size();

        Assert.assertEquals("Incorrect ingredients number", actualResult, expectedResult);
    }

    @Test
    public void moveIngredientTest(){
        Burger burger = new Burger();
        Mockito.when(firstIngredient.getType()).thenReturn(IngredientType.SAUCE);
        burger.addIngredient(firstIngredient);
        burger.addIngredient(secondIngredient);
        burger.moveIngredient(1,0);
        Assert.assertEquals("Wrong ingredient", burger.ingredients.get(1).getType(), IngredientType.SAUCE);
    }

}
