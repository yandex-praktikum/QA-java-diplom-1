package praktikum;

import org.junit.Test;


public class BurgerTest {


    Burger burger = new Burger();
    Bun bun = new Bun("black bun", 100);
    Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "hot sauce", 100);


    @Test
    public void setBunsTest() {
        burger.setBuns(bun);
        boolean result = burger.bun.equals(bun);
        assert result;
    }

    @Test
    public void addIngredientTest() {
     int expected = burger.ingredients.size();
       burger.addIngredient(ingredient);
      int result = burger.ingredients.size();
      assert result == expected + 1;
      System.out.println(burger.ingredients.size());
    }

    @Test
    public void removeIngredientTest() {
        burger.ingredients.add(ingredient);
        int expected = burger.ingredients.size();
        burger.removeIngredient(0);
        int result = burger.ingredients.size();
        assert result == expected - 1;
    }

    @Test
    public void moveIngredientTest() {
        Ingredient ingredientTwo = new Ingredient(IngredientType.FILLING, "cutlet", 100);
        burger.ingredients.add(ingredient);
        burger.ingredients.add(ingredientTwo);
        Ingredient expexted = burger.ingredients.get(1);
        burger.moveIngredient(1,0);
        Ingredient actual = burger.ingredients.get(0);
        assert(actual.equals(expexted));

    }


}