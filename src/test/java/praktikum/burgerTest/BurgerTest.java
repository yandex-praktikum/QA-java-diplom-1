package praktikum.burgerTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTests {

    @Mock
    Burger burger;

    @Mock
    Ingredient ingredient;

    @Mock
    Bun bun;

    @Test
    public void burgerSetBunIsSuccessfulTest() {
        Bun bun = new Bun("black bun", 100.f);
        burger.setBuns(bun);
        burger.setBuns(bun);
        Mockito.verify(burger, Mockito.times(2)).setBuns(bun);
    }


    @Test
    public void burgerAddIngredientIsSuccessfulTest() {
        Burger burger = new Burger();
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, "hot sauce", 100.f);
        burger.addIngredient(ingredient);
        Ingredient actual = burger.ingredients.get(0);
        assertEquals("actual ingredient didn't match expected", ingredient, actual);
    }

    @Test
    public void burgerRemoveIngredientIsSuccessfulTest() {
        Burger burger = new Burger();
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, "hot sauce", 100.f);
        burger.ingredients.add(ingredient);
        burger.removeIngredient(0);
        boolean actual = burger.ingredients.contains(ingredient);
        assertEquals("contains invalid ingredient", false, actual);
    }

    @Test
    public void burgerMoveIngredientIsSuccessfulTest() {
        Burger burger = new Burger();
        burger.addIngredient(new Ingredient(IngredientType.FILLING, "dinosaur", 100.f));
        burger.addIngredient(new Ingredient(IngredientType.SAUCE, "sour cream", 200.f));
        burger.moveIngredient(1, 0);
        IngredientType actual = burger.ingredients.get(0).getType();
        assertEquals("get invalid ingredient type", IngredientType.SAUCE, actual);
    }

    @Test
    public void burgerGetPriceReturnValidPriceTest() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient);
        Mockito.when(bun.getPrice()).thenReturn(100.f);
        Mockito.when(ingredient.getPrice()).thenReturn(300.f);
        float actual = burger.getPrice();
        assertEquals("return invalid price", 800.f, actual, 0.0f);
    }

    @Test
    public void burgerGetReceiptReturnValidReceiptTest() {
        Burger burger = new Burger();
        Mockito.when(bun.getName()).thenReturn("black bun");
        Mockito.when(bun.getPrice()).thenReturn(100f);
        burger.setBuns(bun);
        Ingredient ingredient1 = new Ingredient(IngredientType.SAUCE, "sour cream", 200f);
        Ingredient ingredient2 = new Ingredient(IngredientType.FILLING, "dinosaur", 100f);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        String expected = "(==== black bun ====)" + "\r\n" + "= sauce sour cream =" + "\r\n" + "= filling dinosaur =" + "\r\n" + "(==== black bun ====)" + "\r\n" + "\r\n" + "Price: 500,000000" + "\r\n";
        String actual = burger.getReceipt();

        assertEquals("return invalid receipt", expected, actual);
    }

}