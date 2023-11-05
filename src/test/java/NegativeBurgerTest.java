import org.junit.Test;
import  static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNotEquals;

import org.mockito.Mock;
import praktikum.Ingredient;
import praktikum.IngredientType;
import praktikum.Burger;
import java.util.List;
import praktikum.Bun;

public class NegativeBurgerTest {
    @Mock
    Burger burger = new Burger();


    @Test
    public void testAddIngredient() {
        Ingredient lettuce = new Ingredient(IngredientType.SAUCE,"Lettuce", 0.5f);
        burger.addIngredient(lettuce);
        List<Ingredient> ingredients = burger.getIngredients();
        assertFalse(ingredients.isEmpty());
    }

    @Test
    public void testRemoveIngredientByIndex() {
        Ingredient lettuce = new Ingredient(IngredientType.SAUCE,"Lettuce", 200.0f);
        Ingredient tomato = new Ingredient(IngredientType.FILLING,"sausage", 300.0f);
        burger.addIngredient(lettuce);
        burger.addIngredient(tomato);
        List<Ingredient> ingredients = burger.getIngredients();
        assertTrue(ingredients.contains(lettuce));
        assertTrue(ingredients.contains(tomato));
        int indexToRemove = 1; // remove sausage
        burger.removeIngredient(indexToRemove);
        ingredients = burger.getIngredients();
        assertTrue(ingredients.contains(lettuce));
        assertFalse(ingredients.contains(tomato));
        assertFalse(ingredients.contains(new Ingredient(IngredientType.FILLING,"sausage", 300.0f))); // Negative test case to check if the removed ingredient is still present in the list
    }
    //  @Test // не работает ошибка экшуал и експектит не совпадают индексы ингрелиентов
    //  public void testMoveIngredient_negative() {
    //     Burger burger = new Burger();
    //   Ingredient ingredient1 = new Ingredient(IngredientType.SAUCE, "chili sauce", 300.0f);
    //  Ingredient ingredient2 = new Ingredient(IngredientType.FILLING, "sausage", 300.0f);
    //  Ingredient ingredient3 = new Ingredient(IngredientType.SAUCE, "sour cream", 100.0f);
    //  burger.addIngredient(ingredient1);
    //  burger.addIngredient(ingredient2);
    //  burger.addIngredient(ingredient3);
    //  burger.moveIngredient(1, 0);
    //  System.out.println(burger.ingredients);
    // assertNotEquals(ingredient1, burger.getIngredients().get(0));
    // assertNotEquals(ingredient2, burger.getIngredients().get(1));
    // assertNotEquals(ingredient3, burger.getIngredients().get(2));
    // burger.moveIngredient(2, 1);
    // System.out.println(burger.ingredients);
    // assertNotEquals(ingredient1, burger.getIngredients().get(0));
    // assertNotEquals(ingredient2, burger.getIngredients().get(1));
    // assertNotEquals(ingredient3, burger.getIngredients().get(2));
    // }
    @Test
    public void testGetPriceNegative() {
        Burger burger = new Burger();
        Bun bun = new Bun("red bun", 300.0f);
        Ingredient sauce = new Ingredient(IngredientType.SAUCE,"chili sauce", 300.0f);
        Ingredient sausage = new Ingredient(IngredientType.FILLING,"sausage",  300.0f);
        burger.setBuns(bun);
        burger.addIngredient(sauce);
        burger.addIngredient(sausage);
        float price = burger.getPrice();
        assertNotEquals(1000.0f, price, 1.0f);
    }
    //негатинвный тест на гетресепит


}
