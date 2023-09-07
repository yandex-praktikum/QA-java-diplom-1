import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

//Этот класс создан для того, что бы соотвествовать требованиям диплома о том, что нужно реализовать моки и стабы.
//Но как мне показалось можно и без них всё это реализовать (см.BurgerTest) в нем реализовано так же (данные могли чуть-чуть поменяться, но суть та же самая)
//Так же смотря по покрытию не стал реализовывать тесты под классы Ingredient и IngredientType класс BurgerTest и так всё покрыл тестами.
//Надеюсь на понимание. Буду рад получить обратную связь. Спасибо !

@RunWith(MockitoJUnitRunner.class)
public class BurgerExampleMockTest {

    private Burger burger;

    @Mock
    Database database;

    private  List<Bun> buns;
    private  List<Ingredient> ingredients;

    @Before
    public void setUp() {
        burger = new Burger();
        buns = new ArrayList<>();
        ingredients = new ArrayList<>();

        buns.add(new Bun("black bun", 100));
        buns.add(new Bun("white bun", 200));
        buns.add(new Bun("red bun", 300));

        ingredients.add(new Ingredient(IngredientType.SAUCE, "hot sauce", 100));
        ingredients.add(new Ingredient(IngredientType.SAUCE, "sour cream", 200));
        ingredients.add(new Ingredient(IngredientType.SAUCE, "chili sauce", 300));
    }

    @Test
    public void setBunsReturnBlackBun() {
        Mockito.when(database.availableBuns()).thenReturn(buns);
        burger.setBuns(database.availableBuns().get(0));

        String expectResult = "black bun";
        String actualResult = burger.bun.getName();

        assertEquals("Название булочки не совпадает", expectResult,actualResult);
    }

    @Test
    public void setBunsReturn200() {
        Mockito.when(database.availableBuns()).thenReturn(buns);
        burger.setBuns(database.availableBuns().get(1));
        float expectResult = 200F;
        float actualResult = burger.bun.getPrice();

        assertEquals("Цена булочки не совпадает", expectResult,actualResult, 0);
    }

    @Test
    public void addIngredientReturnOne() {
        Mockito.when(database.availableIngredients()).thenReturn(ingredients);
        burger.addIngredient(database.availableIngredients().get(0));
        int expectResult = 1;
        int actualResult = burger.ingredients.size();

        assertEquals("Размер списка не совпадает", expectResult,actualResult);
    }
    //
    @Test
    public void removeIngredientReturnTwo() {
        Mockito.when(database.availableIngredients()).thenReturn(ingredients);
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
        Mockito.when(database.availableIngredients()).thenReturn(ingredients);
        burger.addIngredient(database.availableIngredients().get(0));
        burger.addIngredient(database.availableIngredients().get(1));
        burger.addIngredient(database.availableIngredients().get(2));
        burger.moveIngredient(0,2);

        String expectResult = "hot sauce";
        String actualResult = burger.ingredients.get(2).getName();

        assertEquals("Значения после переноса не совпадают", expectResult,actualResult);
    }

    @Test
    public void getPriceReturn500() {
        Mockito.when(database.availableBuns()).thenReturn(buns);
        Mockito.when(database.availableIngredients()).thenReturn(ingredients);
        burger.setBuns(database.availableBuns().get(0));

        burger.addIngredient(database.availableIngredients().get(0));
        burger.addIngredient(database.availableIngredients().get(1));

        float expectResult = 500;
        float actualResult = burger.getPrice();

        assertEquals("Цены не совпадают", expectResult, actualResult, 0);

    }

    @Test
    public void getPriceReturnRedBunAndHotSauce() {
        Mockito.when(database.availableBuns()).thenReturn(buns);
        Mockito.when(database.availableIngredients()).thenReturn(ingredients);

        burger.setBuns(database.availableBuns().get(2));
        burger.addIngredient(database.availableIngredients().get(0));
        burger.getReceipt();

        String expectResult = String.format("(==== %s ====)%n= %s %s =%n(==== %s ====)%n%nPrice: %f%n", "red bun", "sauce", "hot sauce", "red bun", 700.000000);
        String actualResult = burger.getReceipt();

        assertEquals ("Рецепт не совпадает",expectResult, actualResult);
    }

}
