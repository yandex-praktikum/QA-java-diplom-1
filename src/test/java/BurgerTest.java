import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

public class BurgerTest {

    @Mock
    Bun bun;

    @Mock
    Ingredient ingredient;

    @Mock
    Ingredient ingredient1;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void getPriceReturnsValidValue() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient1);
        float expectedResult = 160;

        Mockito.when(bun.getPrice()).thenReturn(20.0f);
        Mockito.when(ingredient.getPrice()).thenReturn(70.0f);
        Mockito.when(ingredient1.getPrice()).thenReturn(50.0f);

        float actualResult = burger.getPrice();

        Assert.assertEquals("Неправильная цена", expectedResult, actualResult, 0);
    }

    @Test
    public void getReceiptReturnsValidValue() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        String expectedResult = String.format("(==== Булка ====)%n" +
                "= sauce Кетчунез =%n" +
                "(==== Булка ====)%n" +
                "%n" +
                "Price: 50,000000%n");

        Mockito.when(bun.getName()).thenReturn("Булка");
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.valueOf("SAUCE"));
        Mockito.when(ingredient.getName()).thenReturn("Кетчунез");
        Mockito.when(burger.getPrice()).thenReturn(50f);

        String actualResult = burger.getReceipt();

        Assert.assertEquals("Неправильный рецепт", expectedResult, actualResult);
    }

    @Test
    public void removeIngredientWorksCorrectly() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);

        burger.removeIngredient(0);

        Assert.assertTrue("Все еще есть ингредиенты", burger.ingredients.isEmpty());
    }

    @Test
    public void moveIngredientWorksCorrectly() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient1);

        burger.moveIngredient(0, 1);

        Assert.assertSame(burger.ingredients.get(1), ingredient);
        Assert.assertSame(burger.ingredients.get(0), ingredient1);
    }

    @Test
    public void addIngredientWorksCorrectly() {
        Burger burger = new Burger();
        burger.setBuns(bun);

        burger.addIngredient(ingredient);

        Assert.assertFalse("Нет ингридиентов", burger.ingredients.isEmpty());
    }
}
