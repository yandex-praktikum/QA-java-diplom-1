package praktikum;

import java.util.List;

public class CreateBurger {
    Burger burger = new Burger();
    Database database = new Database();
    List<Ingredient> ingredients = database.availableIngredients();
    List<Bun> buns = database.availableBuns();

    public void createBurgerWithAllAction(){
        burger.setBuns(buns.get(0));

        burger.addIngredient(ingredients.get(1));
        burger.addIngredient(ingredients.get(4));
        burger.addIngredient(ingredients.get(3));
        burger.addIngredient(ingredients.get(5));

        burger.moveIngredient(2, 1);

        burger.removeIngredient(3);
    }
}
