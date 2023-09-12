import praktikum.Bun;
import praktikum.Burger;
import praktikum.Database;
import praktikum.Ingredient;

import java.util.List;

public class TestUtils {
    private static Database database = new Database();
    public static Burger createBurger(){//создали бургер с начинкой
        List<Bun> availableBuns = database.availableBuns();
        List<Ingredient> availableIngredients = database.availableIngredients();

        Burger burger = new Burger();
        burger.setBuns(availableBuns.get(0));
        burger.addIngredient(availableIngredients.get(0));
        burger.addIngredient(availableIngredients.get(3));
        return burger;
    }

    public static Burger createPlainBurger(int bun,int filling,int sauce){//создали бургер без начинки
        List<Bun> availableBuns = database.availableBuns();
        List<Ingredient> availableIngredients = database.availableIngredients();

        Burger burger = new Burger();
        burger.setBuns(availableBuns.get(bun));
        burger.addIngredient(availableIngredients.get(filling));
        burger.addIngredient(availableIngredients.get(sauce));
        return burger;
    }
}
