import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.*;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    Burger burger = new Burger();
    Database database = new Database();

    @Mock
    Ingredient ingredient;
    @Mock
    Bun bun;

    @Test
    public void setBunTest() {
        Bun bun = new Bun(database.availableBuns().get(0).name, database.availableBuns().get(0).price);
        burger.setBuns(bun);
        assertNotNull("Нет булки",burger.bun);
    }

    @Test
    public void addIngredientTest() {
        burger.addIngredient(ingredient);
        assertEquals("Ингредиент не был добавлен",1, burger.ingredients.size());
    }

    @Test
    public void removeIngredientTest() {
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        assertEquals("Ингредиент не был удален",0, burger.ingredients.size());
    }

    @Test
    public void moveIngredientTest() {
        burger.addIngredient(new Ingredient(database.availableIngredients().get(0).type, database.availableIngredients().get(0).name, database.availableIngredients().get(0).price));
        burger.addIngredient(new Ingredient(database.availableIngredients().get(1).type, database.availableIngredients().get(1).name, database.availableIngredients().get(1).price));
        burger.moveIngredient(0, 1);
        assertEquals("Ингредиенты не поменяли свои индексы", database.availableIngredients().get(1).name, burger.ingredients.get(0).name);
    }

    @Test
    public void getPriceTest(){
        burger.setBuns(database.availableBuns().get(0));
        float bunPrice = database.availableBuns().get(0).price;
        burger.addIngredient(database.availableIngredients().get(0));
        float ingredientPrice = database.availableIngredients().get(0).price;
        float correctPrice = (bunPrice * 2) + ingredientPrice;
        assertEquals("Цена не считается",correctPrice, burger.getPrice(),0);
    }

    @Test
    public void getErrorWithBiggerPriceForBunTest(){
        burger.setBuns(database.availableBuns().get(0));
        Mockito.when(bun.getPrice()).thenReturn(101F);
        float bunPrice = bun.getPrice();
        float ingredientPrice = 0;
        float correctPrice = (bunPrice * 2) + ingredientPrice;
        assertNotEquals("Цена одинаковая",correctPrice, burger.getPrice(),0);
    }

    @Test
    public void getErrorWithLowerPriceForBunTest(){
        burger.setBuns(database.availableBuns().get(0));
        Mockito.when(bun.getPrice()).thenReturn(99F);
        float bunPrice = bun.getPrice();
        float ingredientPrice = 0;
        float correctPrice = (bunPrice * 2) + ingredientPrice;
        assertNotEquals("Цена одинаковая",correctPrice, burger.getPrice(),0);
    }

    @Test
    public void getErrorWithBiggerPriceForIngredientTest(){
        burger.setBuns(database.availableBuns().get(0));
        float bunPrice = bun.getPrice();
        Mockito.when(ingredient.getPrice()).thenReturn(101F);
        float ingredientPrice = ingredient.getPrice();
        float correctPrice = (bunPrice * 2) + ingredientPrice;
        assertNotEquals("Цена одинаковая",correctPrice, burger.getPrice(),0);
    }

    @Test
    public void getErrorWithLowerPriceForIngredientTest(){
        burger.setBuns(database.availableBuns().get(0));
        float bunPrice = bun.getPrice();
        Mockito.when(ingredient.getPrice()).thenReturn(99F);
        float ingredientPrice = ingredient.getPrice();
        float correctPrice = (bunPrice * 2) + ingredientPrice;
        assertNotEquals("Цена одинаковая",correctPrice, burger.getPrice(),0);
    }

    @Test
    public void receiptHasBunNameTest(){
        burger.setBuns(database.availableBuns().get(0));
        String bunName = database.availableBuns().get(0).name;
        assertTrue("Нет булочки в чеке", burger.getReceipt().contains(bunName));
    }

    @Test
    public void receiptHasBunPriceTest(){
        burger.setBuns(database.availableBuns().get(0));
        int burgerPrice = (int)burger.getPrice();
        assertTrue("Нет названия в чеке", burger.getReceipt().contains(Integer.toString(burgerPrice)));
    }

    @Test
    public void receiptHasIngredientTypeTest(){
        burger.setBuns(bun);
        burger.addIngredient(database.availableIngredients().get(0));
        String ingredientType = database.availableIngredients().get(0).type.toString();
        assertTrue("Нет начинки в чеке",burger.getReceipt().contains(ingredientType.toLowerCase()));
    }
}