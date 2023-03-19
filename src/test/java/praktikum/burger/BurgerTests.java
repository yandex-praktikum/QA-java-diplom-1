package praktikum.burger;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTests {
    @Mock
    private Bun bun;
    @Mock
    private Ingredient ingredient1;
    @Mock
    private Ingredient ingredient2;


    @Test
    public void checkGetPrice() {
        float ingredientPrice1 = 3.0F;
        float ingredientPrice2 = 6.0F;
        float bunPrice = 2.0F;
        Burger burger = new Burger();

        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        float expectedBurgerPrice = bunPrice * 2 + ingredientPrice1 + ingredientPrice2;

        Mockito.when(bun.getPrice()).thenReturn(bunPrice);
        Mockito.when(ingredient1.getPrice()).thenReturn(ingredientPrice1);
        Mockito.when(ingredient2.getPrice()).thenReturn(ingredientPrice2);
        float actualBurgerPrice = burger.getPrice();

        assertEquals("Invalid price", expectedBurgerPrice, actualBurgerPrice, 0.0F);
    }

    @Test
    public void checkGetReceipt() {
        float ingredientPrice1 = 3.0F;
        float ingredientPrice2 = 6.0F;
        float bunPrice = 2.0F;
        float burgerPrice = bunPrice * 2 + ingredientPrice1 + ingredientPrice2;
        Burger burger = new Burger();

        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);

        Mockito.when(bun.getPrice()).thenReturn(bunPrice);
        Mockito.when(bun.getName()).thenReturn("Пита");

        Mockito.when(ingredient1.getPrice()).thenReturn(ingredientPrice1);
        Mockito.when(ingredient1.getName()).thenReturn("Салат");
        Mockito.when(ingredient1.getType()).thenReturn(IngredientType.FILLING);

        Mockito.when(ingredient2.getPrice()).thenReturn(ingredientPrice2);
        Mockito.when(ingredient2.getName()).thenReturn("Котлета");
        Mockito.when(ingredient2.getType()).thenReturn(IngredientType.FILLING);
        System.out.println(burger.getReceipt());
        assertEquals("Invalid receipt",
                formatReceipt(bun,List.of(ingredient1,ingredient2),burgerPrice),
                burger.getReceipt());
    }

    private String formatReceipt(Bun bun, List<Ingredient> ingredients, float burgerPrice) {
        StringBuilder receipt = new StringBuilder(String.format("(==== %s ====)%n", bun.getName()));

        for (Ingredient ingredient : ingredients) {
            receipt.append(String.format("= %s %s =%n", ingredient.getType().toString().toLowerCase(),
                    ingredient.getName()));
        }

        receipt.append(String.format("(==== %s ====)%n", bun.getName()));
        receipt.append(String.format("%nPrice: %f%n", burgerPrice));

        return receipt.toString();
    }
}
