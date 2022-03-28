package praktikum;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;
import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    Burger burger;
    Faker faker = new Faker();
    Bun bun;
    Ingredient ingredient;
    IngredientType ingredientType;

    @Before
    public void setup(){
        int ingredientTypeEnum = new Random().nextInt(IngredientType.values().length);
        ingredientType = IngredientType.values()[ingredientTypeEnum];
        //Mockito.when(bun.getName()).thenReturn(faker.food().ingredient());
        //Mockito.when(bun.getPrice()).thenReturn((float)faker.number().randomDouble(2,1,1000));
        bun = new Bun(faker.food().ingredient(),(float)faker.number().randomDouble(2,1,1000));
        ingredient = new Ingredient(ingredientType,faker.food().ingredient(),(float)faker.number().randomDouble(2,1,1000));
        burger = new Burger();

    }

    @Test
    public void addIngredient() {
        burger.addIngredient(ingredient);
        assertEquals("Ingredient not found", ingredient, burger.ingredients.get(0));

    }

    @Test
    public void removeIngredient (){
        int lengthBurgerWithoutIngredient = 0;
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        assertEquals("Ingredient found", lengthBurgerWithoutIngredient, burger.ingredients.size());

    }

    @Test
    public void moveIngredient(){
        int index = 0;
        int newIndex = 1;
        burger.addIngredient(ingredient);
        Ingredient newIngredient = new Ingredient(ingredientType,faker.food().ingredient(),(float)faker.number().randomDouble(2,1,1000));
        burger.addIngredient(newIngredient);
        burger.moveIngredient(index,newIndex);
        assertEquals("Ingredient is in incorrect place", ingredient, burger.ingredients.get(newIndex));
        assertEquals("Ingredient is in incorrect place", newIngredient, burger.ingredients.get(index));

    }

    @Test
    public void setBun(){
        String expectedNameBun = faker.food().ingredient();
        double expectedPriceBun = faker.number().randomDouble(1,1,1000);
        burger.setBuns(new Bun(expectedNameBun,(float)expectedPriceBun));
        assertEquals("Name bun is incorrect", expectedNameBun, burger.bun.getName());
        assertEquals( expectedPriceBun, burger.bun.getPrice(),1);

    }

    @Test
    public void getReceipt(){
        float getPriceMock = (float) faker.number().randomDouble(1,1,1000);
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        burger.addIngredient(new Ingredient(ingredientType,faker.food().ingredient(),(float)faker.number().randomDouble(2,1,1000)));
        burger.addIngredient(new Ingredient(ingredientType,faker.food().ingredient(),(float)faker.number().randomDouble(2,1,1000)));
        burger.addIngredient(new Ingredient(ingredientType,faker.food().ingredient(),(float)faker.number().randomDouble(2,1,1000)));
        StringBuilder burgerPrice = new StringBuilder(String.format("%f%n", burger.getPrice()));
        assertTrue("Ingredient or price not fount in receipt", findStringInReceipt(burger.getReceipt(),burger.ingredients.get(0).getName()));
        assertTrue("Ingredient or price not fount in receipt", findStringInReceipt(burger.getReceipt(),burger.ingredients.get(1).getName()));
        assertTrue("Ingredient or price not fount in receipt", findStringInReceipt(burger.getReceipt(),burger.ingredients.get(2).getName()));
        assertTrue("Ingredient or price not fount in receipt", findStringInReceipt(burger.getReceipt(),burger.ingredients.get(3).getName()));
        assertTrue("Ingredient or price not fount in receipt", findStringInReceipt(burger.getReceipt(),burgerPrice.toString()));
    }

    public boolean findStringInReceipt (String receipt, String receiptSubString){
        return receipt.contains(receiptSubString);
    }

}