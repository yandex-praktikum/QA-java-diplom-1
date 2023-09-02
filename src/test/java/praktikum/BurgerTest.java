package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    Burger burger;

    @Mock
    Bun mockBun;
    @Mock
    Ingredient mockIngredientFirst;
    @Mock
    Ingredient mockIngredientSecond;

    @Before
    public void init() {
        burger = new Burger();
    }

    @Test
    public void setBunsTest() {
        Mockito.when(mockBun.getName()).thenReturn("Та самая булочка");
        burger.setBuns(mockBun);
        Assert.assertEquals("Та самая булочка", burger.bun.getName());
    }

    @Test
    public void addIngredientTest() {
        Mockito.when(mockIngredientFirst.getName()).thenReturn("Тот самый ингредиент");
        burger.addIngredient(mockIngredientFirst);
        Assert.assertEquals("Тот самый ингредиент", burger.ingredients.get(0).getName());
    }

    @Test
    public void removeIngredientTest() {
        Mockito.when(mockIngredientSecond.getName()).thenReturn("Второй добавленный ингредиент");
        burger.addIngredient(mockIngredientFirst);
        burger.addIngredient(mockIngredientSecond);

        burger.removeIngredient(0);
        Assert.assertEquals("Второй добавленный ингредиент", burger.ingredients.get(0).getName());
    }


    @Test
    public void moveIngredientTest() {
        Mockito.when(mockIngredientFirst.getName()).thenReturn("Первый добавленный ингредиент");
        burger.addIngredient(mockIngredientFirst);
        burger.addIngredient(mockIngredientSecond);

        burger.moveIngredient(1, 0);
        Assert.assertEquals("Первый добавленный ингредиент", burger.ingredients.get(1).getName());

    }

    @Test
    public void getPriceReturnPriceBurgerTest() {
        // лучше бы тоже с параметрами сделать (пустой, 1 ингр, три ирнг)
        // сравнить цену
    }

    @Test
    public void getReceiptReturnReceiptBurgerTest() {
        burger.setBuns(mockBun);
        burger.addIngredient(mockIngredientFirst);
        burger.addIngredient(mockIngredientSecond);

        Mockito.when(mockBun.getName()).thenReturn("Флюоресцентная булка R2-D3");
        Mockito.when(mockBun.getPrice()).thenReturn(300.00f);
        Mockito.when(mockIngredientFirst.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(mockIngredientFirst.getName()).thenReturn("Соус Spicy-X");
        Mockito.when(mockIngredientFirst.getPrice()).thenReturn(20.00f);
        Mockito.when(mockIngredientSecond.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(mockIngredientSecond.getName()).thenReturn("Мясо бессмертных моллюсков Protostomia");
        Mockito.when(mockIngredientSecond.getPrice()).thenReturn(1000.00f);

        String expectedReceipt = new StringBuilder(String.format("(==== Флюоресцентная булка R2-D3 ====)%n"))
                .append(String.format("= sauce Соус Spicy-X =%n"))
                .append(String.format("= filling Мясо бессмертных моллюсков Protostomia =%n"))
                .append(String.format("(==== Флюоресцентная булка R2-D3 ====)%n"))
                .append(String.format("%nPrice: 1620,000000%n")).toString();

        Assert.assertEquals(expectedReceipt, burger.getReceipt());



    }
}
