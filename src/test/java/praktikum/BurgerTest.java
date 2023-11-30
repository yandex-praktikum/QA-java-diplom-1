package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    private final String BULKA_NAME = "пижонский багет";
    private final float BULKA_PRICE = 20f;
    private final String INGREDIENT_NAME = "соус тысяча островов";
    private final float INGREDIENT_PRICE = 1.37f;
    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient;
    @Mock
    Ingredient ingredientSecond;
    private Burger burger;

    @Before
    public void setup() {
        burger = new Burger();
    }

    @Test
    public void setBuns() {
        burger.setBuns(bun);
        Mockito.when(bun.getName()).thenReturn(BULKA_NAME);
        Assert.assertEquals("Некорректное наименование булочки", BULKA_NAME, bun.getName());
    }

    @Test
    public void addIngredient() {
        burger.addIngredient(ingredient);
        Assert.assertEquals("Кол-во ингредиентов некорректное", 1, burger.ingredients.size());
    }

    @Test
    public void removeIngredient() {
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        Assert.assertTrue("Ингредиент не удалился", burger.ingredients.isEmpty());
    }

    @Test
    public void moveIngredient() {
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredientSecond);
        burger.moveIngredient(0, 1);
        Assert.assertEquals("Ингредиенты не поменялись местами", "ingredientSecond", burger.ingredients.get(0).toString());
    }

    @Test
    public void getPrice() {
        burger.setBuns(bun);
        Mockito.when(bun.getPrice()).thenReturn(BULKA_PRICE);
        Assert.assertEquals("Цена бургера отличается отличается", BULKA_PRICE * 2, burger.getPrice(), 0);
    }

    @Test
    public void getReceipt() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        Mockito.when(bun.getName()).thenReturn(BULKA_NAME);
        Mockito.when(bun.getPrice()).thenReturn(BULKA_PRICE);
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredient.getName()).thenReturn(INGREDIENT_NAME);
        Mockito.when(ingredient.getPrice()).thenReturn(INGREDIENT_PRICE);
        String expectedReceiptBurger = String.format("(==== %s ====)%n", BULKA_NAME) +
                String.format("= %s %s =%n", ingredient.getType().toString().toLowerCase(), INGREDIENT_NAME) +
                String.format("(==== %s ====)%n", BULKA_NAME) +
                String.format("%nPrice: %f%n", (BULKA_PRICE * 2) + INGREDIENT_PRICE);

        Assert.assertEquals("Чек бургера отличается", expectedReceiptBurger, burger.getReceipt());
    }
}
