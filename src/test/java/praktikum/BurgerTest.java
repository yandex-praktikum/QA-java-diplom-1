package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    private Burger burger;

    @Mock
    private Bun bun;
    @Mock
    private Ingredient ingredientOne, ingredientTwo, ingredientThree;

    @Before
    public void createBurger() {
        burger = new Burger();
    }

    @Test
    public void setBun() {
        burger.setBuns(bun);

        assertEquals(bun.getName(), burger.bun.getName());
    }

    @Test
    public void addIngredient() {
        burger.addIngredient(ingredientOne);

        assertEquals(1, burger.ingredients.size());
    }

    @Test
    public void moveIngredient() {
        burger.addIngredient(ingredientOne);
        burger.addIngredient(ingredientTwo);
        burger.addIngredient(ingredientThree);

        burger.moveIngredient(1, 2);

        assertEquals(ingredientTwo, burger.ingredients.get(2));
        assertEquals(ingredientThree, burger.ingredients.get(1));
    }

    @Test
    public void removeIngredient() {
        burger.addIngredient(ingredientOne);
        burger.addIngredient(ingredientTwo);
        burger.addIngredient(ingredientThree);
        assertEquals(3, burger.ingredients.size());
        burger.removeIngredient(2);
        assertEquals(2, burger.ingredients.size());
    }

    @Test
    public void getPrice() {
        burger.setBuns(bun);
        burger.addIngredient(ingredientOne);
        burger.addIngredient(ingredientTwo);
        burger.addIngredient(ingredientThree);

        when(bun.getPrice()).thenReturn(988F);
        when(ingredientOne.getPrice()).thenReturn(15F);
        when(ingredientTwo.getPrice()).thenReturn(300F);
        when(ingredientThree.getPrice()).thenReturn(762F);

        assertEquals(3053F, burger.getPrice(), 0);
    }

    @Test
    public void getReceipt() {
        burger.setBuns(bun);
        burger.addIngredient(ingredientOne);
        burger.addIngredient(ingredientTwo);

        when(bun.getName()).thenReturn("Флюоресцентная булка R2-D3");
        when(ingredientOne.getName()).thenReturn("Соус традиционный галактический");
        when(ingredientTwo.getName()).thenReturn("Кристаллы марсианских альфа-сахаридов");
        when(bun.getPrice()).thenReturn(988F);
        when(ingredientOne.getPrice()).thenReturn(15F);
        when(ingredientTwo.getPrice()).thenReturn(762F);
        when(ingredientOne.getType()).thenReturn(IngredientType.SAUCE);
        when(ingredientTwo.getType()).thenReturn(IngredientType.FILLING);

        String expected = "(==== Флюоресцентная булка R2-D3 ====)\r\n" + "= sauce Соус традиционный галактический =\r\n" + "= filling Кристаллы марсианских альфа-сахаридов =\r\n" + "(==== Флюоресцентная булка R2-D3 ====)\r\n" + "\r\n" + "Price: 2753,000000\r\n";

        assertEquals(expected, burger.getReceipt());
    }


}
