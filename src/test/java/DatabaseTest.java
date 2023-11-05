import org.junit.Test;
import static org.junit.Assert.assertEquals;

import org.mockito.Mock;
import praktikum.Bun;
import praktikum.Database;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.List;
import java.util.ArrayList;

public class DatabaseTest {
    @Mock
    Database database = new Database();

    // @Test
    //public void testAvailableBuns() {
    // Bun bun = new Bun("", .0f);
    //  List<Bun> buns = new ArrayList<>();
    // buns.add(new Bun("black bun", 100.0f));
    //  buns.add(new Bun("white bun", 200.0f));
    // buns.add(new Bun("red bun", 300.0f));
    // List<Bun> availableBuns = database.availableBuns();
    // assertEquals(buns, availableBuns);
    // }
    //  @Test
    //  public void testAvailableIngredients() {
    //    // Создаем объект класса, содержащий метод availableIngredients()

    // Создаем список ингредиентов
    //  List<Ingredient> ingredients = new ArrayList<>();
    //  ingredients.add(new Ingredient(IngredientType.FILLING, "efjgk", 100.0f));
    // ingredients.add(new Ingredient(IngredientType.FILLING, "dcsd", 100.0f));
    // ingredients.add(new Ingredient(IngredientType.FILLING, "vdsvsd", 100.0f));

    // Устанавливаем этот список ингредиентов в объекте myClass
    // database.setIngredients(ingredients);

    // Вызываем метод availableIngredients() и сохраняем результат
//       List<Ingredient> availableIngredients = database.availableIngredients();

    // Проверяем, что результат равен ожидаемому списку ингредиентов
    //     assertEquals(ingredients, availableIngredients);
    // }

}
