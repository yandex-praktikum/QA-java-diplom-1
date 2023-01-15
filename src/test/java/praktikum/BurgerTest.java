package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    Database database = Mockito.mock(Database.class);
    int ingredientsSize;
    Burger burger = Mockito.spy(Burger.class);
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
    public void createBurger() {
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
    public void returnsCorrectBun() {
        Assert.assertEquals("Неправильная булочка", bun, burger.bun);
    }

    @Test
    public void returnsCorrectSizeOfIngredientsAfterAdd() {
        burger.addIngredient(database.availableIngredients().get(1));
        Assert.assertEquals("Неправильное количество ингредиентов", ingredients.size() + 1, burger.ingredients.size());
    }

    @Test
    public void removeIngredientIsCorrect() {
        burger.removeIngredient(1);
        Assert.assertEquals("Ингредиент не удален", ingredientsSize - 1, burger.ingredients.size());
    }

    @Test
    public void movedIngredientInRightPlace() {
        Ingredient ingredientPosition = burger.ingredients.get(1);
        burger.moveIngredient(1, 0);
        Ingredient ingredientPositionAfterMoving = burger.ingredients.get(0);
        Assert.assertEquals("Элемент не на своем месте", ingredientPositionAfterMoving, ingredientPosition);
    }

    @Test
    public void returnsCorrectPrice() {
        float expectedPrice = 100f;
        Mockito.when(burger.getPrice()).thenReturn(expectedPrice);
        Assert.assertEquals("Цена посчитана неправильно", expectedPrice, burger.getPrice(), 0);
    }

    @Test
    public void returnsCorrectReceipt() {
        StringBuilder receipt = new StringBuilder(String.format("(==== %s ====)%n", bun.getName()));

        for (Ingredient ingredient : ingredients) {
            receipt.append(String.format("= %s %s =%n", ingredient.getType().toString().toLowerCase(),
                    ingredient.getName()));
        }

        receipt.append(String.format("(==== %s ====)%n", bun.getName()));
        receipt.append(String.format("%nPrice: %f%n", burger.getPrice()));

        Assert.assertEquals("Неправильный рецепт", receipt.toString(), burger.getReceipt());
    }

}
