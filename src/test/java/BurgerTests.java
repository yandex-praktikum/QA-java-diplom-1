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
public class BurgerTests {

    public Burger burger;
    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient;
    @Mock
    Ingredient ingredient2;


    @Before
    public void setUp() {
        burger = new Burger();
    }

    @Test
    public void setBunTest() {
        burger.setBuns(bun);
        Assert.assertEquals(burger.bun, bun);

    }

    @Test
    public void addIngredientTest() {
        burger.addIngredient(ingredient);
        Assert.assertNotEquals(0, burger.ingredients.size());

    }

    @Test
    public void removeIngredientTest() {
        burger.addIngredient(ingredient);
        Assert.assertNotEquals(0, burger.ingredients.size());
        burger.removeIngredient(0);
        Assert.assertEquals(0, burger.ingredients.size());

    }

    @Test
    public void moveIngredientTest() {
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient2);
        Assert.assertNotEquals(0, burger.ingredients.size());
        burger.moveIngredient(0, 1);
        Assert.assertEquals(ingredient2, burger.ingredients.get(0));

    }

    @Test
    public void getPriceTest() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        Mockito.when(bun.getPrice()).thenReturn(20.5f);
        Mockito.when(ingredient.getPrice()).thenReturn(50.3f);
        float expectedPrice = 91.3f;
        Assert.assertEquals(expectedPrice, burger.getPrice(), 0);

    }

    @Test
    public void getReceiptTest() {
        StringBuilder expectedReceipt = new StringBuilder(String.format("(==== %s ====)%n", "Bun"));
        expectedReceipt.append(String.format("= %s %s =%n", "filling", "CosmoMeat"));
        expectedReceipt.append(String.format("(==== %s ====)%n", "Bun"));
        expectedReceipt.append(String.format("%nPrice: %f%n", 91.3f));
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        Mockito.when(bun.getName()).thenReturn("Bun");
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ingredient.getName()).thenReturn("CosmoMeat");
        Mockito.when(bun.getPrice()).thenReturn(20.5f);
        Mockito.when(ingredient.getPrice()).thenReturn(50.3f);
        Assert.assertEquals(expectedReceipt.toString(), burger.getReceipt());

    }


}
