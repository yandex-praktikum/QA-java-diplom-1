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
        Ingredient ingredient1 = new Ingredient(IngredientType.SAUCE, "Чесночный", 100);
        burger.addIngredient(ingredient0);
        burger.addIngredient(ingredient1);
        assertEquals("Ошибка! Ожидается, что добавлено 2 ингредиента", 2, burger.ingredients.size());
        burger.removeIngredient(0);
        assertFalse("Ошибка! Ожидается, что ингредиент с индексом 0 должен быть удален", burger.ingredients.contains(ingredient0));
    }

    @Test
    public void moveIngredientTest() {
        Ingredient ingredient0 = new Ingredient(IngredientType.SAUCE, "Сырный", 100);
        Ingredient ingredient1 = new Ingredient(IngredientType.SAUCE, "Чесночный", 100);
        burger.addIngredient(ingredient0);
        burger.addIngredient(ingredient1);
        assertEquals("Ошибка! Ожидается, что добавлено 2 ингредиента", 2, burger.ingredients.size());
        burger.moveIngredient(0, 1);
        assertEquals("Ожидается, что у соуса Сырный будет индекс 1", 1, burger.ingredients.indexOf(ingredient0));
    }

    @Test
    public void getPriceTest() {
        Mockito.when(bun.getPrice()).thenReturn(50F);
        burger.setBuns(bun);
        Ingredient ingredient0 = new Ingredient(IngredientType.SAUCE, "Сырный", 100);
        Ingredient ingredient1 = new Ingredient(IngredientType.FILLING, "Салат", 200);
        burger.addIngredient(ingredient0);
        burger.addIngredient(ingredient1);
        float sumIngredient = bun.getPrice() * 2 + ingredient0.price + ingredient1.price;
        assertEquals("Ошибка! Неверная цена бургера", sumIngredient, burger.getPrice(), 0);
    }

    @Test
    public void getReceiptTest() {
        Mockito.when(bun.getPrice()).thenReturn(50F);
        Mockito.when(bun.getName()).thenReturn("Белый хлеб");
        burger.setBuns(bun);
        Ingredient ingredient0 = new Ingredient(IngredientType.SAUCE, "Сырный", 100);
        Ingredient ingredient1 = new Ingredient(IngredientType.FILLING, "Салат", 200);
        burger.addIngredient(ingredient0);
        burger.addIngredient(ingredient1);
        String expectedReceipt = burger.getReceipt();
        assertEquals("Ошибка! Не получился ожидаемый рецепт", expectedReceipt, burger.getReceipt());
    }
}
