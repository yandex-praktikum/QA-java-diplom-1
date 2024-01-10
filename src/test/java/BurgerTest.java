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
    @Mock
    Ingredient ingredient1;
    @Mock
    Ingredient ingredient2;
    @Mock
    Bun bun;

    Burger burger;

    @Before
    public void setup() {
        burger = new Burger();
    }

    @Test
    public void addIngredientIsSuccessful() {
        burger.addIngredient(ingredient1);
        assertEquals(1, burger.ingredients.size());
    }

    @Test
    public void removeIngredientTest(){
        addIngredientsToBurger(burger);
        assertEquals(2, burger.ingredients.size());

        burger.removeIngredient(1);
        assertEquals(1, burger.ingredients.size());
    }

    @Test
    public void moveIngredientTest() {
        int oldIndex = 1;
        int newIndex = 0;
        String ingredient2Name = "Огурчик";

        addIngredientsToBurger(burger);
        /* проверим, что ingredient2 находится на позиции 1 */
        assertEquals(ingredient2Name, burger.ingredients.get(oldIndex).getName());

        burger.moveIngredient(oldIndex, newIndex);

        /* проверим, что ingredient2 был перемещён на позицию 0 */
        assertEquals(ingredient2Name, burger.ingredients.get(newIndex).getName());
        /* убедимся, что размер списка не изменился */
        assertEquals(2, burger.ingredients.size());
    }


    @Test
    public void getPriceTest(){
        float expectedPrice = 4.91f;

        burger.setBuns(bun);
        float bunPrice = 1.23f;

        Mockito.when(bun.getPrice()).thenReturn(bunPrice);

        addIngredientsToBurger(burger);

        float actualPrice = burger.getPrice();

        assertEquals(expectedPrice, actualPrice, 0);

    }

    @Test
    public void getReceiptTest(){
        String expectedResult =
                "(==== Ржаная булочка ====)" + System.lineSeparator() +
                        "= sauce Кетчуп =" + System.lineSeparator() +
                        "= filling Огурчик =" + System.lineSeparator() +
                        "(==== Ржаная булочка ====)" + System.lineSeparator() + System.lineSeparator() +
                        "Price: 4,650000" + System.lineSeparator();

        addIngredientsToBurger(burger);
        burger.setBuns(bun);

        Mockito.when(bun.getPrice()).thenReturn(1.1f);
        Mockito.when(bun.getName()).thenReturn("Ржаная булочка");

        String actualResult = burger.getReceipt();
        assertEquals(expectedResult, actualResult);
    }

    /* вспомогательные методы */
    /* добавить 2 ингредиента */
    private void addIngredientsToBurger(Burger burger){
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);

        Mockito.when(ingredient1.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredient1.getName()).thenReturn("Кетчуп");
        Mockito.when(ingredient1.getPrice()).thenReturn(1.5f);

        Mockito.when(ingredient2.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ingredient2.getName()).thenReturn("Огурчик");
        Mockito.when(ingredient2.getPrice()).thenReturn(0.95f);
    }

}
