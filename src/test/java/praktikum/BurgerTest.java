package praktikum;

import java.util.List;

public class BurgerTest {

    // Инициализируем базу данных
    Database database = new Database();

    // Создадим новый бургер
    Burger burger = new Burger();

    // Считаем список доступных булок из базы данных
    List<Bun> buns = database.availableBuns();

    // Считаем список доступных ингредиентов из базы данных
    List<Ingredient> ingredients = database.availableIngredients();

    //burger.setBuns(buns.get(0));



}
