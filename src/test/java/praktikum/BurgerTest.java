package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    //Проверка, что метод setBuns() устанавливает введенные значения
    @Test
    public void testSetBuns() {
        Burger burger = new Burger();
        Bun bun = new Bun("Краторная булка N-200i", 1255);

        burger.setBuns(bun);

        Assert.assertSame(bun, burger.bun);
    }

    //Проверка, что метод addIngredient() добавил конкретный объект данных в список ingredients
    @Test
    public void testAddIngredient() {
        Burger burger = new Burger();
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, "Говяжий метеорит (отбивная)", 3000);

        burger.addIngredient(ingredient);

        Assert.assertTrue(burger.ingredients.contains(ingredient));

    }

    //Проверка, что метод removeIngredient() удаляет ингредиент по указанному индексу
    @Test
    public void testRemoveIngredient() {
        Burger burger = new Burger();
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, "Говяжий метеорит (отбивная)", 3000);
        burger.addIngredient(ingredient);

        burger.removeIngredient(0);

        Assert.assertFalse(burger.ingredients.contains(ingredient));

    }

    //Проверка, что метод moveIngredient() перемещает ингредиент с одного указанного индекса на другой
    @Test
    public void testMoveIngredient() {
        Burger burger = new Burger();
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, "Говяжий метеорит (отбивная)", 3000);
        Ingredient ingredient2 = new Ingredient(IngredientType.FILLING, "Биокотлета из марсианской Магнолии", 424);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient2);

        burger.moveIngredient(0,1);

        Assert.assertEquals(ingredient, burger.ingredients.get(1));
    }

    @Mock
    Bun bun;

    @Test
    public void testGetReceipt() {
        Burger burger = new Burger();
        Mockito.when(bun.getName()).thenReturn("Краторная булка N-200i");
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, "Говяжий метеорит (отбивная)", 3000);
        Ingredient ingredient2 = new Ingredient(IngredientType.FILLING, "Биокотлета из марсианской Магнолии", 424);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient2);
        burger.setBuns(bun);

        String actualReceipt = burger.getReceipt();
        String expectedReceipt = "(==== Краторная булка N-200i ====)\r\n= filling Говяжий метеорит (отбивная) =\r\n" +
                "= filling Биокотлета из марсианской Магнолии =\r\n(==== Краторная булка N-200i ====)\r\n\r\nPrice: 3424,000000\r\n";
        Assert.assertEquals(expectedReceipt, actualReceipt);
    }
}
