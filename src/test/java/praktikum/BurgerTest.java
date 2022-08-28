package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;
import static praktikum.IngredientType.*;


@RunWith(Parameterized.class)
public class BurgerTest {

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }
    @Mock
    Bun bun;

    @org.junit.Test
    public void setBuns() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        Mockito.when(bun.getName()).thenReturn("black bun");
        Assert.assertEquals("black bun", burger.bun.getName());
        Mockito.when(bun.getPrice()).thenReturn(Float.valueOf(100)); // создай стаб
        Assert.assertEquals(100.0, (burger.bun.getPrice()), 0);// вызвали метод объекта с аргументом
    }

    @org.junit.Test
    public void addIngredient() {
        Burger burger = new Burger();
        Ingredient ingredient = new Ingredient(SAUCE, "hot sauce", 100);
        burger.addIngredient(ingredient);
        Assert.assertEquals("hot sauce", burger.ingredients.get(0).getName());
        Assert.assertEquals(SAUCE, burger.ingredients.get(0).getType());
        Assert.assertEquals(100, burger.ingredients.get(0).getPrice(), 0);
        burger.removeIngredient(0);
    }

    @org.junit.Test
    public void removeIngredient() {
        Burger burger = new Burger();
        Ingredient ingredient = new Ingredient(FILLING, "cutlet", 1000);
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        burger.ingredients.isEmpty();
    }

    @org.junit.Test
    public void moveIngredient() {
        Burger burger = new Burger();
        Ingredient ingredient = new Ingredient(FILLING, "cutlet", 1000);
        burger.addIngredient(ingredient);
        Ingredient ingredient2 = new Ingredient(SAUCE, "hot sauce", 100);
        burger.addIngredient(ingredient2);
        burger.moveIngredient(0, 1);
        Assert.assertEquals(ingredient2.name, burger.ingredients.get(0).getName());
        Assert.assertEquals(ingredient2.type, burger.ingredients.get(0).getType());
        Assert.assertEquals(ingredient2.price, burger.ingredients.get(0).getPrice(), 0);
    }


    @org.junit.Test
    public void getReceipt() {
        Burger burger = new Burger();
        Ingredient ingredient = new Ingredient(FILLING, "cutlet", 1000);
        burger.addIngredient(ingredient);
        Ingredient ingredient2 = new Ingredient(SAUCE, "hot sauce", 100);
        burger.addIngredient(ingredient2);
        Bun bun = new Bun("white bun", 200);
        burger.setBuns(bun);
        String expectedReceipt = String.format("(==== white bun ====)%n" + "= filling cutlet =%n" + "= sauce hot sauce =%n" + "(==== white bun ====)%n" + "%nPrice: 1500,000000%n");
        String actualReceipt =  burger.getReceipt();
        assertEquals(expectedReceipt, actualReceipt);
    }


    private Ingredient ingredient;
    private final float expectedPrice;
    private Bun newBun;

    public BurgerTest(Bun newBun, Ingredient ingredient, float expectedPrice) {
        this.newBun = newBun;
        this.ingredient = ingredient;
        this.expectedPrice = expectedPrice; // создали конструктор тестового класса
    }
    static Bun whiteBun = new Bun("white bun", 200);
    static Bun blackBun = new Bun("black bun", 100);
    static Bun redBun = new Bun("red bun", 300);

    static Ingredient oneIngredient = new Ingredient(FILLING, "cutlet", 1000);
    @Parameterized.Parameters // добавили аннотацию
    public static Object[][] getSumData() {
        return new Object[][] {
                { whiteBun, oneIngredient, 1400},
                { blackBun, oneIngredient, 1200},
                { redBun, oneIngredient, 1600},
        };
    }
    @org.junit.Test
    public void getPrice() {
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        burger.setBuns(newBun);
        float actualPrice = burger.getPrice();
        Assert.assertEquals(expectedPrice, actualPrice, 0);
    }
}