import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    private Bun bun;

    @Mock
    private Ingredient ingredient;

    private Burger burger;

    private final String nameSauce = "Сырный";
    private final String nameFilling = "Лук";
    private final String nameBun = "Толстяк";
    private final float priceBun = 0.021f;
    private final float priceFilling = 3.1f;
    private final float priceSauce = 2.4f;

    @Before
    public void setUp() {
        burger = new Burger();
        burger.setBuns(bun);
    }

    @Test
    public void addIngredientTest() {
        int expectedResult = 1;
        burger.addIngredient(ingredient);
        Assert.assertEquals(expectedResult, burger.ingredients.size());
    }

    @Test
    public void removeIngredientTest() {
        int expectedResult = 4;
        int i = 0;
        while (i < 5) {
            burger.addIngredient(ingredient);
            i++;
        }
        burger.removeIngredient(1);
        Assert.assertEquals(expectedResult, burger.ingredients.size());
    }

    @Test
    public void moveIngredientTest() {
        for (int i = 0; i < 2; i++) {
            if (burger.ingredients.size() % 2 == 0) {
                Mockito.when(ingredient.getType()).thenReturn(IngredientType.FILLING);
                Mockito.when(ingredient.getName()).thenReturn(nameFilling);
                Mockito.when(ingredient.getPrice()).thenReturn(priceFilling);
            } else {
                Mockito.when(ingredient.getType()).thenReturn(IngredientType.SAUCE);
                Mockito.when(ingredient.getName()).thenReturn(nameSauce);
                Mockito.when(ingredient.getPrice()).thenReturn(priceSauce);
            }
            burger.addIngredient(ingredient);
        }
        burger.moveIngredient(1, 0);

        Assert.assertEquals(nameSauce, burger.ingredients.get(0).getName());
    }

    @Test
    public void getPriceTest() {
        Mockito.when(bun.getPrice()).thenReturn(priceBun);
        Mockito.when(ingredient.getPrice()).thenReturn(priceFilling);

        burger.addIngredient(ingredient);

        Assert.assertEquals((priceBun * 2) + priceFilling, burger.getPrice(), 0);
    }

    @Test
    public void getReceiptTest() {
        Mockito.when(bun.getName()).thenReturn(nameBun);
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredient.getName()).thenReturn(nameSauce);
        Mockito.when(bun.getPrice()).thenReturn(priceBun);
        Mockito.when(ingredient.getPrice()).thenReturn(priceSauce);

        burger.addIngredient(ingredient);

        String expectedResult = String.format(
                "(==== %s ====)%n= %s %s =%n(==== %s ====)%n%nPrice: %f%n",
                nameBun, IngredientType.SAUCE.toString().toLowerCase(),
                nameSauce, nameBun, ((priceBun * 2) + priceSauce));

        Assert.assertEquals("Неверный чек", expectedResult, burger.getReceipt());
    }
}
