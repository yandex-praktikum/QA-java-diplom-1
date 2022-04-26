import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.*;


@RunWith(MockitoJUnitRunner.class)
class BurgerTest {

    Burger burger = new Burger();

    @Mock
    Ingredient ingredient;

    @Mock
    Bun bun;

    @Test
    public void addIngredientTest() {
        burger.addIngredient(ingredient);
        Assertions.assertEquals(1, burger.ingredients.size(), "Ингридиент не был добавлен");
    }

    @Test
    void removeIngredientTest() {
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        Assertions.assertEquals(0, burger.ingredients.size(),"Ингридиент не был удален");
    }

    @Test
    void moveIngredientTest() {
        burger.addIngredient(new Ingredient(IngredientType.SAUCE, "Соус Spicy-X", 90));
        burger.addIngredient(new Ingredient(IngredientType.FILLING, "Говяжий метеорит", 3000));
        burger.moveIngredient(0, 1);
        Assertions.assertEquals("Говяжий метеорит", burger.ingredients.get(0).name,"Ингридиенты не поменяли свои индексы");
    }

    @Test
    public void getPriceTest(){
        Database database = new Database();
        burger.setBuns(database.availableBuns().get(0));
        float bunPrice = database.availableBuns().get(0).price;
        burger.addIngredient(database.availableIngredients().get(0));
        float ingredientPrice = database.availableIngredients().get(0).price;
        float correctPrice = (bunPrice*2) + ingredientPrice;
        Assertions.assertEquals(correctPrice, burger.getPrice(),0.000001, "Цена не считается");
    }

    @Test
    public void receiptHasBunNameTest(){
        Database database = new Database();
        burger.setBuns(database.availableBuns().get(0));
        String bunName = database.availableBuns().get(0).name;
        Assertions.assertTrue(burger.getReceipt().contains(bunName), "Нет булочки в чеке");
    }
    @Test
    public void receiptHasBunPriceTest(){
        Database database = new Database();
        burger.setBuns(database.availableBuns().get(0));
        int burgerPrice = (int)burger.getPrice();
        Assertions.assertTrue(burger.getReceipt().contains(Integer.toString(burgerPrice)), "нет названия в чеке");
    }

    @Test
    public void receiptHasIngredientTypeTest(){
        Database database = new Database();
        burger.setBuns(bun);
        burger.addIngredient(database.availableIngredients().get(0));
        String ingredientType = database.availableIngredients().get(0).type.toString();
        Assertions.assertTrue(burger.getReceipt().contains(ingredientType.toLowerCase()),"нет начинки в чеке");
    }
}