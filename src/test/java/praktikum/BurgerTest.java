package praktikum;

import org.junit.Test;
import java.util.List;
import static org.junit.Assert.*;

public class BurgerTest {

    IngredientType anyIngredientType;
    Ingredient ingredient;
    float anyPrice;

    @Test
    public void bunSetterTest() { //works always
        Burger burger = new Burger();
        Bun bun = new Bun("testBun", 1);
        String expectedBunName = "testBun";
        burger.setBuns(bun);
        String actualBunName = bun.getName();
        assertEquals("Bun setter (class Burger) doesn't work", expectedBunName, actualBunName);
    }

    @Test
    public void addIngredientTest() {
        Ingredient ingredient = new Ingredient(anyIngredientType, "TestIngredientName", anyPrice);
        Burger burger = new Burger();  //создали бургер без всего, в нем же создался ingredients
        burger.addIngredient(ingredient);
        String expectedTestIngredientName = "TestIngredientName";
        String actualTestIngredientName = (burger.ingredients.get(burger.ingredients.size()-1)).getName();
        assertEquals("Add method (class Burger) doesn't add an element to the list", expectedTestIngredientName, actualTestIngredientName);
    }

    @Test
    public void removeIngredientTest() {
        Burger burger = new Burger();  //создали бургер без всего, в нем же создался ingredients
        burger.ingredients.add(ingredient);
        burger.removeIngredient(0);
        assertTrue("Remove method (class Burger) doesn't delete an element from the list",burger.ingredients.isEmpty());
    }

    @Test
    public void getReceiptTest() {
        Database database = new Database();
        Burger burger = new Burger();

        List<Bun> buns = database.availableBuns();
        List<Ingredient> ingredients = database.availableIngredients();

        burger.setBuns(buns.get(0));
        burger.addIngredient(ingredients.get(1));
        burger.addIngredient(ingredients.get(4));

        String actualResult = burger.getReceipt();
        String finalPrice = "" + burger.getPrice();
        //System.out.println(actualResult);

        assertTrue("The receipt doesn't contain correct bun information",actualResult.contains("bun"));
        assertTrue("The receipt doesn't contain correct sauce information",actualResult.contains("sauce"));
        assertTrue("The receipt doesn't contain correct filling information",actualResult.contains("filling"));
        assertTrue("The receipt doesn't contain correct price information",actualResult.contains("Price"));
        assertTrue("The receipt doesn't contain correct value of final price",actualResult.contains(finalPrice));
    }
}
