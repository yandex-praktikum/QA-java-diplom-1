package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)

public class BurgerTest {
    @Mock
    Ingredient ingredient;
    @Mock
    Bun bun;

    @Test
    public void addIngredientTest() {
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        Assert.assertEquals("Неверное количество ингридиентов в бургере", 1, burger.ingredients.size());
    }

    @Test
    public void removeIngredientTest() {
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        Assert.assertEquals("Неверное количество ингридиентов в бургере", 0, burger.ingredients.size());
    }

    @Test
    public void moveIngredientTest() {
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        Ingredient secondIngredient = Mockito.mock(Ingredient.class);
        burger.addIngredient(secondIngredient);
        Ingredient firstIngredientInBurger = burger.ingredients.get(0);
        burger.moveIngredient(0, 1);
        Assert.assertEquals("Ингридиенты не изменили свои индексы", firstIngredientInBurger, burger.ingredients.get(1));
    }

    @Test
    public void getPriceTest() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        float bunPrice = 100;
        Mockito.when(bun.getPrice()).thenReturn(bunPrice);
        float ingredientPrice = 100;
        Mockito.when(ingredient.getPrice()).thenReturn(ingredientPrice);
        Assert.assertEquals("Цена бургера не корректная", bunPrice * 2 + ingredientPrice, burger.getPrice(), 0.01f);
    }

    @Test
    public void getReceiptTest() {
        Burger burger = new Burger();

        burger.setBuns(bun);

        Ingredient ingredientSauce = Mockito.mock(Ingredient.class);
        burger.addIngredient(ingredientSauce);

        burger.addIngredient(ingredient);

        Mockito.when(bun.getName()).thenReturn("red bun");
        Mockito.when(bun.getPrice()).thenReturn(300f);

        Mockito.when(ingredientSauce.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredientSauce.getName()).thenReturn("chili sauce");
        Mockito.when(ingredientSauce.getPrice()).thenReturn(300f);

        Mockito.when(ingredient.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ingredient.getName()).thenReturn("dinosaur");
        Mockito.when(ingredient.getPrice()).thenReturn(200f);

        StringBuilder receipt = new StringBuilder(String.format("(==== %s ====)%n", bun.getName()));

        for (var ingredient : burger.ingredients) {
            receipt.append(String.format("= %s %s =%n", ingredient.getType().toString().toLowerCase(),
                    ingredient.getName()));
        }

        receipt.append(String.format("(==== %s ====)%n", bun.getName()));
        receipt.append(String.format("%nPrice: %f%n", burger.getPrice()));

        Assert.assertEquals(receipt.toString(), burger.getReceipt());
    }
}