import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)


public class BurgerTest {

    @Mock
    Bun bun;
    @Mock
    List<Ingredient> ingredients;
    @Mock
    Ingredient ingredient1;
    Ingredient ingredient2;


    @Test
    public void addIngredientTest() {
        Burger burger = new Burger();
        List<Ingredient> expected = Arrays.asList(ingredient1, ingredient2);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);

        assertEquals("Количество ингредиентов не совпадает", 2, burger.ingredients.size());
        assertEquals("Ингредиенты не совпадают", expected, burger.ingredients);
    }

    @Test
    public void removeIngredientTest() {

        Burger burger = new Burger();
        List<Ingredient> expected = Arrays.asList(ingredient1);

        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.removeIngredient(1);

        assertEquals("Количество ингредиентов не совпадает", 1, burger.ingredients.size());
        assertEquals("Ингредиенты не совпадают", expected, burger.ingredients);

    }


    @Test
    public void getPriceTest() {
        Burger burger = new Burger();
        float priceBun = 2F;
        Ingredient ingredient1 = new Ingredient(IngredientType.FILLING, "Meat", 10F);
        Ingredient ingredient2 = new Ingredient(IngredientType.SAUCE, "Sauce", 1F);
        Mockito.when(bun.getPrice()).thenReturn(priceBun);
        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        float actual = burger.getPrice();
        float expected = 2 * priceBun + 10F + 1F;
        assertEquals(expected, actual, 0.1F);
    }

    @Test
    public void getReceiptTest() {
        Burger burger = new Burger();
        Ingredient ingredient1 = new Ingredient(IngredientType.FILLING, "testMeat", 10F);
        Ingredient ingredient2 = new Ingredient(IngredientType.SAUCE, "testSauce", 1F);
        Mockito.when(bun.getPrice()).thenReturn(2F);
        Mockito.when(bun.getName()).thenReturn("testBun");
        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        String expected = "(==== " + burger.bun.getName() + " ====)\r\n" +
                "= " + burger.ingredients.get(0).getType().toString().toLowerCase() + " " + burger.ingredients.get(0).getName() + " =\r\n" +
                "= " + burger.ingredients.get(1).getType().toString().toLowerCase() + " " + burger.ingredients.get(1).getName() + " =\r\n" +
                "(==== " + burger.bun.getName() + " ====)\r\n" +
                "\r\n" +
                "Price: " + String.format("%f", burger.getPrice()) + "\r\n";
        String actual = burger.getReceipt();

        assertEquals("Рецепты не совпадают", expected, actual);


    }

}
