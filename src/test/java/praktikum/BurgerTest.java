package praktikum;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;



public class BurgerTest {
    private Database db;

    @Before
    public void init() {
        db = new Database();
    }

    //Проверяем метод добавления булочки в бургер
    @Test
    public void setBuns() {
        Burger burger = new Burger();
        for (Bun bun : db.availableBuns()) {
            burger.setBuns(bun);
            Assert.assertEquals(burger.bun, bun);
        }
    }

    //Проверяем метод добавления ингредиентов в бургер
    @Test
    public void addIngredient() {
        Burger burger = new Burger();
        for (Ingredient ingredient : db.availableIngredients()) {
            burger.addIngredient(ingredient);
            Assert.assertTrue(burger.ingredients.contains(ingredient));
        }
    }


}