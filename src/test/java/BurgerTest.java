import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.*;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    Burger burger = new Burger();
    Bun bun = new Bun("black bun", 100);

    @Mock
    Ingredient ingredient;

    @Test
    public void setBunTest() {
        burger.setBuns(bun);
        assertNotNull("Нет булки",burger.bun);
    }

    @Test
    public void addIngredientTest() {
        burger.addIngredient(ingredient);
        assertEquals("Ингридиент не был добавлен",1, burger.ingredients.size());
    }

    @Test
    public void removeIngredientTest() {
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        assertEquals("Ингридиент не был удален",0, burger.ingredients.size());
    }

    @Test
    public void moveIngredientTest() {
        burger.addIngredient(new Ingredient(IngredientType.SAUCE, "Соус Spicy-X", 90));
        burger.addIngredient(new Ingredient(IngredientType.FILLING, "Говяжий метеорит", 3000));
        burger.moveIngredient(0, 1);
        assertEquals("Ингридиенты не поменяли свои индексы", "Говяжий метеорит", burger.ingredients.get(0).name);
    }

    @Test
    public void getPriceTest(){
        Database database = new Database();
        burger.setBuns(database.availableBuns().get(0));
        float bunPrice = database.availableBuns().get(0).price;
        burger.addIngredient(database.availableIngredients().get(0));
        float ingredientPrice = database.availableIngredients().get(0).price;
        float correctPrice = (bunPrice*2) + ingredientPrice;
        assertEquals("Цена не считается",correctPrice, burger.getPrice(),0.000001);
    }

    @Test
    public void receiptHasBunNameTest(){
        Database database = new Database();
        burger.setBuns(database.availableBuns().get(0));
        String bunName = database.availableBuns().get(0).name;
        assertTrue("Нет булочки в чеке", burger.getReceipt().contains(bunName));
    }
    @Test
    public void receiptHasBunPriceTest(){
        Database database = new Database();
        burger.setBuns(database.availableBuns().get(0));
        int burgerPrice = (int)burger.getPrice();
        assertTrue("Нет названия в чеке", burger.getReceipt().contains(Integer.toString(burgerPrice)));
    }

    @Test
    public void receiptHasIngredientTypeTest(){
        Database database = new Database();
        burger.setBuns(bun);
        burger.addIngredient(database.availableIngredients().get(0));
        String ingredientType = database.availableIngredients().get(0).type.toString();
        assertTrue("Нет начинки в чеке",burger.getReceipt().contains(ingredientType.toLowerCase()));
    }
}