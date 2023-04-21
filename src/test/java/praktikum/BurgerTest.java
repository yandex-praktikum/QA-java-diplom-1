package praktikum;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static praktikum.IngredientType.FILLING;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    Burger burger = new Burger();
    private float PRICE_BUN = new Random().nextFloat();
    private float PRICE_INGREDIENT = new Random().nextFloat();
    private float PRICE_INGREDIENT_FILLING = new Random().nextFloat();
    private float PRICE_INGREDIENT_SAUCE = new Random().nextFloat();
    Faker faker = new Faker();
    private String NAME_INGREDIENT = faker.resolve("food.ingredients");
    private String NAME_INGREDIENT_FILLING = faker.resolve("food.ingredients");
    private String NAME_INGREDIENT_SAUCE = faker.resolve("food.ingredients");
    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient;
    @Mock
    Ingredient newIngredient;

    @Before
    public void setUp() {
        Mockito.when(bun.getPrice()).thenReturn(PRICE_BUN);
        Mockito.when(ingredient.getPrice()).thenReturn(PRICE_INGREDIENT);
        Mockito.when(ingredient.getName()).thenReturn(NAME_INGREDIENT);
    }


    @Test
    public void setBunsTest() {
        burger.setBuns(bun);
        assertEquals(bun, burger.bun);
    }

    @Test
    public void addIngredientTest() {
        burger.addIngredient(ingredient);
        assertNotNull("Размер списка не равен 0", burger.ingredients.size());
    }

    @Test
    public void removeIngredientTest() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        float expectedPrice = PRICE_BUN * 2;

        Assert.assertEquals(expectedPrice, burger.getPrice(), 0);
    }

    @Test
    public void moveIngredientTest() {
        burger.addIngredient(new Ingredient(IngredientType.FILLING, NAME_INGREDIENT_FILLING, PRICE_INGREDIENT_FILLING));
        burger.addIngredient(new Ingredient(IngredientType.SAUCE, NAME_INGREDIENT_SAUCE, PRICE_INGREDIENT_SAUCE));
        burger.moveIngredient(0, 1);
        burger.moveIngredient(0, 1);

        System.out.println(NAME_INGREDIENT);
        System.out.println(NAME_INGREDIENT_FILLING);
        System.out.println(NAME_INGREDIENT_SAUCE);
        assertEquals(NAME_INGREDIENT_SAUCE, burger.ingredients.get(1).getName());

    }

    @Test
    public void getPriceTest() {
        Mockito.when(ingredient.getPrice()).thenReturn(PRICE_INGREDIENT);
        Mockito.when(bun.getPrice()).thenReturn(PRICE_BUN);
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient);
        float actualPrice = burger.getPrice();
        float expectedPrice = PRICE_BUN * 2 + PRICE_INGREDIENT * 3;
        assertEquals(expectedPrice, actualPrice, 0);
    }

    @Test
    public void getReceiptTest() {
        Mockito.when(ingredient.getName()).thenReturn(NAME_INGREDIENT);
        Mockito.when(ingredient.getType()).thenReturn(FILLING);
        Mockito.when(ingredient.getPrice()).thenReturn(PRICE_INGREDIENT);
        burger.addIngredient(ingredient);
        Mockito.when(bun.getName()).thenReturn(NAME_INGREDIENT);
        Mockito.when(bun.getPrice()).thenReturn(PRICE_BUN);
        burger.setBuns(bun);
        String expectedReceipt = String.format("(==== %s ====)%n", bun.getName()) +
                String.format("= %s %s =%n",
                        burger.ingredients.get(0).getType().toString().toLowerCase(),
                        burger.ingredients.get(0).getName()) +
                String.format("(==== %s ====)%n", NAME_INGREDIENT) +
                String.format("%nPrice: %f%n", burger.getPrice());
        String actual = burger.getReceipt();
        System.out.println(NAME_INGREDIENT);
        System.out.println(PRICE_INGREDIENT);
        System.out.println(NAME_INGREDIENT_FILLING);
        System.out.println(PRICE_BUN);
        assertEquals(expectedReceipt, actual);
    }
}
