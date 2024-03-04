package helpers;

import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;

import java.util.ArrayList;
import java.util.List;

public class MethodsHelpers {
    public static float returnBurgerTotalPrice(Bun bun, List<Ingredient> ingredients) {
        float price = bun.getPrice() * 2;
        for (Ingredient ingredient : ingredients) {
            price += ingredient.getPrice();
        }
        return price;
    }

    public static void addIngredients(Burger burger, List<Ingredient> ingredients) {
        for (Ingredient ingredient : ingredients) {
            burger.addIngredient(ingredient);
        }
    }

    public static List<Ingredient> addIngredientsToIngredientList(Ingredient... ingredients) {
        List<Ingredient> ingredientsList = new ArrayList<>();
        for (Ingredient ingredient : ingredients) {
            ingredientsList.add(ingredient);
        }
        return ingredientsList;
    }

    public static String getExpectedReceipt(Bun bun, List<Ingredient> ingredients) {
        StringBuilder expectedReceipt = new StringBuilder(String.format("(==== %s ====)%n", bun.getName()));

        for (Ingredient ingredient : ingredients) {
            expectedReceipt.append(String.format("= %s %s =%n", ingredient.getType().toString().toLowerCase(),
                    ingredient.getName()));
        }

        expectedReceipt.append(String.format("(==== %s ====)%n", bun.getName()));
        expectedReceipt.append(String.format("%nPrice: %f%n", returnBurgerTotalPrice(bun, ingredients)));

        return expectedReceipt.toString();
    }

    public static void setBurgerBunAndIngredients(Burger burger, Bun bun, List<Ingredient> ingredients) {
        burger.setBuns(bun);
        addIngredients(burger, ingredients);
    }
}
