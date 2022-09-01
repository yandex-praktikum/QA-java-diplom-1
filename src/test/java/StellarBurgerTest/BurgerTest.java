package StellarBurgerTest;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;

import static praktikum.IngredientType.*;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    @Mock
    Bun mockBun;
    @Mock
    Ingredient mockIngredient;
    @Mock
    Ingredient mockIngredient2;
    @Before
    public void prepareMocks(){
        Mockito.when(mockBun.getPrice()).thenReturn(0.5f);
        Mockito.when(mockBun.getName()).thenReturn("Cloud");
        Mockito.when(mockIngredient.getPrice()).thenReturn(1.2f);
        Mockito.when(mockIngredient.getName()).thenReturn("Rain");
        Mockito.when(mockIngredient.getType()).thenReturn(SAUCE);
        Mockito.when(mockIngredient2.getPrice()).thenReturn(1.6f);
        Mockito.when(mockIngredient2.getName()).thenReturn("Lightning");
        Mockito.when(mockIngredient2.getType()).thenReturn(FILLING);
    }

    @Test
    @DisplayName("Burger price test")
    @Description("Burger's price must be equal to sum of it parts price")
    public void priceOfBurgerTest(){
        Burger skyBurger = new Burger();
        skyBurger.setBuns(mockBun);
        skyBurger.addIngredient(mockIngredient);
        Assert.assertEquals(skyBurger.getPrice(), 2.2f, 0.0001);
    }

    @Test
    @DisplayName("Get receipt - Moving burger ingredient test")
    @Description("Burger's ingredient must have right position after moving")
    public void movingBurgerIngredientTest(){
        Burger skyBurger = new Burger();
        skyBurger.setBuns(mockBun);
        skyBurger.addIngredient(mockIngredient);
        skyBurger.addIngredient(mockIngredient2);
        skyBurger.moveIngredient(1,0);
        String testBurger = "(==== Cloud ====)\r\n= filling Lightning =\r\n" +
                "= sauce Rain =\r\n(==== Cloud ====)\r\n\r\nPrice: 3,800000\r\n";
        Assert.assertEquals(testBurger, skyBurger.getReceipt());
    }

    @Test
    @DisplayName("Get receipt - Deleting burger ingredient test")
    @Description("Burger's ingredient must be removed after deleting")
    public void deletingBurgerIngredientTest(){
        Burger skyBurger = new Burger();
        skyBurger.setBuns(mockBun);
        skyBurger.addIngredient(mockIngredient);
        skyBurger.addIngredient(mockIngredient2);
        skyBurger.removeIngredient(0);
        String testBurger = "(==== Cloud ====)\r\n= filling Lightning =\r\n" +
                "(==== Cloud ====)\r\n\r\nPrice: 2,600000\r\n";
        Assert.assertEquals(testBurger, skyBurger.getReceipt());
    }
}
