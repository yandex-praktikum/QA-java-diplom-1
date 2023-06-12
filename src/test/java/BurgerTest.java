import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    Burger burger;
    Ingredient ingredient;
    @Mock
    Bun bun;
    @Mock
    Ingredient expectedIngredient;
    @Mock
    Ingredient secondIngredient;

    @Before
    public void setUp() {
        burger = new Burger();
    }

    @Test
    public void setBunsTest() {
        burger.setBuns(bun);
        Bun actual = burger.bun;
        assertEquals("Ошибка! Булочка должна быть выбрана", bun, actual);
    }

    @Test
    public void addIngredientTest() {
        burger.addIngredient(ingredient);
        assertTrue("Ошибка! Должны быть добавлены ингредиенты", burger.ingredients.size() != 0);
    }

    @Test
    public void removeIngredientTest() {
        Ingredient ingredient0 = new Ingredient(IngredientType.SAUCE, "Сырный", 100);
        burger.addIngredient(ingredient0);
        int expectedSizeAfterRemove = burger.ingredients.size() - 1;
        burger.removeIngredient(burger.ingredients.size() - 1);
        int actualSizeAfterRemove = burger.ingredients.size();
        Assert.assertEquals(expectedSizeAfterRemove, actualSizeAfterRemove);
    }

    @Test
    public void moveIngredientTest() {
        burger.addIngredient(expectedIngredient);
        burger.addIngredient(secondIngredient);
        burger.moveIngredient(0, 1);
        Ingredient actualIngredient = burger.ingredients.get(1);
        Assert.assertEquals(expectedIngredient, actualIngredient);
    }

    @Test
    public void getPriceTest() {
        Mockito.when(bun.getPrice()).thenReturn(50F);
        burger.setBuns(bun);
        Mockito.when(expectedIngredient.getPrice()).thenReturn(90F);
        burger.addIngredient(expectedIngredient);
        float actualPrice = burger.getPrice();
        float expectedPrice = (50*2 + 90);
        Assert.assertEquals(expectedPrice, actualPrice, 0);
        
    }

    @Test
    public void getReceiptTest() {
       Mockito.when(bun.getPrice()).thenReturn(50F);
        Mockito.when(bun.getName()).thenReturn("Белый хлеб");
        burger.setBuns(bun);
        Ingredient ingredient0 = new Ingredient(IngredientType.SAUCE, "Сырный", 100);
        burger.addIngredient(ingredient0);
        String expectedReceipt = burger.getReceipt();
        assertEquals("Ошибка! Не получился ожидаемый рецепт", expectedReceipt, burger.getReceipt());
    }
}
