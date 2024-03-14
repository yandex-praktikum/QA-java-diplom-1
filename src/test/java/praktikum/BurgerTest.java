package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    private final Database database = Mockito.mock(Database.class);
    private int ingredientsSize;
    private Burger burger = Mockito.spy(Burger.class);
    private Bun bun;
    private List<Ingredient> ingredients;

    public BurgerTest() {
        List<Bun> buns = new ArrayList<>();
        buns.add(new Bun("black bun", 100));
        buns.add(new Bun("white bun", 200));
        buns.add(new Bun("red bun", 300));
        Mockito.when(database.availableBuns()).thenReturn(buns);
        List<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(new Ingredient(IngredientType.SAUCE, "hot sauce", 100));
        ingredients.add(new Ingredient(IngredientType.SAUCE, "sour cream", 200));
        ingredients.add(new Ingredient(IngredientType.SAUCE, "chili sauce", 300));
        ingredients.add(new Ingredient(IngredientType.FILLING, "cutlet", 100));
        ingredients.add(new Ingredient(IngredientType.FILLING, "dinosaur", 200));
        ingredients.add(new Ingredient(IngredientType.FILLING, "sausage", 300));
        Mockito.when(database.availableIngredients()).thenReturn(ingredients);
    }

    @Before
    public void setUp() {
        burger = Mockito.spy(Burger.class);
        bun = database.availableBuns().get(0);
        ingredients = database.availableIngredients();
        burger.setBuns(bun);
        for (int i = 0; i < ingredients.size(); i++) {
            burger.addIngredient(database.availableIngredients().get(i));
        }
        ingredientsSize = burger.ingredients.size();
    }

    @Test
    public void getValidBun() {
        assertEquals("Неправильная булочка", bun, burger.bun);
    }

    @Test
    public void getValidPrice() {
        float expectedPrice = 200;
        Mockito.when(burger.getPrice()).thenReturn(expectedPrice);
        assertEquals("Цена посчитана неправильно", expectedPrice, burger.getPrice(), 0);
    }

    @Test
    public void getValidReceipt() {
        StringBuilder receipt = new StringBuilder(String.format("(==== %s ====)%n", bun.getName()));
        for (Ingredient ingredient : ingredients) {
            receipt.append(String.format("= %s %s =%n", ingredient.getType().toString().toLowerCase(),
                    ingredient.getName()));
        }
        receipt.append(String.format("(==== %s ====)%n", bun.getName()));
        receipt.append(String.format("%nPrice: %f%n", burger.getPrice()));
        assertEquals("Неправильный рецепт", receipt.toString(), burger.getReceipt());
    }

    @Test
    public void getSizeAddIngredients() {
        burger.addIngredient(database.availableIngredients().get(1));
        assertEquals("Неправильное количество ингредиентов", ingredients.size() + 1, burger.ingredients.size());
    }

    @Test
    public void getSizeRemoveIngredient() {
        burger.removeIngredient(1);
        assertEquals("Ингредиент не удален", ingredientsSize - 1, burger.ingredients.size());
    }

    @Test
    public void getMovedIngredient() {
        Ingredient ingredientPosition = burger.ingredients.get(1);
        burger.moveIngredient(1, 0);
        Ingredient ingredientPositionAfterMoving = burger.ingredients.get(0);
        assertEquals("Элемент не на своем месте", ingredientPositionAfterMoving, ingredientPosition);
    }
}