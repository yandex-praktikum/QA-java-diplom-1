import java.util.List;
import praktikum.Database;
import praktikum.Burger;
import praktikum.Bun;
import praktikum.Ingredient;

import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

public class Praktikum {

    public static void main(String[] args) {
        // Инициализируем базу данных
        Database database = new Database();

        // Создадим новый бургер
        Burger burger = new Burger();

        // Считаем список доступных булок из базы данных
        List<Bun> buns = database.availableBuns();

        // Считаем список доступных ингредиентов из базы данных
        List<Ingredient> ingredients = database.availableIngredients();

        // Соберём бургер
        burger.setBuns(buns.get(0));

        burger.addIngredient(ingredients.get(1));
        burger.addIngredient(ingredients.get(4));
        burger.addIngredient(ingredients.get(3));
        burger.addIngredient(ingredients.get(5));

        // Переместим слой с ингредиентом
        burger.moveIngredient(2, 1);

        // Удалим ингредиент
        burger.removeIngredient(3);

        // Распечатаем рецепт бургера
      //  System.out.println(burger.getReceipt());

        Burger burgerT = new Burger();
        Bun bunT = new Bun("TestBun", 50);
        Ingredient ingredient1 = new Ingredient(SAUCE, "TestSauce", 10);
        Ingredient ingredient2 = new Ingredient(FILLING, "TestFilling", 20);
        burgerT.setBuns(bunT);
        burgerT.addIngredient(ingredient1);
        burgerT.addIngredient(ingredient2);
        System.out.println(burgerT.getReceipt());
    }

}