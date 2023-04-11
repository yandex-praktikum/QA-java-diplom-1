package praktikum;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.Mock;
import java.util.ArrayList;
import java.util.List;


@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient;
    @Mock
    Burger burger;


    @Test
    public void setBunsReturnBuns() {
        Bun bun = new Bun("test", 344);
        burger.setBuns(bun);
        Mockito.verify(burger).setBuns(bun);
    }
    @Test
    public void addIngredientReturnIngredientOfBurger(){
        Ingredient ingredient=new Ingredient(IngredientType.SAUCE, "test", 333);
        burger.addIngredient(ingredient);
        Mockito.verify(burger).addIngredient(ingredient);
    }
    @Test
    public void removeIngredientReturnIndexOfIngredient() {
        burger.removeIngredient(2);
        Mockito.verify(burger).removeIngredient(2);

    }
    @Test
    public void moveIngredientReturnIndexOfIngredient() {
        burger.moveIngredient(2, 1);
        Mockito.verify(burger).moveIngredient(2, 1);

    }

    @Test
    public void getPriceReturnCorrectPriceForBurger() {
        Burger burger = new Burger(bun, new ArrayList<>());
        Mockito.when(bun.getPrice()).thenReturn(200F);
        Mockito.when(ingredient.getPrice()).thenReturn(300F);
        burger.addIngredient(ingredient);
        Assert.assertEquals(700, burger.getPrice(), 0);

    }

    @Test
    public void getReceiptReturnReceiptAndPriceOfBurger() {
        Burger burger=new Burger();
        Bun bun= new Bun("test", 2);
        burger.setBuns(bun);
        burger.addIngredient(new Ingredient(IngredientType.SAUCE, "test2", 100));
        List<Ingredient> ingredients = new ArrayList<>();
        StringBuilder receipt = new StringBuilder(String.format("(==== %s ====)%n", bun.getName()));

        for (Ingredient ingredient: ingredients) {
            receipt.append(String.format("= %s %s =%n", ingredient.getType().toString().toLowerCase(),
                    ingredient.getName()));
        }

        receipt.append(String.format("(==== %s ====)%n", bun.getName()));
        receipt.append(String.format("%nPrice: %f%n", burger.getPrice()));

        System.out.println(burger.getReceipt());

        Assert.assertEquals("(==== test ====)\n" +
                "= sauce test2 =\n" +
                "(==== test ====)\n" +
                "\n" +
                "Price: 104,000000\n", burger.getReceipt());


    }

}
