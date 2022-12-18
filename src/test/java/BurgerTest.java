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

    Burger burger;
    final private int ALL_INGREDIENTS = dataBase.availableIngredients().size();

    @Mock
    private Bun bun;

    @Before
    public void startUp() {
        burger = new Burger();
    }

    @Test
    public void addIngredientBurgerTest() {

        for(int i = 0; i < ALL_INGREDIENTS; i++) {
            burger.addIngredient(dataBase.availableIngredients().get(i));
        }
        int actualCount = burger.ingredients.size();

        assertEquals("Ошибка при добавлении ингредиента", ALL_INGREDIENTS, actualCount);

    }

    @Test
    public void removeIngredientBurgerTest() {

        for(int i = 0; i < ALL_INGREDIENTS; i++) {
            burger.addIngredient(dataBase.availableIngredients().get(i));
        }
        burger.removeIngredient(ALL_INGREDIENTS - 1);
        int actualCount = burger.ingredients.size();

        assertEquals("Ошибка при удалении ингредиента",ALL_INGREDIENTS - 1, actualCount);
    }

    @Test
    public void moveIngredientBurgerTest() {

        for(int i = 0; i < ALL_INGREDIENTS; i++) {
            burger.addIngredient(dataBase.availableIngredients().get(i));
        }
        Ingredient ingredient = burger.ingredients.get(ALL_INGREDIENTS - 1);
        burger.moveIngredient(ALL_INGREDIENTS - 1, 0);

        assertEquals("Ошибка при перемещении ингредиентов", burger.ingredients.get(0), ingredient);
    }

    @Test
    public void getReceiptTest(){

        burger.setBuns(bun);
        when(bun.getName()).thenReturn("Bulochka");

        burger.addIngredient(dataBase.availableIngredients().get(0));
        String ingredient = dataBase.availableIngredients().get(0).getName();

        assertTrue("Название ингредиента в рецепте не совпадает",burger.getReceipt()
                .contains("Bulochka") && burger.getReceipt()
                .contains(ingredient));
    }
}