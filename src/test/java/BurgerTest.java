import org.junit.Before;
import org.junit.Test;
import praktikum.*;

import static org.junit.Assert.*;

public class BurgerTest {

    private Burger burger;
    private final Database database = new Database();

    @Before
    public void setUp() {
        burger = new Burger();
    }

    @Test
    public void setBunsReturnBlackBun() {
        burger.setBuns(database.availableBuns().get(0));

        String expectResult = "black bun";
        String actualResult = burger.bun.getName();

        assertEquals("Название булочки не совпадает", expectResult,actualResult);
    }

    @Test
    public void setBunsReturn200() {
        burger.setBuns(database.availableBuns().get(1));
        float expectResult = 200F;
        float actualResult = burger.bun.getPrice();

        assertEquals("Цена булочки не совпадает", expectResult,actualResult, 0);
    }

    @Test
    public void addIngredientReturnOne() {
        burger.addIngredient(database.availableIngredients().get(0));
        int expectResult = 1;
        int actualResult = burger.ingredients.size();

        assertEquals("Размер списка не совпадает", expectResult,actualResult);
    }
    //
    @Test
    public void removeIngredientReturnTwo() {
        burger.addIngredient(database.availableIngredients().get(0));
        burger.addIngredient(database.availableIngredients().get(1));
        burger.addIngredient(database.availableIngredients().get(2));
        burger.removeIngredient(0);

        int expectResult = 2;
        int actualResult = burger.ingredients.size();

        assertEquals("Размер списка после удаления не совпадает", expectResult,actualResult);
    }
    @Test
    public void moveIngredientReturnHotSauce() {
        burger.addIngredient(database.availableIngredients().get(0));
        burger.addIngredient(database.availableIngredients().get(1));
        burger.addIngredient(database.availableIngredients().get(2));
        burger.moveIngredient(0,2);

        String expectResult = "hot sauce";
        String actualResult = burger.ingredients.get(2).getName();

        assertEquals("Значения после переноса не совпадают", expectResult,actualResult);
    }

    @Test
    public void getPriceReturn1000() {
        burger.setBuns(database.availableBuns().get(2));

        burger.addIngredient(database.availableIngredients().get(0));
        burger.addIngredient(database.availableIngredients().get(5));

        float expectResult = 1000;
        float actualResult = burger.getPrice();

        assertEquals("Цены не совпадают", expectResult, actualResult, 0);

    }

    @Test
    public void getPriceReturnRedBunAndHotSauce() {
        burger.setBuns(database.availableBuns().get(2));
        burger.addIngredient(database.availableIngredients().get(0));
        burger.getReceipt();

        String expectResult = String.format("(==== %s ====)%n= %s %s =%n(==== %s ====)%n%nPrice: %f%n", "red bun", "sauce", "hot sauce", "red bun", 700.000000);
        String actualResult = burger.getReceipt();

        assertEquals ("Рецепт не совпадает",expectResult, actualResult);
    }

}
