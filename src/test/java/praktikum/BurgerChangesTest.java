package praktikum;

import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;


public class BurgerChangesTest {

    Burger burger = new Burger();
    public List<Ingredient> burgerIngredients = new ArrayList<>();

    private void burgerIngredients() {
        burgerIngredients.add(new Ingredient(IngredientType.SAUCE, "hot sauce", 190));
        burgerIngredients.add(new Ingredient(IngredientType.FILLING, "chicken", 200));
        burgerIngredients.add(new Ingredient(IngredientType.FILLING, "fish", 600));
        burgerIngredients.add(new Ingredient(IngredientType.SAUCE, "mustard", 100));
        for (Ingredient ingredients : burgerIngredients) {
            burger.addIngredient(ingredients);
        }
    }

    @Test
    public void removeIngredientTest() {
        burgerIngredients();
        burger.removeIngredient(3);
        assertEquals(burgerIngredients.size() - 1, burger.ingredients.size());
    }

    @Test
    public void moveIngredientTest(){
        burgerIngredients();
        burger.moveIngredient(0,2);
        assertEquals(burgerIngredients.get(0).name, burger.ingredients.get(2).name);
    }
}
