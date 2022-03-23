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
public class BurgerTest {

    @Mock
    private Bun bun;

    @Mock
    private Ingredient ingredient;

    Burger burger = new Burger();

    @Test
    public void addIngredientTest() {

        burger.addIngredient(ingredient);
        float actual = burger.ingredients.size();
        float expected = 4;
        assertEquals(4, expected,actual);

    }

    @Test
    public  void removeIngredientTest(){
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        int actual = burger.ingredients.size();
        int expected = 0;
        assertEquals(0,expected,actual);

    }

    @Test
    public void insertIngredientTest(){
        Ingredient sauce = new Ingredient(IngredientType.SAUCE, "Sauce with Antarian Flathead spikes", 88);
        Ingredient topping = new Ingredient(IngredientType.FILLING, "Mini salad Exo-Plantago", 4400);
        burger.addIngredient(sauce);
        burger.addIngredient(topping);
        burger.moveIngredient(0, 1);
        String expected = "Sauce with Antarian Flathead spikes";
        String actual = burger.ingredients.get(1).name;
        assertEquals("Sauce with Antarian Flathead spikes",expected,actual);

    }

    @Test
    public void getPriceTest(){
        float price = 88;
        float expected = price * 2 + price;
        Mockito.when(bun.getPrice()).thenReturn(price);
        Mockito.when(ingredient.getPrice()).thenReturn(price);
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        assertEquals(expected, burger.getPrice(), 0.0);
    }

    @Test
    public void getReceiptTest(){
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "Antarian Flathead spikes!", 88);
        Bun bun = new Bun("Fluorescent bun R2-D3", 988);
        burger.addIngredient(ingredient);
        burger.setBuns(bun);
        String actual = burger.getReceipt();
        String expected = String.format(("(==== " + bun.getName() + " ====)%n= " + ingredient.getType().toString().toLowerCase() + " " + ingredient.getName() + " =%n(==== " + bun.getName() + " ====)%n%nPrice: %f%n"), burger.getPrice());
        assertEquals("condition not met", expected, actual);
    }
}

