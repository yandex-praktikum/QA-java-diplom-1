import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Database;
import praktikum.Ingredient;
import static praktikum.IngredientType.SAUCE;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    private Bun bunMock;
    @Mock
    private Ingredient ingredientMock;

    Bun bun = new Bun("black bun", 100);
    Burger burger = new Burger();
    Database database = new Database();

    @Test
    public void setBunTest() {
        //установить булочку для бургера
        burger.setBuns(bun);
        //убедиться, что в бургере нужная булочка
        Assert.assertEquals("black bun", database.availableBuns().get(0).name);
        Assert.assertEquals(100, database.availableBuns().get(0).price,0);
    }

    @Test
    public void addIngredientTest(){
        //взять ингредиент из базы данных и добавить его в бургер
        burger.addIngredient(database.availableIngredients().get(0));
        //убедиться, в бургер добавлен нужный ингредиент
        Assert.assertEquals("hot sauce", burger.ingredients.get(0).name);
    }

    @Test
    public void removeIngredientTest(){
        //взять ингредиент из базы данных и добавить его в бургер
        burger.addIngredient(database.availableIngredients().get(0));
        //посчитать количество ингредиентов в бургере
        int quantityBeforeDeleting = burger.ingredients.size();
        //удалить ингредиент
        burger.removeIngredient(0);
        //посчитать количество ингредиентов в бургере
        int quantityAfterDeleting = burger.ingredients.size();
        //убедиться, что количество элементов не совпадает
        Assert.assertNotEquals(quantityBeforeDeleting, quantityAfterDeleting);
    }

    @Test
    public void moveIngredient(){
        //добавить ингредиенты
        burger.addIngredient(database.availableIngredients().get(0));
        burger.addIngredient(database.availableIngredients().get(1));
        //поменяем местами два ингредиента
        burger.moveIngredient(0, 1);
        //проверка, что элементы поменялись местами'
        Assert.assertEquals(database.availableIngredients().get(1).name, burger.ingredients.get(0).name);
        Assert.assertEquals(database.availableIngredients().get(0).name, burger.ingredients.get(1).name);
    }

    @Test
    public void getPriceOfBunAndIngredient(){
        //установить булочку-мок для бургера чз конструктор
        burger.setBuns(bunMock);
        //добавить ингредиент-мок
        burger.addIngredient(ingredientMock);
        //замокировать методы получения стоимости булочки и ингредиента
        Mockito.when(bunMock.getPrice()).thenReturn(300.0f);
        Mockito.when(ingredientMock.getPrice()).thenReturn(400.0f);
        //проверить работу метода получения стоимости бургера
        Assert.assertEquals(1000.0f, burger.getPrice(), 0);
    }

    @Test
    public void getReceipt(){
        //установить булочку-мок для бургера чз конструктор
        burger.setBuns(bunMock);
        //добавить ингредиент-мок
        burger.addIngredient(ingredientMock);
        //замокировать методы
        Mockito.when(bunMock.getName()).thenReturn("black bun");
        Mockito.when(bunMock.getPrice()).thenReturn(100f);
        Mockito.when(ingredientMock.getType()).thenReturn(SAUCE);
        Mockito.when(ingredientMock.getName()).thenReturn("hot sauce");
        Mockito.when(ingredientMock.getPrice()).thenReturn(100f);
        //проверить метод getReceipt для бургера
        System.out.println(burger.getReceipt());
        Assert.assertEquals("(==== black bun ====)\n" +
                "= sauce hot sauce =\n" +
                "(==== black bun ====)\n" +
                "\n" +
                "Price: 300,000000\n", burger.getReceipt());
    }
}
