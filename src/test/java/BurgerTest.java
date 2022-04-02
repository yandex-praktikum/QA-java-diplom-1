import com.github.javafaker.Faker;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    Burger burger;
    Faker faker = new Faker();
    IngredientType ingredientType;

    @Mock
    Bun bun;

    @Mock
    Ingredient ingredient;

    @Before
    public void setup() {
        int ingredientTypeEnum = new Random().nextInt(IngredientType.values().length);
        ingredientType = IngredientType.values()[ingredientTypeEnum];
        Mockito.when(bun.getName()).thenReturn(faker.food().ingredient());
        Mockito.when(bun.getPrice()).thenReturn((float) faker.number().randomDouble(2, 1, 1000));
        bun = new Bun(bun.getName(), bun.getPrice());
        Mockito.when(ingredient.getName()).thenReturn(faker.food().ingredient());
        Mockito.when(ingredient.getPrice()).thenReturn((float) faker.number().randomDouble(2, 1, 1000));
        Mockito.when(ingredient.getType()).thenReturn(ingredientType);
        ingredient = new Ingredient(ingredient.getType(), ingredient.getName(), ingredient.getPrice());
        burger = new Burger();

    }

    @Test
    public void addIngredient() {
        burger.addIngredient(ingredient);
        assertEquals("Ingredient not found", ingredient, burger.ingredients.get(0));

    }

    @Test
    public void removeIngredient() {
        int lengthBurgerWithoutIngredient = 0;
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        assertEquals("Ingredient found", lengthBurgerWithoutIngredient, burger.ingredients.size());

    }

    @Test
    public void moveIngredient() {
        int index = 0;
        int newIndex = 1;
        burger.addIngredient(ingredient);
        Ingredient newIngredient = new Ingredient(ingredient.getType(), ingredient.getName(), ingredient.getPrice());
        burger.addIngredient(newIngredient);
        burger.moveIngredient(index, newIndex);
        assertEquals("Ingredient is in incorrect place", ingredient, burger.ingredients.get(newIndex));
        assertEquals("Ingredient is in incorrect place", newIngredient, burger.ingredients.get(index));

    }

    @Test
    public void setBun() {
        burger.setBuns(bun);
        assertEquals("Name bun is incorrect", bun.getName(), burger.bun.getName());
        assertEquals(bun.getPrice(), burger.bun.getPrice(), 1);

    }

    @Test
    public void getReceipt() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        burger.addIngredient(new Ingredient(ingredient.getType(), ingredient.getName(), ingredient.getPrice()));
        burger.addIngredient(new Ingredient(ingredient.getType(), ingredient.getName(), ingredient.getPrice()));
        burger.addIngredient(new Ingredient(ingredient.getType(), ingredient.getName(), ingredient.getPrice()));
        StringBuilder burgerPrice = new StringBuilder(String.format("%f%n", burger.getPrice()));
        assertTrue("Ingredient or price not fount in receipt", findStringInReceipt(burger.getReceipt(), burger.ingredients.get(0).getName()));
        assertTrue("Ingredient or price not fount in receipt", findStringInReceipt(burger.getReceipt(), burger.ingredients.get(1).getName()));
        assertTrue("Ingredient or price not fount in receipt", findStringInReceipt(burger.getReceipt(), burger.ingredients.get(2).getName()));
        assertTrue("Ingredient or price not fount in receipt", findStringInReceipt(burger.getReceipt(), burger.ingredients.get(3).getName()));
        assertTrue("Ingredient or price not fount in receipt", findStringInReceipt(burger.getReceipt(), burgerPrice.toString()));

    }

    public boolean findStringInReceipt(String receipt, String receiptSubString) {
        return receipt.contains(receiptSubString);

    }

}