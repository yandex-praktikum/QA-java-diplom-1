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
    private Burger burger;

    @Mock
    private Bun bun;

    @Mock
    private Ingredient ingredient1, ingredient2, ingredient3;

    @Before
    public void createBurger() {
        burger = new Burger();
    }

    @Test
    public void setBunsTest() {
        burger.setBuns(bun);
        assertEquals(bun.getName(), burger.bun.getName());
        System.out.println("Выбрали булочку");
    }

    @Test
    public void addIngredientTest() {
        burger.addIngredient(ingredient1);
        assertEquals(1, burger.ingredients.size());
        System.out.println("Добавили ингредиент");
    }

    @Test
    public void removeIngredientTest() {
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.addIngredient(ingredient3);
        assertEquals(3, burger.ingredients.size());

        burger.removeIngredient(2);
        assertEquals(2, burger.ingredients.size());
        System.out.println("Удалили ингредиент");
    }

    @Test
    public void moveIngredientTest() {
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.addIngredient(ingredient3);
        burger.moveIngredient(1,2);

        assertEquals(ingredient2, burger.ingredients.get(2));
        assertEquals(ingredient3, burger.ingredients.get(1));
        System.out.println("Передвинули ингредиент");
    }

    @Test
    public void getPriceTest() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        when(bun.getPrice()).thenReturn(200F);
        when(ingredient1.getPrice()).thenReturn(100F);
        when(ingredient2.getPrice()).thenReturn(200F);

        float expected = (200F * 2) + 100F + 200F;

        assertEquals(expected, burger.getPrice(), 0);

        System.out.println("Стоимость бургера");
    }

    @Test
    public void getReceiptTest() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        when(bun.getName()).thenReturn("burger");
        when(ingredient1.getName()).thenReturn("ingredient1");
        when(ingredient2.getName()).thenReturn("ingredient2");
        when(bun.getPrice()).thenReturn(200F);
        when(ingredient1.getPrice()).thenReturn(100F);
        when(ingredient2.getPrice()).thenReturn(200F);
        when(ingredient1.getType()).thenReturn(IngredientType.SAUCE);
        when(ingredient2.getType()).thenReturn(IngredientType.FILLING);

        String expected = "(==== burger ====)\r\n" +
                "= sauce ingredient1 =\r\n" +
                "= filling ingredient2 =\r\n" +
                "(==== burger ====)\r\n" +
                "\r\n" +
                "Price: 700,000000\r\n";

        assertEquals(expected, burger.getReceipt());
    }
}
