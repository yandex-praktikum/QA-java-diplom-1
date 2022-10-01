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
    Ingredient ingredient;

    //Тест на получение цены
    @Test
    public void getPriceTest(){
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        Mockito.when(bun.getPrice()).thenReturn(100.0f);
        Mockito.when(ingredient.getPrice()).thenReturn(200.0f);

        float expectedResult = 400.0f;
        float actualResult = burger.getPrice();

        Assert.assertEquals("Wrong price", actualResult, expectedResult, 0.0f);
    }

    //Тест на получение чека
    @Test
    public void getReceiptTest() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        Mockito.when(bun.getName()).thenReturn("bulka");
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredient.getName()).thenReturn("gorchica");
        Mockito.when(bun.getPrice()).thenReturn(100.0f);
        Mockito.when(ingredient.getPrice()).thenReturn(200.0f);

        String expectedResult = "(==== bulka ====)\r\n" +
                "= sauce gorchica =\r\n" +
                "(==== bulka ====)\r\n" +
                "\r\n" +
                "Price: 400,000000\r\n";
        String actualResult = burger.getReceipt();

        Assert.assertEquals("Wrong receipt", actualResult, expectedResult);
    }

    //Тест на удаление ингредиента
    @Test
    public void removeIngredientTest(){
        Burger burger = new Burger();

        burger.addIngredient(new Ingredient(IngredientType.SAUCE, "sauce", 0.0f));
        burger.addIngredient(new Ingredient(IngredientType.FILLING, "filling", 0.0f));

        burger.removeIngredient(1);

        int expectedResult = 1;
        int actualResult = burger.ingredients.size();

        Assert.assertEquals("Wrong size", actualResult, expectedResult);
    }

    //Тест на перемещение ингредиента
    @Test
    public void moveIngredientTest(){
        Burger burger = new Burger();

        burger.addIngredient(new Ingredient(IngredientType.SAUCE, "sauce", 0.0f));
        burger.addIngredient(new Ingredient(IngredientType.FILLING, "filling", 0.0f));

        burger.moveIngredient(1,0);

        IngredientType expectedResult = IngredientType.SAUCE;
        IngredientType actualResult = burger.ingredients.get(1).getType();

        Assert.assertEquals("Wrong ingredient", actualResult, expectedResult);
    }
}
