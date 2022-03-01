import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Database;
import praktikum.Ingredient;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    @Mock
    Bun bun;

    @Mock
    Ingredient ingredient;

    Burger burger = new Burger();

    @Test
    public void setBunTest() {
        burger.setBuns(bun);
        assertNotNull("Нет булочки",burger.bun);
    }

    @Test
    public void addIngredientTest() {
        burger.addIngredient(ingredient);
        assertNotNull("нет начинки",burger.ingredients);
    }

    @Test
    public void removeIngredient(){
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        assertFalse("удаление не работает",burger.ingredients.contains(ingredient));
    }

    @Test
    public void moveIngredientTest(){
        Database database = new Database();
        burger.addIngredient(database.availableIngredients().get(1));
        burger.addIngredient(ingredient);
        Ingredient firstPosition =  burger.ingredients.get(0);
        burger.moveIngredient(0, 1);
        assertNotEquals("не изменяется место в списке",firstPosition, burger.ingredients.get(0));
    }

    @Test
    public void getPriceTest(){
        Database database = new Database();
        burger.setBuns(database.availableBuns().get(0));
        float bunPrice = database.availableBuns().get(0).price;
        burger.addIngredient(database.availableIngredients().get(0));
        float ingredientPrice = database.availableIngredients().get(0).price;
        float correctPrice = (bunPrice*2) + ingredientPrice;
        assertEquals("не считается цена",correctPrice, burger.getPrice(),0.000001);
    }

    @Test
    public void receiptHasBunNameTest(){
        Database database = new Database();
        burger.setBuns(database.availableBuns().get(0));
        String bunName = database.availableBuns().get(0).name;
        assertTrue("нет булочки в чеке", burger.getReceipt().contains(bunName));
    }
    @Test
    public void receiptHasBunPriceTest(){
        Database database = new Database();
        burger.setBuns(database.availableBuns().get(0));
        int burgerPrice = (int)burger.getPrice();
        assertTrue("нет названия в чеке",burger.getReceipt().contains(Integer.toString(burgerPrice)));
    }

    @Test
    public void receiptHasIngredientTypeTest(){
        Database database = new Database();
        burger.setBuns(bun);
        burger.addIngredient(database.availableIngredients().get(0));
        String ingredientType = database.availableIngredients().get(0).type.toString();
        assertTrue("нет начинки в чеке",burger.getReceipt().contains(ingredientType.toLowerCase()));
    }
}
