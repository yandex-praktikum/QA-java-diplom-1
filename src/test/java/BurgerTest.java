
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient;
    private Burger burger;

    @Before
    public void setBurger() {
        burger = new Burger();
    }

    @Test
    public void setBunsTest() {
        burger.setBuns(bun);
        assertEquals("Булка для бургера отличается от ожидаемой",
                bun, burger.bun);
    }

    @Test
    public void addIngredientTest() {
        burger.addIngredient(ingredient);
        assertEquals("Количество ингредиентов не соответствует ожидаемому",
                1, burger.ingredients.size());
    }

    @Test
    public void removeIngredientTest() {
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        assertEquals("Количество ингредиентов не соответствует ожидаемому",
                0, burger.ingredients.size());
    }

    @Test
    public void moveIngredientTest() {
        String bunName = "Флюоресцентная булка R2-D3";
        String sauceName = "Соус Spicy-X";
        burger.addIngredient(new Ingredient(IngredientType.FILLING, bunName, 988));
        burger.addIngredient(new Ingredient(IngredientType.SAUCE, sauceName, 90));
        burger.moveIngredient(1, 0);
        assertEquals("Ингредиент под индексом \"1\" не соответствует ожидаемому",
                sauceName, burger.ingredients.get(0).name);
    }

    @Test
    public void getPriceTest() {
        float price = 8906;
        when(bun.getPrice()).thenReturn(price);
        when(ingredient.getPrice()).thenReturn(price);
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        float expectedPrice = price * 3;
        Assert.assertTrue("Цена бургера не соответствует ожидаемой",
                expectedPrice == burger.getPrice());
    }

    @Test
    public void getReceiptTest() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        String bunName = "Флюоресцентная булка R2-D3";
        Float bunPrice = 100f;
        String sauceName = "Соус фирменный Space Sauce";
        Float saucePrice = 100f;

        when(bun.getName()).thenReturn(bunName);
        when(bun.getPrice()).thenReturn(bunPrice);
        when(ingredient.getType()).thenReturn(IngredientType.SAUCE);
        when(ingredient.getName()).thenReturn(sauceName);
        when(ingredient.getPrice()).thenReturn(saucePrice);
        String expected = "(==== "+ bunName +" ====)" + "\n" + "= sauce "+ sauceName +" =" + "\n" + "(==== Флюоресцентная булка R2-D3 ====)" + "\n\n" + "Price: 300.000000" + "\n";
        Assert.assertEquals("Строка с чеком не соответствует ожидаемой",
                expected, burger.getReceipt());
    }
}