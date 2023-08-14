import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)

public class BurgerTest {
    private Burger burger;
    @Mock
    Bun bun;
    @Mock
    Ingredient sauce;
    @Mock
    Ingredient filling;

    @Before
    public void setUp(){
        burger = new Burger();
    }
    @Test
    public void setBunsTest(){
        burger.setBuns(bun);
        assertEquals(bun, burger.bun);
    }
    @Test
    public void addIngredientFillingTest(){
       int expected = 1;
       burger.addIngredient(filling);
       assertEquals("Количество ингредиентов после добавления не совпадает", expected, burger.ingredients.size());
    }
    @Test
    public void addIngredientSauceTest(){
        int expected = 1;
        burger.addIngredient(sauce);
        assertEquals("Количество ингредиентов после добавления не совпадает", expected, burger.ingredients.size());
    }
    @Test
    public void removeIngredientTest(){
        int expected = 1;
        burger.addIngredient(filling);
        burger.addIngredient(sauce);
        burger.removeIngredient(0);
        assertEquals("Количество ингредиентов после удаления не совпадает", expected, burger.ingredients.size());
    }
    @Test
    public void moveIngredientTest(){
        burger.addIngredient(sauce);
        burger.addIngredient(filling);
        burger.moveIngredient(0,1);
        assertEquals("Ингредиенты не поменялись местами", filling, burger.ingredients.get(0));
    }
    @Test
    public void getPriceBurgerTest(){
        burger.setBuns(bun);
        burger.addIngredient(sauce);
        burger.addIngredient(filling);
        Mockito.when(bun.getPrice()).thenReturn(100F);
        Mockito.when(sauce.getPrice()).thenReturn(50F);
        Mockito.when(filling.getPrice()).thenReturn(300F);
        assertEquals("Цена не совпадает", burger.getPrice(), 550, 0);
    }
    @Test
    public void getReceiptTest() {
        burger.setBuns(bun);
        burger.ingredients.add(filling);
        burger.ingredients.add(sauce);
        Mockito.when(bun.getName()).thenReturn("Булочка с кунжутом");
        Mockito.when(bun.getPrice()).thenReturn(100F);
        Mockito.when(filling.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(filling.getName()).thenReturn("Котлета из говядины");
        Mockito.when(filling.getPrice()).thenReturn(300F);
        Mockito.when(sauce.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(sauce.getName()).thenReturn("Горчица");
        Mockito.when(sauce.getPrice()).thenReturn(50F);
        String expected = String.format("(==== %s ====)%n", bun.getName()) + String.format("= %s %s =%n", filling.getType().toString().toLowerCase(), filling.getName()) + String.format("= %s %s =%n", sauce.getType().toString().toLowerCase(), sauce.getName()) + String.format("(==== %s ====)%n", bun.getName()) + String.format("%nPrice: %f%n", burger.getPrice());
        assertEquals("Некорректный чек", expected, burger.getReceipt());
    }





}
