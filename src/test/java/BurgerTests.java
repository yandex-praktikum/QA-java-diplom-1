import org.junit.After;
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

public class BurgerTests {
    @Mock
    Bun bun;
    @Mock
    Ingredient cheese;
    @Mock
    Ingredient onion;
    @Mock
    Ingredient ketchup;
    @Mock
    Ingredient ketchunez;

    Burger burger;

    @Before
    public void init() {
        MockitoAnnotations.openMocks(this);
        burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(cheese);
        burger.addIngredient(onion);
        burger.addIngredient(ketchup);

        Mockito.when(bun.getPrice()).thenReturn(2.30f);
        Mockito.when(cheese.getPrice()).thenReturn(1.5f);
        Mockito.when(onion.getPrice()).thenReturn(4.0f);
        Mockito.when(ketchup.getPrice()).thenReturn(0.9f);

        Mockito.when(bun.getName()).thenReturn("Флюоресцентная булка R2-D3");
        Mockito.when(cheese.getName()).thenReturn("Сырочек");
        Mockito.when(onion.getName()).thenReturn("Лучок");
        Mockito.when(ketchup.getName()).thenReturn("Кетчуп");

        Mockito.when(cheese.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(onion.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ketchup.getType()).thenReturn(IngredientType.SAUCE);
    }

    @After
    public void shutdown() {
        burger.ingredients.clear();
        burger.bun = null;
    }

    @Test
    public void shouldSetBunInBurger() {
        burger.setBuns(bun);
        Assert.assertNotNull("Ошибка! Ожидается, что булочка добавится в бургер.", burger.bun);
    }

    @Test
    public void shouldAddIngredientInBurger() {
        burger.addIngredient(ketchunez);
        Assert.assertEquals("Ошибка! Ожидается 4-ре ингредиента в бургере.", 4, burger.ingredients.size());
    }

    @Test
    public void shouldRemoveIngredientFromBurger() {
        burger.removeIngredient(0);

        Assert.assertEquals("Ожидалось, что в списке будет 2 ингредиента", 2, burger.ingredients.size());
        Assert.assertFalse("Ожидалось, что в списке не будет найден сыр", burger.ingredients.contains(cheese));
    }

    @Test
    public void shouldMoveIngredientsInBurger() {
        burger.moveIngredient(1, 2);

        Assert.assertEquals("Ожидалось, что индекс ингредиента ЛУЧОК будет равен 2",
                2, burger.ingredients.indexOf(cheese));
    }

    @Test
    public void shouldGetPriceAllBurger() {
        float ingredientsSum = bun.getPrice() * 2 + cheese.getPrice() + onion.getPrice() + ketchup.getPrice();
        Assert.assertEquals("Ошибка! Неверная цена бургера", ingredientsSum,
                burger.getPrice(), 0);
    }

    @Test
    public void shouldGetReceiptReturnsAllIngredientsString() {
        String expectedReceipt = "(==== Флюоресцентная булка R2-D3 ====)\r\n" +
                "= filling Сырочек =\r\n" +
                "= filling Лучок =\r\n" +
                "= sauce Кетчуп =\r\n" +
                "(==== Флюоресцентная булка R2-D3 ====)\r\n" +
                "\r\n" +
                "Price: 11,000000\r\n";

        burger.setBuns(bun);
        Assert.assertEquals("Не получен ожидаемый рецепт", expectedReceipt, burger.getReceipt());
    }
}
