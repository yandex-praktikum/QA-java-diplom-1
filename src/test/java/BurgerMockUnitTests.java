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
public class BurgerMockUnitTests {

    @Mock
    private Bun bunMock;

    @Mock
    private Ingredient ingredientMock;

    @Test
    public void setBuns() {
        Burger burger = new Burger();
        burger.setBuns(bunMock);
        Assert.assertEquals(bunMock, burger.bun);

    }

    @Test
    public void addIngredientBurgerTest() {
        Burger burger = new Burger();
        burger.addIngredient(ingredientMock);
        Assert.assertTrue(burger.ingredients.contains(ingredientMock));

    }

    @Test
    public void removeIngredientBurgerTest() {
        Burger burger = new Burger();
        burger.addIngredient(ingredientMock);
        burger.removeIngredient(0);
        Assert.assertFalse(burger.ingredients.contains(ingredientMock));
    }

    @Test
    public void moveIngredientBurgerTest() {
        Burger burger = new Burger();
        burger.addIngredient(new Ingredient(IngredientType.FILLING, "Говяжий метеорит (отбивная)", 3000));
        burger.addIngredient(new Ingredient(IngredientType.SAUCE, "Соус фирменный Space Sauce", 80));
        burger.moveIngredient(0, 1);
        Assert.assertEquals("Говяжий метеорит (отбивная)", burger.ingredients.get(1).name);
    }

    @Test
    public void getPriceBurgerTest() {
        Burger burger = new Burger();
        float price = 100;
        Mockito.when(bunMock.getPrice()).thenReturn(price);
        Mockito.when(ingredientMock.getPrice()).thenReturn(price);
        burger.setBuns(bunMock);
        burger.addIngredient(ingredientMock);
        Assert.assertEquals(price * 2 + price, burger.getPrice(), 0);
    }

    @Test
    public void getReceiptBurgerTest() {
        Burger burger = new Burger();
        burger.setBuns(bunMock);
        burger.addIngredient(new Ingredient(IngredientType.FILLING, "Мини-салат Экзо-Плантаго", 4400));
        burger.addIngredient(new Ingredient(IngredientType.SAUCE, "Соус Spicy-X", 90));
        String expectedReceipt = burger.getReceipt();
        Assert.assertEquals(expectedReceipt, burger.getReceipt());
    }
}
