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
    Burger burger;
    @Mock
    Bun bun;
    @Mock
    Ingredient firstIngredient;
    @Mock
    Ingredient secondIngredient;
    @Mock
    Ingredient thirdIngredient;

    @Before
    public void setUp() {
        burger = new Burger();
    }

    @Test
    public void addIngredientTest() {
        burger.addIngredient(firstIngredient);
        Assert.assertTrue(burger.ingredients.contains(firstIngredient));
    }

    @Test
    public void removeIngredientTest() {
        burger.addIngredient(firstIngredient);
        burger.removeIngredient(0);
        Assert.assertTrue("Ожидается бургер без ингредиентов", burger.ingredients.isEmpty());
    }

    @Test
    public void moveIngredientTest() {
        burger.addIngredient(firstIngredient);
        burger.addIngredient(secondIngredient);
        burger.moveIngredient(0, 1);
        Assert.assertEquals("Ингридиент не переместился", 1, burger.ingredients.indexOf(firstIngredient));
        Assert.assertEquals("Ингридиент не переместился", 0, burger.ingredients.indexOf(secondIngredient));
    }

    @Test
    public void getPriceTest() {
        Mockito.when(bun.getPrice()).thenReturn(988f);
        Mockito.when(firstIngredient.getPrice()).thenReturn(90f);
        Mockito.when(secondIngredient.getPrice()).thenReturn(424f);
        Mockito.when(thirdIngredient.getPrice()).thenReturn(4400f);
        burger.setBuns(bun);
        burger.addIngredient(firstIngredient);
        burger.addIngredient(secondIngredient);
        burger.addIngredient(thirdIngredient);

        float expected = 6890;
        Assert.assertEquals(String.format("Ожидаемая цена бургера: %f", expected), expected, burger.getPrice(), 0);
    }

    @Test
    public void getReceiptTest() {
        bun = new Bun("Флюоресцентная булка R2-D3", 988);
        firstIngredient = new Ingredient(IngredientType.SAUCE, "Соус Spicy-X", 90);
        secondIngredient = new Ingredient(IngredientType.FILLING, "Биокотлета из марсианской Магнолии", 424);
        thirdIngredient = new Ingredient(IngredientType.FILLING, "Мини-салат Экзо-Плантаго", 4400);

        burger.setBuns(bun);
        burger.addIngredient(firstIngredient);
        burger.addIngredient(secondIngredient);
        burger.addIngredient(thirdIngredient);

        String actual = burger.getReceipt();
        String expected = "(==== Флюоресцентная булка R2-D3 ====)\n" +
                "= sauce Соус Spicy-X =\n" +
                "= filling Биокотлета из марсианской Магнолии =\n" +
                "= filling Мини-салат Экзо-Плантаго =\n" +
                "(==== Флюоресцентная булка R2-D3 ====)\n" +
                "\n" +
                "Price: 6890,000000\n";

        Assert.assertEquals(String.format("Ожидаемый рецепт бургера:\n%s", expected), expected, actual);
    }
}