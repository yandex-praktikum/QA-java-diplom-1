package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
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
    static
    Bun bun;
    @Mock
    static
    Ingredient ingredient;
    @Mock
    Ingredient secondIngredient;

    @Test
    public void setBuns() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        Mockito.when(bun.getName()).thenReturn("black bun");
        Assert.assertEquals("black bun", burger.bun.getName());
        Mockito.when(bun.getPrice()).thenReturn(Float.valueOf(100)); // создай стаб
        Assert.assertEquals(100.0, (burger.bun.getPrice()), 0);// вызвали метод объекта с аргументом
    }

    @Test
    public void addIngredient() {
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        Mockito.when(ingredient.getName()).thenReturn("hot sauce");
        Mockito.when(ingredient.getPrice()).thenReturn(100F);
        Mockito.when(ingredient.getType()).thenReturn(SAUCE);
        Assert.assertEquals("hot sauce", burger.ingredients.get(0).getName());
        Assert.assertEquals(SAUCE, burger.ingredients.get(0).getType());
        Assert.assertEquals(100, burger.ingredients.get(0).getPrice(), 0);
    }

    @Test
    public void removeIngredient() {
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        burger.ingredients.isEmpty();
    }

    @Test
    public void moveIngredient() {
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        burger.addIngredient(secondIngredient);
        Mockito.when(secondIngredient.getName()).thenReturn("hot sauce");
        Mockito.when(secondIngredient.getPrice()).thenReturn(100F);
        Mockito.when(secondIngredient.getType()).thenReturn(SAUCE);
        burger.moveIngredient(0, 1);
        Assert.assertEquals(secondIngredient.getName(), burger.ingredients.get(0).getName());
        Assert.assertEquals(secondIngredient.getType(), burger.ingredients.get(0).getType());
        Assert.assertEquals(secondIngredient.getPrice(), burger.ingredients.get(0).getPrice(), 0);
    }

    @Test
    public void getReceipt() {
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        burger.addIngredient(secondIngredient);
        burger.setBuns(bun);
        Mockito.when(ingredient.getName()).thenReturn("cutlet");
        Mockito.when(ingredient.getPrice()).thenReturn(100F);
        Mockito.when(ingredient.getType()).thenReturn(FILLING);
        Mockito.when(secondIngredient.getName()).thenReturn("hot sauce");
        Mockito.when(secondIngredient.getPrice()).thenReturn(100F);
        Mockito.when(secondIngredient.getType()).thenReturn(SAUCE);
        Mockito.when(bun.getName()).thenReturn("white bun");
        Mockito.when(bun.getPrice()).thenReturn(Float.valueOf(200));
        String expectedReceipt = String.format("(==== white bun ====)%n" + "= filling cutlet =%n" + "= sauce hot sauce =%n" + "(==== white bun ====)%n" + "%nPrice: 600,000000%n");
        String actualReceipt =  burger.getReceipt();
        assertEquals(expectedReceipt, actualReceipt);
    }

    private float priceBun;
    private float priceIngredient;
    private float expectedPrice;

    public BurgerTest(float priceBun, float priceIngredient, float expectedPrice) {
        this.priceBun = priceBun;
        this.priceIngredient = priceIngredient;
        this.expectedPrice = expectedPrice; // создали конструктор тестового класса
    }

    @Parameterized.Parameters(name = "Тестовые данные: {0} {1}")// добавили аннотацию
    public static Object[][] getSumData() {
        return new Object[][] {
                {100, 200, 400},
                {200, 200, 600},
        };
    }

    @Test
    public void getPrice() {
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        burger.setBuns(bun);
        Mockito.when(ingredient.getPrice()).thenReturn(priceIngredient);
        Mockito.when(bun.getPrice()).thenReturn(priceBun);
        float actualPrice = burger.getPrice();
        Assert.assertEquals(expectedPrice, actualPrice, 0);
    }
}