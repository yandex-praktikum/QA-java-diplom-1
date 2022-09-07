import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.mockito.Mockito.*;
import static praktikum.IngredientType.FILLING;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    private Burger burger;

    @Mock
    Bun bun;

    @Mock
    Ingredient ingredient;

    @Before
    public void setUp(){
        burger = new Burger();
    }

    @Test
    public void addBunTest(){
        burger.setBuns(bun);
        Assert.assertEquals(burger.bun,bun);
    }

    @Test
    public void addIngredientTest(){
        burger.addIngredient(ingredient);
        Assert.assertNotNull(burger.ingredients);
    }

    @Test
    public void priceCorrectTest(){
        float price = 1255;
        float expectedPrice = price * 2 + price;
        when(bun.getPrice()).thenReturn(price);
        when(ingredient.getPrice()).thenReturn(price);
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        Assert.assertTrue(expectedPrice == burger.getPrice());

    }

    @Test
    public void recieptTrueTest(){
        String nameBun = "Краторная булка N-200i";
        String nameIngredient = "Биокотлета из марсианской Магнолии";
        IngredientType ingredientType = FILLING;
        String expectedReceipt = String.format("(==== %s ====)" + "\r\n" +
                        "= %s %s =" + "\r\n" +
                        "(==== %s ====)" + "\r\n" + "\r\n" +
                        "Price: %f%n",
                nameBun, ingredientType.toString().toLowerCase(), nameIngredient, nameBun, ingredient.getPrice());
        burger.setBuns(bun);
        when(bun.getName()).thenReturn(nameBun);
        burger.addIngredient(ingredient);
        when(ingredient.getName()).thenReturn(nameIngredient);
        when(ingredient.getType()).thenReturn(ingredientType);
        Assert.assertEquals(expectedReceipt, burger.getReceipt());
    }

    @Test
    public void AddIngredientTest() {
        burger.addIngredient(ingredient);
        Assert.assertNotNull(burger.ingredients);
    }

    @Test
    public void replaceIngredientTest() {
        String name = "Филе Люминесцентного тетраодонтимформа";
        Ingredient mock = mock(Ingredient.class, withSettings().name(name));
        burger.addIngredient(ingredient);
        burger.addIngredient(mock);
        burger.moveIngredient(1, 0);
        Assert.assertEquals(burger.ingredients.get(0).toString(), name);
    }

    @Test
    public void deleteIngredientTest() {
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        Assert.assertTrue(burger.ingredients.isEmpty());
    }
}
