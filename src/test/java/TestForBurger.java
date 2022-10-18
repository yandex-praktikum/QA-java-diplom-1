import org.junit.Test;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;

public class TestForBurger {
    Bun bun = new Bun("black bun", 100);
    Burger burger = new Burger();
    Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "chili sauce", 300);
    Ingredient ingredientSecond = new Ingredient(IngredientType.SAUCE, "sour cream", 200);

    @Test
    public void checkThePrice(){
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        burger.addIngredient(ingredientSecond);
        float price = burger.getPrice();
        assertEquals(price, 400, 0);
    }


}
