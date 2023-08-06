package praktikum;

import org.hamcrest.MatcherAssert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import static org.hamcrest.CoreMatchers.is;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    Burger burger = new Burger();

    @Mock
    Bun bun;
    @Mock
    Ingredient testSpaceSauce, testSpaceFillet;

    @Test
    public void testAddBun(){
        burger.setBuns(bun);
        MatcherAssert.assertThat("Какая-то странная булочка...", bun, is (burger.bun));
    }

    @Test
    public void testAddIngredient(){
        burger.addIngredient(testSpaceSauce);
        MatcherAssert.assertThat("Остренько)))))", testSpaceSauce, is (burger.ingredients.get(0)));
    }

    @Test
    public void testRemoveIngredient(){
        burger.addIngredient(testSpaceFillet);
        burger.removeIngredient(0);
        MatcherAssert.assertThat("А где мой заказ? 0_0", 0, is(burger.ingredients.size()));
    }

    @Test
    public void testMoveIngredient(){
        burger.addIngredient(testSpaceSauce);
        burger.addIngredient(testSpaceFillet);
        burger.moveIngredient(0,1);
        MatcherAssert.assertThat("Я просил чтобы сверху было филе!!!", testSpaceFillet, is(burger.ingredients.get(0)));
    }

    @Test
    public void testPrice(){
        burger.setBuns(bun);
        burger.addIngredient(testSpaceSauce);
        burger.addIngredient(testSpaceFillet);
        Mockito.when(bun.getPrice()).thenReturn(1255.0E0f);
        Mockito.when(testSpaceSauce.getPrice()).thenReturn(80.0E0f);
        Mockito.when(testSpaceFillet.getPrice()).thenReturn(988.0E0f);
        MatcherAssert.assertThat("Ты кого хочешь обмануть?" ,3578.0E0f ,is(burger.getPrice()));
    }

    @Test
    public void testReceipt(){
        burger.setBuns(bun);
        burger.addIngredient(testSpaceSauce);
        burger.addIngredient(testSpaceFillet);
        String expectedReceipt = "(==== Краторная булка N-200i ====)\n= sauce Соус фирменный Space Sauce =\n= filling Филе Люминесцентного тетраодонтимформа =\n(==== Краторная булка N-200i ====)\n\nPrice: 3578,000000\n";
        Mockito.when(bun.getName()).thenReturn("Краторная булка N-200i");
        Mockito.when(bun.getPrice()).thenReturn(1255.0E0f);
        Mockito.when(testSpaceSauce.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(testSpaceSauce.getName()).thenReturn("Соус фирменный Space Sauce");
        Mockito.when(testSpaceSauce.getPrice()).thenReturn(80.0E0f);
        Mockito.when(testSpaceFillet.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(testSpaceFillet.getName()).thenReturn("Филе Люминесцентного тетраодонтимформа");
        Mockito.when(testSpaceFillet.getPrice()).thenReturn(988.0E0f);
        Mockito.when(bun.getName()).thenReturn("Краторная булка N-200i");
        Mockito.when(bun.getPrice()).thenReturn(1255.0E0f);
        MatcherAssert.assertThat("Вы хотели обмануть дядю Йосю?", expectedReceipt, is(burger.getReceipt()));
    }

}