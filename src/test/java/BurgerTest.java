import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Database;
import praktikum.Ingredient;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class BurgerTest {
    Burger burger;
    Database database = new Database();
    //2 набора ингредиентов из базы
    Ingredient ingredient_0 = database.availableIngredients().get(0);
    Ingredient ingredient_1 = database.availableIngredients().get(1);

    //стаб для булки
    public Bun getMockedBun() {
        Bun bun = database.availableBuns().get(0);
        Bun bunMock = mock(Bun.class);
        when(bunMock.getName()).thenReturn(bun.name);
        when(bunMock.getPrice()).thenReturn(bun.price);
        return bunMock;
    }

    //стаб для ингридиентов
    public Ingredient getMockedIngredient(Ingredient ingredient) {
        Ingredient ingredientMock = mock(Ingredient.class);
        when(ingredientMock.getType()).thenReturn(ingredient.type);
        when(ingredientMock.getName()).thenReturn(ingredient.name);
        when(ingredientMock.getPrice()).thenReturn(ingredient.price);
        return ingredientMock;
    }

    @Before
    public void setUp() {
        burger = new Burger();
    }

    @Test
    public void setBunsCheckWithMockData() {
        Bun bunExpected = getMockedBun();
        burger.setBuns(bunExpected);
        Assert.assertEquals(bunExpected, burger.bun);

    }

    @Test
    public void addIngredientCheckWithMockData() {
        Ingredient ingredientExpected = getMockedIngredient(ingredient_0);
        burger.addIngredient(ingredientExpected);
        Assert.assertEquals(ingredientExpected, burger.ingredients.get(0));
    }

    @Test
    public void removeIngredientCheckWithMockData() {
        Ingredient ingredient = getMockedIngredient(ingredient_0);
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        Assert.assertTrue(burger.ingredients.isEmpty());
    }

    @Test
    public void moveIngredientCheckWithMockData() {
        Ingredient firstIngredient = getMockedIngredient(ingredient_0);
        Ingredient secondIngredient = getMockedIngredient(ingredient_1);
        burger.addIngredient(firstIngredient);
        burger.addIngredient(secondIngredient);
        burger.moveIngredient(0, 1);
        Assert.assertEquals(firstIngredient.name, burger.ingredients.get(1).name);
    }

    @Test
    public void getPriceCheckWithMockData() {
        Bun bun = getMockedBun();
        Ingredient ingredient = getMockedIngredient(ingredient_0);
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        float actual = burger.getPrice();
        Assert.assertEquals(300, actual, 0);
    }

    @Test
    public void getReceiptCheckWithMockData() {
        Bun bun = getMockedBun();
        Ingredient ingredient = getMockedIngredient(ingredient_0);
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        String actual = burger.getReceipt();
        String expected = String.format("(==== black bun ====)%n" +
                "= sauce hot sauce =%n" +
                "(==== black bun ====)%n" +
                "%n" +
                "Price: 300,000000%n");
        Assert.assertEquals(expected, actual);
    }

}
