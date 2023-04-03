import org.junit.Assert;
import org.junit.Test;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.ArrayList;
import java.util.List;

public class BurgerTest {

    public Bun bun;
    public List<Ingredient> ingredients = new ArrayList<>();

    @Test
    public void checkAddIngredient(){

        Burger burger = new Burger();
        burger.addIngredient(new Ingredient(IngredientType.SAUCE,"hot sauce",100));
        burger.addIngredient(new Ingredient(IngredientType.SAUCE,"hot sauce",100));
        Assert.assertEquals(2,burger.ingredients.size());

    }
    @Test
    public void checkRemoveIngredient(){
        Burger burger = new Burger();
        burger.addIngredient(new Ingredient(IngredientType.SAUCE,"hot sauce",100));
        burger.addIngredient(new Ingredient(IngredientType.FILLING,"dinosaur",200));
        burger.removeIngredient(1);
        Assert.assertEquals(1,burger.ingredients.size());

    }
    @Test
    public void checkMoveIngredient(){

        Bun bun = new Bun("black bun",100);
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(new Ingredient(IngredientType.SAUCE,"hot sauce",100));
        burger.addIngredient(new Ingredient(IngredientType.FILLING,"dinosaur",200));
        StringBuilder receipt = new StringBuilder(String.format("(==== %s ====)%n", bun.getName()));

        for (Ingredient ingredient : ingredients) {
            receipt.append(String.format("= %s %s =%n", ingredient.getType().toString().toLowerCase(),
                    ingredient.getName()));
        }
        System.out.println(burger.getReceipt());
    }

    @Test
    public void checkPriceBurger(){
        Bun bun = new Bun("black bun",100);
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(new Ingredient(IngredientType.SAUCE,"hot sauce",100));
        float expected = 300;
        Assert.assertEquals(expected,expected,burger.getPrice());

    }


}
