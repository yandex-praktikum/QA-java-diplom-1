import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Database;
import praktikum.Ingredient;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    Database dataBase = new Database();

    private Burger burger;
    final int allBurgerIngredients = dataBase.availableIngredients().size();

    @Before
    public void startUp() {
        burger = new Burger();
    }

    @Mock
    private Bun mockBun;

    @Test
    public void addIngredientBurgerTest() {

        for(int i = 0; i < allBurgerIngredients; i++) {
            burger.addIngredient(dataBase.availableIngredients().get(i));
        }
        int actualCount = burger.ingredients.size();

        assertEquals("Ингридиенты не были добавлены", allBurgerIngredients, actualCount);

    }

    @Test
    public void removeIngredientBurgerTest() {

        for(int i = 0; i < allBurgerIngredients; i++) {
            burger.addIngredient(dataBase.availableIngredients().get(i));
        }
        burger.removeIngredient(allBurgerIngredients-1);
        int actualCount = burger.ingredients.size();

        assertEquals("Ингредиент не был удален",allBurgerIngredients-1, actualCount);
    }

    @Test
    public void moveIngredientBurgerTest() {

        for(int i = 0; i < allBurgerIngredients; i++) {
            burger.addIngredient(dataBase.availableIngredients().get(i));
        }
        Ingredient ingredient = burger.ingredients.get(allBurgerIngredients-1);
        burger.moveIngredient(allBurgerIngredients-1, 0);

        assertEquals("Ингредиент не был перемещен", burger.ingredients.get(0), ingredient);
    }

    @Test
    public void getPriceBurgerTest() {

        burger.setBuns(mockBun);
        // when(mockBun.getName()).thenReturn("Краторная булка N-200i");
        when(mockBun.getPrice()).thenReturn(1255f);

        burger.addIngredient(dataBase.availableIngredients().get(1));

        float actualPrice = burger.getPrice();
        float expectedPrice = 2*1255+dataBase.availableIngredients().get(1).getPrice();

        assertEquals("Стоимость бургера подсчитана некорректно",expectedPrice, actualPrice, 0);
    }

    @Test
    public void getReceiptTest(){

        burger.setBuns(mockBun);
        when(mockBun.getName()).thenReturn("Краторная булка N-200i");

        burger.addIngredient(dataBase.availableIngredients().get(0));
        String ingredient = dataBase.availableIngredients().get(0).getName();

        assertTrue("В рецепте указаны некорректные данные",burger.getReceipt().contains("Краторная булка N-200i")&&burger.getReceipt().contains(ingredient));

    }

}
