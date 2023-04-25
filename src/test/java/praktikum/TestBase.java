package praktikum;

import org.javatuples.Pair;
import org.javatuples.Triplet;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;


public class TestBase {

    protected Burger buildBurger(Bun bun, Ingredient... ingredients) {
        Burger burger = new Burger();
        burger.setBuns(bun);
        Arrays.stream(ingredients).forEach(burger::addIngredient);
        return burger;
    }

    protected void createIngredientStub(Ingredient ingredient, String ingredientName, Float ingredientPrice, String ingredientType) {
        if (ingredientName != null) {
            Mockito.when(ingredient.getName()).thenReturn(ingredientName);
        }
        if (ingredientPrice != null) {
            Mockito.when(ingredient.getPrice()).thenReturn(ingredientPrice);
        }
        if (ingredientType != null) {
            Mockito.when(ingredient.getType()).thenReturn(IngredientType.valueOf(ingredientType));
        }
    }

    protected void createBunStub(Bun bun, String bunName, Float bunPrice) {
        if (bunName != null) {
            Mockito.when(bun.getName()).thenReturn(bunName);
        }

        if (bunPrice != null) {
            Mockito.when(bun.getPrice()).thenReturn(bunPrice);
        }
    }


    public String buildReceipt(Pair<String, Float> bun, List<Triplet<String, Float, String>> ingredients) {
        StringBuilder receipt = new StringBuilder(String.format("(==== %s ====)%n", bun.getValue0()));

        for (Triplet<String, Float, String> ingredient : ingredients) {
            receipt.append(String.format("= %s %s =%n", ingredient.getValue2().toLowerCase(),
                    ingredient.getValue0()));
        }
        Float ingredientsSum = ingredients.stream().map(Triplet::getValue1).reduce((acc, i) -> {
            acc += i;
            return acc;
        }).orElse(0f);
        receipt.append(String.format("(==== %s ====)%n", bun.getValue0()));
        receipt.append(String.format("%nPrice: %f%n", ingredientsSum + bun.getValue1() * 2));

        return receipt.toString();
    }
}

