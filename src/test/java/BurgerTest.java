import org.junit.Assert;
import org.junit.Test;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BurgerTest {

    @Test
    public void addIngredient() {
        Burger burger=new Burger();
        Ingredient ingredient=mock(Ingredient.class);
        burger.addIngredient(ingredient);
        when(ingredient.getName()).thenReturn("Ингридиент!");
        when(ingredient.getPrice()).thenReturn(10.0f);
        when(ingredient.getType()).thenReturn(IngredientType.SAUCE);
        Assert.assertEquals(burger.ingredients.size(),1);

    }

    @Test
    public void removeIngredient() {
        Burger burger=new Burger();
        Ingredient ingredient=mock(Ingredient.class);
        burger.addIngredient(ingredient);
        when(ingredient.getName()).thenReturn("Ингридиент0");
        when(ingredient.getPrice()).thenReturn(10.0f);
        when(ingredient.getType()).thenReturn(IngredientType.SAUCE);
        Ingredient ingredient1=mock(Ingredient.class);
        burger.addIngredient(ingredient);
        when(ingredient1.getName()).thenReturn("Ингридиент!");
        when(ingredient1.getPrice()).thenReturn(10.0f);
        when(ingredient1.getType()).thenReturn(IngredientType.FILLING);
        Assert.assertEquals(burger.ingredients.size(),2);
        burger.removeIngredient(1);
        Assert.assertEquals(burger.ingredients.size(),1);
    }

    @Test
    public void moveIngredient() {
        Burger burger=new Burger();
        Ingredient ingredient=new Ingredient(IngredientType.SAUCE,"sadd",10.0f);
        Ingredient ingredient1=new Ingredient(IngredientType.FILLING,"111",11.0f);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient1);
        Assert.assertEquals(burger.ingredients.get(0).getType(),IngredientType.SAUCE);
        burger.moveIngredient(0,1);
        Assert.assertEquals(burger.ingredients.get(0).getType(),IngredientType.FILLING);
        Assert.assertEquals(burger.ingredients.get(1).getType(),IngredientType.SAUCE);
    }

    @Test
    public void getPrice() {
        Burger burger=new Burger();
        Bun bun = mock(Bun.class);
        burger.setBuns(bun);
        when(bun.getPrice()).thenReturn(2.0f);
        Assert.assertEquals(burger.getPrice(), 4.0f,0);
    }

    @Test
    public void getReceipt() {
        Burger burger=new Burger();
        Bun bun = mock(Bun.class);
        burger.setBuns(bun);
        Ingredient ingredient=mock(Ingredient.class);
        burger.addIngredient(ingredient);
        when(ingredient.getName()).thenReturn("Ингридиент!");
        when(ingredient.getPrice()).thenReturn(10.0f);
        when(ingredient.getType()).thenReturn(IngredientType.FILLING);
        when(bun.getPrice()).thenReturn(2.0f);
        when(bun.getName()).thenReturn("Булочка");
        Assert.assertTrue(burger.getReceipt().contains("(==== Булочка ====)"));
        Assert.assertTrue(burger.getReceipt().contains("= filling Ингридиент! ="));
        Assert.assertTrue(burger.getReceipt().contains("Price: 14,000000"));


    }
}