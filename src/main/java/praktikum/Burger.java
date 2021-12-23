package praktikum;

import java.util.ArrayList;
import java.util.List;

/**
 * Модель бургера.
 * Бургер состоит из булочек и ингредиентов (начинка или соус).
 * Ингредиенты можно перемещать и удалять.
 * Можно распечать чек с информацией о бургере.
 */
public class Burger {

    public Bun bun;
    public List<Ingredient> ingredients = new ArrayList<>();

    public void setBuns(Bun bun) {
        this.bun = bun;
    }

    public void addIngredient(Ingredient ingredient) {
        ingredients.add(ingredient);
    }

    public void removeIngredient(int index) {
        ingredients.remove(index);
    }

    public void moveIngredient(int index, int newIndex) {
        ingredients.add(newIndex, ingredients.remove(index));
    }

    public float getPrice() {
        float price = bun.getPrice() * 2;

        for (Ingredient ingredient : ingredients) {
            price += ingredient.getPrice();
        }

        return price;
    }

    public String getRecipe() {
        StringBuilder recipe = new StringBuilder(String.format("(==== %s ====)%n", bun.getName()));

        for (Ingredient ingredient : ingredients) {
            recipe.append(String.format("= %s %s =%n", ingredient.getType().toString().toLowerCase(),
                    ingredient.getName()));
        }

        recipe.append(String.format("(==== %s ====)%n", bun.getName()));
        recipe.append(String.format("%nPrice: %f%n", getPrice()));

        return recipe.toString();
    }

}