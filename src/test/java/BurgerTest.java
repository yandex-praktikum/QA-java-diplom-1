import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    private Bun bun;

    @Mock
    private Ingredient ingredient;

    @Test
    public void burgerAddIngredient() {
        Burger burger = Mockito.spy(new Burger());
        burger.addIngredient(ingredient);
        Mockito.verify(burger).addIngredient(ingredient);

        assertEquals(1, burger.ingredients.size());
    }

    @Test
    public void burgerRemoveIngredient() {
        Burger burger = Mockito.spy(new Burger());
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        Mockito.verify(burger).removeIngredient(0);

        assertEquals(0, burger.ingredients.size());
    }

    @Test
    public void burgerMoveIngredient() {
        Burger burger = Mockito.spy(new Burger());
        burger.addIngredient(new Ingredient(IngredientType.SAUCE, "chili sauce", 300));
        burger.addIngredient(new Ingredient(IngredientType.FILLING, "dinosaur", 200));
        burger.moveIngredient(0, 1);

        Mockito.verify(burger).moveIngredient(0, 1);
        assertEquals("Type is incorrect", "dinosaur", burger.ingredients.get(0).name);
        assertEquals("Type is incorrect","chili sauce", burger.ingredients.get(1).name);
    }

    @Test
    public void burgerGetPrice() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        Mockito.when(burger.getPrice()).thenReturn(100f);

        assertEquals("Price is incorrect", 100f, burger.getPrice(), Float.NaN);
    }

    @Test
    public void burgerGetReceipt() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        Mockito.when(bun.getName()).thenReturn("red bun");
        Mockito.when(bun.getPrice()).thenReturn(300f);
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredient.getName()).thenReturn("chili sauce");
        Mockito.when(ingredient.getPrice()).thenReturn(300f);
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ingredient.getName()).thenReturn("dinosaur");
        Mockito.when(ingredient.getPrice()).thenReturn(200f);

        StringBuilder receipt = new StringBuilder(String.format("(==== %s ====)%n", bun.getName()));

        for (Ingredient ingredient : burger.ingredients) {
            receipt.append(String.format("= %s %s =%n", ingredient.getType().toString().toLowerCase(),
                    ingredient.getName()));
        }

        receipt.append(String.format("(==== %s ====)%n", bun.getName()));
        receipt.append(String.format("%nPrice: %f%n", burger.getPrice()));

        assertEquals(receipt.toString(), burger.getReceipt());
    }
}
