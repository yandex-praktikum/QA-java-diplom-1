import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BurgerPriceTest {

    private Burger burger = new Burger();
    private Bun bun = Mockito.mock(Bun.class);
    private static IngredientType type;
    private Ingredient firstIngredient;
    private Ingredient secondIngredient;
    private Ingredient thirdIngredient;

    private float expectedPrice;

    public BurgerPriceTest(Ingredient firstIngredient, Ingredient secondIngredient, Ingredient thirdIngredient, float expectedPrice) {
        this.firstIngredient = firstIngredient;
        this.secondIngredient = secondIngredient;
        this.thirdIngredient = thirdIngredient;
        this.expectedPrice = expectedPrice;
    }

    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][]{
                {new Ingredient(type.FILLING,"turkey",10.12f),new Ingredient(type.SAUCE,"mayonnaise", 7), new Ingredient(type.SAUCE,"potato", 1), 18.18F},
                {new Ingredient(type.FILLING,"rabbit",0),new Ingredient(type.FILLING,"sugar",0), new Ingredient(type.FILLING,"sugar",0), 0.06F},
                {new Ingredient(type.SAUCE,"garlic",200),new Ingredient(type.SAUCE,"cheese",800), new Ingredient(type.SAUCE,"ice cream",100), 1100.06F}
        };
    }

    @Test
    public void getBurgerPriceTest() {
        burger.addIngredient(firstIngredient);
        burger.addIngredient(secondIngredient);
        burger.addIngredient(thirdIngredient);
        Mockito.when(bun.getPrice()).thenReturn(0.03F);
        burger.setBuns(bun);
        assertEquals(expectedPrice,burger.getPrice(),0.00f);
    }
}