package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;


@RunWith(Parameterized.class)
public class BurgerPriceTest {
    private final Bun bun;
    private final List<Ingredient> ingredients;
    private final float price;
    private static Database db = new Database();
    private Burger burger;

    @Before
    public void init() {
        burger = new Burger();
        burger.setBuns(bun);
        for (Ingredient ingredient : ingredients) {
            burger.addIngredient(ingredient);
        }
    }

    public BurgerPriceTest(Bun bun, List<Ingredient> ingredients, float price) {
        this.bun = bun;
        this.ingredients = ingredients;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] getBurger() {
        List<Bun> buns = db.availableBuns();
        List<Ingredient> ingr = db.availableIngredients();
        List<Ingredient> emptyList = new ArrayList<>();
        List<Ingredient> oneIngredient = new ArrayList<>();
        oneIngredient.add(ingr.get(0));
        float priceAll = 0.0f;
        for (Ingredient ingredient : ingr) {
            priceAll = priceAll + ingredient.getPrice();
        }
        return new Object[][]{
                {buns.get(0), emptyList, buns.get(0).getPrice() * 2},
                {buns.get(1), oneIngredient, buns.get(1).getPrice() * 2 + oneIngredient.get(0).getPrice()},
                {buns.get(2), ingr, buns.get(2).getPrice() * 2 + priceAll},
        };
    }

    //Проверяем метод подсчета цены бургера
    @Test
    public void getPrice() {
        assertEquals(price, burger.getPrice(), 0.0f);
    }
}