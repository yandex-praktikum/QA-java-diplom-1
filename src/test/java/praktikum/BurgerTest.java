package praktikum;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    Burger burger = new Burger();
    СontainParam containParam = new СontainParam();
    @Mock
    Ingredient ingredient1;

    @Mock
    Ingredient ingredient2;

    @Mock
    Bun bun;

    @Test
    public void checkGetPriceBurger() {
        Mockito.when(bun.getPrice()).thenReturn(100f);
        Mockito.when(ingredient1.getPrice()).thenReturn(100f);
        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        assertEquals("Неверная цена бургера", containParam.getExpectedBurgerPrice(), burger.getPrice(), 0);
    }
    @Test
    public void checkGetBurgerReceipt() {
        burger.setBuns(bun);
        Mockito.when(bun.getName()).thenReturn("white bun");
        Mockito.when(bun.getPrice()).thenReturn(200f);

        burger.ingredients.add(ingredient1);
        Mockito.when(ingredient1.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredient1.getName()).thenReturn("hot sauce");
        Mockito.when(ingredient1.getPrice()).thenReturn(100f);

        burger.ingredients.add(ingredient2);
        Mockito.when(ingredient2.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ingredient2.getName()).thenReturn("sausage");
        Mockito.when(ingredient2.getPrice()).thenReturn(300f);

        Mockito.when(burger.getPrice()).thenReturn(700f);

        String actual = burger.getReceipt();
        String expected = String.format("(==== %s ====)%n", bun.getName()) +
                String.format("= %s %s =%n", ingredient1.getType().toString().toLowerCase(),
                        ingredient1.getName()) +
                String.format("= %s %s =%n", ingredient2.getType().toString().toLowerCase(),
                        ingredient2.getName()) +
                String.format("(==== %s ====)%n", bun.getName()) +
                String.format("%nPrice: %f%n", burger.getPrice());
        assertEquals("Рецепт бургера ошибочен", expected, actual);
    }
}
