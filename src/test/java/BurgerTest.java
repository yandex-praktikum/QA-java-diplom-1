import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.*;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    private Burger burger;
    Database dataBase;
    private List<Ingredient> burgerIngredients;

    @Mock
    private Bun bun;
    @Mock
    private Ingredient ingredientSause;

    @Before
    public void start() {
        burger = new Burger();
        dataBase = new Database();
        burgerIngredients = dataBase.availableIngredients();
        MockitoAnnotations.openMocks(this);
        Mockito.when(bun.getName()).thenReturn("Флюоресцентная булка R2-D3");
        Mockito.when(bun.getPrice()).thenReturn(988f);
        Mockito.when(ingredientSause.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredientSause.getName()).thenReturn("hot sauce");
        Mockito.when(ingredientSause.getPrice()).thenReturn(100f);
    }

    @Test
    public void setBunsTest() {
        burger.setBuns(bun);
        Assert.assertNotNull("Метод setBuns(Bun bun) не сработал", burger.bun);
    }

    @Test
    public void addIngredientTest() {
        burger.addIngredient(burgerIngredients.get(0));
        int actualSize = burger.ingredients.size();
        assertEquals("Ошибка при добавлении ингридиента", 1, actualSize);
    }

    @Test
    public void removeIngredientTest() {
        burger.addIngredient(burgerIngredients.get(1));
        burger.removeIngredient(0);
        int actualSize = burger.ingredients.size();
        assertEquals("Ошибка при удалении ингридиента", 0, actualSize);
    }

    @Test
    public void moveIngredientTest() {
        burger.addIngredient(burgerIngredients.get(0));
        burger.addIngredient(burgerIngredients.get(1));
        burger.moveIngredient(0, 1);
        assertEquals("Ошибка при перемещении ингридиента", "sour cream", burger.ingredients.get(0).name);
    }

    @Test
    public void getPriceTest() {
        burger.setBuns(bun);
        burger.addIngredient(ingredientSause);
        float expectedPrice = bun.getPrice() * 2 + ingredientSause.getPrice();
        float actualPrice = burger.getPrice();
        assertEquals("Ошибка при подсчете цены бургера", expectedPrice, actualPrice, 0.01f);
    }

    @Test
    public void getReceiptTest() {
        burger.setBuns(bun);
        burger.addIngredient(ingredientSause);

        String expectedPrice = String.format("%nPrice: %f%n", bun.getPrice() * 2 + ingredientSause.getPrice());
        assertTrue("Рецепт не содержит нужную булку", burger.getReceipt().contains("Флюоресцентная булка R2-D3"));
        assertTrue("Рецепт не содержит нужнуй ингридиент", burger.getReceipt().contains("hot sauce"));
        assertTrue("Цена бургера в рецепте некорректна", burger.getReceipt().contains(expectedPrice));
    }

    @After
    public void tearDown() {
        burger.ingredients.clear();
        burger.bun = null;
    }

}
