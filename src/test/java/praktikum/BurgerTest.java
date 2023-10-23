package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.AdditionalMatchers.not;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class BurgerTest {

    Burger burger = new Burger();
    Bun bun = new Bun("Мучной", 2.00f);

    private final IngredientType type;
    private final String name;
    private final float price;

    public BurgerTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[] getIngredients() {
        return new Object[][]{
                {SAUCE, "name0", 2.0f},
                {FILLING, "name1", 1.0f}, // передали тестовые данные
        };
    }


    @Test
    public void setBuns() {
    }

    @Test
    public void addIngredient() {
        burger.addIngredient(new Ingredient(type, name, price));
        assertThat(burger.ingredients, notNullValue());
    }


    @Test
    public void removeIngredient() {
        burger.addIngredient(new Ingredient(type, name, price));
        burger.removeIngredient(0);
        assertThat(burger.ingredients.size(), equalTo(0));
    }

    //я честно хз как сделать проще чтобы переместились ингредиенты, чтобы руками не добавлять
    @Test
    public void moveIngredient() {
        Ingredient ingredient0 = new Ingredient(IngredientType.SAUCE, "Ketchup", 0.5f);
        Ingredient ingredient1 = new Ingredient(IngredientType.FILLING, "Cheese", 1.0f);
        burger.addIngredient(ingredient0);
        burger.addIngredient(ingredient1);
        burger.moveIngredient(0, 1);
        // Проверяем, что ингредиенты переместились правильно
        assertEquals(ingredient1, burger.ingredients.get(0));
        assertEquals(ingredient0, burger.ingredients.get(1));
    }



    @Test
    public void getPrice() {
        Ingredient ingredient0 = new Ingredient(IngredientType.SAUCE, "Ketchup", 2.0f);
        Ingredient ingredient1 = new Ingredient(IngredientType.FILLING, "Cheese", 1.0f);
        burger.addIngredient(ingredient0);
        burger.addIngredient(ingredient1);
        burger.setBuns(bun);
        burger.getPrice();
        assertThat(burger.getPrice(), equalTo(7.0f));
    }
    @Test
    public void getReceipt() {
        Ingredient ingredient0 = new Ingredient(IngredientType.SAUCE, "Ketchup", 2.0f);
        Ingredient ingredient1 = new Ingredient(IngredientType.FILLING, "Cheese", 1.0f);
        burger.addIngredient(ingredient0);
        burger.addIngredient(ingredient1);
        burger.setBuns(bun);
        burger.getReceipt();








    }
}