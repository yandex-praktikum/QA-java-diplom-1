package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;


@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    private Burger burger;
    @Mock
    private Bun bun;
    @Mock
    private Ingredient ingredient;
    @Mock
    private Ingredient sauce;
    @Mock
    private Ingredient filling;

    @Before
    public void createBurger(){
        burger = new Burger();
    }
    @Test
    public void setBuns(){
        burger.setBuns(bun);
        Object actual = burger.bun;
        Assert.assertEquals("", bun, actual);
    }
    @Test
    public void addIngredient(){
        burger.addIngredient(ingredient);
        List<Ingredient> expected = List.of(ingredient);
        List<Ingredient> actual = burger.ingredients;
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void removeIngredients(){
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        List<Ingredient> expected = burger.ingredients;
        Assert.assertEquals(expected, burger.ingredients);
    }
    @Test
    public void moveIngredient(){
        burger.addIngredient(sauce);
        burger.addIngredient(filling);
        burger.moveIngredient(0,1 );
        List<Ingredient> expected = burger.ingredients;
        Assert.assertEquals(expected, burger.ingredients);
    }
    @Test
    public void getPrice() {
        burger.setBuns(bun);
        burger.addIngredient(sauce);
        burger.addIngredient(filling);
        Mockito.when(bun.getPrice()).thenReturn(2.0f);
        Mockito.when(sauce.getPrice()).thenReturn(40.0f);
        Mockito.when(filling.getPrice()).thenReturn(60.0f);
        float expected = bun.getPrice()*2 + sauce.getPrice() + filling.getPrice();
        Assert.assertEquals(expected, burger.getPrice(), 0f);
    }
    @Test
    public void getRecept(){
        Mockito.when(bun.getName()).thenReturn("Самая вкусная булочка");
        Mockito.when(bun.getPrice()).thenReturn(20.0f);
        burger.setBuns(bun);

        Mockito.when(sauce.getName()).thenReturn("Сырный");
        Mockito.when(sauce.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(sauce.getPrice()).thenReturn(50.0f);
        burger.addIngredient(sauce);

        Mockito.when(filling.getName()).thenReturn("Фалафель");
        Mockito.when(filling.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(filling.getPrice()).thenReturn(100.0f);
        burger.addIngredient(filling);

        StringBuilder receipt = new StringBuilder(String.format("(==== %s ====)%n", bun.getName()));
        List<Ingredient> ingredients = burger.ingredients;

        for (Ingredient ingredient : ingredients) {
            receipt.append(String.format("= %s %s =%n", ingredient.getType().toString().toLowerCase(),
                    ingredient.getName()));
        }
        receipt.append(String.format("(==== %s ====)%n", bun.getName()));
        receipt.append(String.format("%nPrice: %f%n", burger.getPrice()));

        String expected = receipt.toString();

        Assert.assertEquals(expected, burger.getReceipt());
    }
}