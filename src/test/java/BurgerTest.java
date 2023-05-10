import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.*;

import java.util.Objects;

import static constants.BurgerTestConstant.TEST_RESULT_FUNC_GET_RECEIPT_1;
import static praktikum.IngredientType.SAUCE;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    final String name = "Test name";
    final float price = (float) 1.1;

    @Test
    public void TestSetBuns() {
        Burger burger = new Burger();
        Bun bun = new Bun(name, price);
        burger.setBuns(bun);

        assert burger.bun.equals(bun);
    }

    @Mock
    Burger mockBurger; // создали мок

    @Test
    public void TestVerifySetBuns() {
        Bun bun = new Bun(name, price);
        mockBurger.setBuns(bun); // вызвали метод объекта с аргументом
        Mockito.verify(mockBurger).setBuns(bun); // проверили, что метод вызван с этим параметром
    }

    @Test
    public void TestAddIngredient() {
        Burger burger = new Burger();
        IngredientType type = SAUCE;
        Ingredient ingredient = new Ingredient(type, name, price);
        burger.addIngredient(ingredient);

        assert burger.ingredients.contains(ingredient);
    }
    @Test
    public void TestRemoveIngredient() {
        Burger burger = new Burger();
        IngredientType type = SAUCE;
        Ingredient ingredient = new Ingredient(type, name, price);
        burger.addIngredient(ingredient);

        assert burger.ingredients.contains(ingredient);

        burger.removeIngredient(0);

        assert !burger.ingredients.contains(ingredient);
    }

    @Test
    public void TestMoveIngredient() {
        Burger burger = new Burger();
        IngredientType type = SAUCE;
        Ingredient ingredient = new Ingredient(type, name, price);
        burger.addIngredient(ingredient);
        Ingredient newIngredient = new Ingredient(type, name + " 2", price);
        burger.addIngredient(newIngredient);

        assert burger.ingredients.contains(ingredient);
        assert burger.ingredients.contains(newIngredient);

        assert burger.ingredients.get(0).equals(ingredient);
        assert burger.ingredients.get(1).equals(newIngredient);

        burger.moveIngredient(0, 1);

        assert burger.ingredients.contains(ingredient);
        assert burger.ingredients.contains(newIngredient);

        assert burger.ingredients.get(1).equals(ingredient);
        assert burger.ingredients.get(0).equals(newIngredient);
    }
    @Test
    public void TestMoveIngredientWithDB() {
        Burger burger = new Burger();
        // Инициализируем базу данных
        Database database = new Database();

        Bun bun = database.availableBuns().get(0);

        burger.setBuns(bun);
        assert burger.bun.equals(bun);
    }

    @Test
    public void TestGetReceipt() {
        Burger burger = new Burger();
        IngredientType type = SAUCE;
        Ingredient ingredient = new Ingredient(type, name, price);
        burger.addIngredient(ingredient);
        burger.setBuns(new Bun("1", (float) 1.2));
        Ingredient newIngredient = new Ingredient(type, name + " 2", price);
        burger.addIngredient(newIngredient);

        assert burger.getReceipt().equals(TEST_RESULT_FUNC_GET_RECEIPT_1);
    }
}