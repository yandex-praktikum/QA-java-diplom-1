package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    Database database = new Database();

    Burger burger;
    int sizeOfBurgerIngredient;

    @Before
    public void createNewBurger() {

        burger = new Burger();
        for(int i = 0; i <= 5; i++) {
            burger.addIngredient(database.availableIngredients().get(i));
        }
        sizeOfBurgerIngredient = burger.ingredients.size();
    }

    @Mock
    Bun bun;

    @Test
    public void addIngredientTest(){
        assertEquals("Не хватает ингредиентов в бургере",6, sizeOfBurgerIngredient);
    }

    @Test
    public void removeIngredientTest(){
        burger.removeIngredient(4);
        int actual = burger.ingredients.size();
        int expected = sizeOfBurgerIngredient - 1;
        assertEquals("Ингредиент не удалили из бургера", expected, actual);
    }

    @Test
    public void moveIngredientTest(){
        Ingredient ingredientBeforeMoving = burger.ingredients.get(0);
        burger.moveIngredient(0, 4);
        Ingredient ingredientAfterMoving = burger.ingredients.get(4);
        assertEquals("Ингредиент не изменил места в бургере", ingredientAfterMoving, ingredientBeforeMoving);
    }

    @Test
    public void getPriceTest(){
        burger.setBuns(bun);
        Mockito.when(bun.getPrice()).thenReturn(300f);
        burger.addIngredient(database.availableIngredients().get(3));
        float actualPrice = burger.getPrice();
        assertEquals("Некорректная стоимость бургера", 1900f, actualPrice, 0.0f);
    }

    @Test
    public void getReceiptTest(){
        burger.setBuns(bun);
        List<Ingredient> ingredientList = new ArrayList<>(burger.ingredients);
        Mockito.when(bun.getName()).thenReturn("Булочка");
        String expected = "(==== " + bun.getName() + " ====)" + "\n" +
                "= sauce " + ingredientList.get(0).getName() + " =\n" +
                "= sauce " + ingredientList.get(1).getName() + " =\n" +
                "= sauce " + ingredientList.get(2).getName() + " =\n" +
                "= filling " + ingredientList.get(3).getName() + " =\n" +
                "= filling " + ingredientList.get(4).getName() + " =\n" +
                "= filling " + ingredientList.get(5).getName() + " =\n" +
                "(==== " + bun.getName() + " ====)" + "\n\n" +
                "Price: 1200.000000" + "\n";
        String actual = burger.getReceipt();

        assertEquals("Не соответствует информация в чеке", expected, actual);
    }

}
