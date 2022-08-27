package praktikum;

import com.github.javafaker.Faker;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient;
    Burger burger;
    Faker faker;

    @Before
    public void setUp(){
        burger = new Burger();
        faker = new Faker();
    }


    @Test
    public void setBunsShouldSetGivenBun() {
        burger.setBuns(bun);
        Bun expectedValue = burger.bun;
        assertEquals(expectedValue, bun);
    }

    @Test
    public void addIngredientShouldAddOneValueAndContainsGivenIngredient() {
        burger.addIngredient(ingredient);
        assertEquals(burger.ingredients.size(), 1);
        assertTrue(burger.ingredients.contains(ingredient));
    }

    @Test
    public void removeIngredientShouldLeaveEmptyListOfIngredients() {
        burger.addIngredient(ingredient);
        int index = burger.ingredients.indexOf(ingredient);
        burger.removeIngredient(index);
        assertTrue(burger.ingredients.isEmpty());
    }

    @Test
    public void moveIngredientShouldAddOneValueAndAssignNewIndex() {
        burger.addIngredient(ingredient);
        int currentIndex = burger.ingredients.indexOf(ingredient);
        int newIndex = 0;
        burger.moveIngredient(currentIndex, newIndex);
        assertEquals(burger.ingredients.size(), 1);
        assertEquals(burger.ingredients.indexOf(ingredient), newIndex);
    }

    @Test
    public void getPrice() {
        float testBunPrice = faker.number().numberBetween(1, 888);
        float testIngredientPrice = faker.number().numberBetween(1, 888);
        float expectedValue = testBunPrice * 2 + testIngredientPrice;

        burger.setBuns(bun);
        Mockito.when(bun.getPrice()).thenReturn(testBunPrice);
        Mockito.when(ingredient.getPrice()).thenReturn(testIngredientPrice);
        burger.addIngredient(ingredient);
        float actual = burger.getPrice();
        assertEquals(expectedValue, actual, 0.0);
    }

    @Test
    public void getReceiptShouldReturnCorrectString() {
        String testName = faker.name().firstName();
        float testBunPrice = faker.number().numberBetween(1, 888);
        burger.setBuns(bun);
        Mockito.when(bun.getName()).thenReturn(testName);
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(bun.getPrice()).thenReturn(testBunPrice);
        burger.addIngredient(ingredient);
        String actual = burger.getReceipt();
        String expectedValue = String.format("(==== %s ====)%n= sauce null =%n(==== %s ====)%n%nPrice: %f%n", testName, testName, testBunPrice * 2);
        assertEquals(expectedValue, actual);
    }
}