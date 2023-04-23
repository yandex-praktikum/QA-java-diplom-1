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
public class BurgerGetPriceTest {
    private Bun bun = Mockito.mock(Bun.class);
    private static IngredientType type;
    private Burger burger = new Burger();
    private Ingredient newIngredient1;
    private Ingredient newIngredient2;
    private float expectedPrice;

    public BurgerGetPriceTest(Ingredient newIngredient1, Ingredient newIngredient2, float expectedPrice) {
        this.newIngredient1 = newIngredient1;
        this.newIngredient2 = newIngredient2;
        this.expectedPrice = expectedPrice;
    }

    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][]{
                {new Ingredient(type.FILLING,"cucumber",32),new Ingredient(type.SAUCE,"ketchup",10),62.4F},
                {new Ingredient(type.FILLING,"meat",52),new Ingredient(type.SAUCE,"mayonesse",10),82.4F},
                {new Ingredient(type.FILLING,"tomato",52),new Ingredient(type.FILLING,"meat",100.50F),172.9F}
        };
    }

    @Test
    public void getPriceTest() {
        burger.addIngredient(newIngredient1);
        burger.addIngredient(newIngredient2);
        Mockito.when(bun.getPrice()).thenReturn(10.2F);
        burger.setBuns(bun);
        assertEquals(expectedPrice,burger.getPrice(),0.0f);
    }
}
