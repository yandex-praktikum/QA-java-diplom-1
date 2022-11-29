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
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    Burger burger;

    @Mock
    Bun mockBun;
    @Mock
    Ingredient mockIngredient;

    @Before
    public void startTest(){
        burger = new Burger();
        burger.addIngredient(new Ingredient(SAUCE, "hot sauce", 100));
        burger.addIngredient(new Ingredient(SAUCE, "sour cream", 200));
        burger.addIngredient(new Ingredient(IngredientType.FILLING, "cutlet", 300));
        burger.addIngredient(new Ingredient(IngredientType.FILLING, "cutlet", 100));
        burger.addIngredient(new Ingredient(IngredientType.FILLING, "dinosaur", 200));
        burger.addIngredient(new Ingredient(IngredientType.FILLING, "sausage", 300));
    }

    @Test
    public void checkAddIngredient (){
        int expected = 6;
        int actual = burger.ingredients.size();
        String actualName = burger. ingredients.get(2).name;
        Float  actualPrice = burger.ingredients.get(0).price;
        IngredientType actualType = burger.ingredients.get(1).type;
        assertEquals(expected,actual);
        assertEquals("Должны совпадать","cutlet",actualName);
        assertEquals("Цена должна одинакова", 100,actualPrice,3);
        assertEquals("Тип должен совпадать" ,SAUCE,actualType);
    }
    @Test
    public void checkRemoveIngredient(){
        burger.removeIngredient(1);
        burger.removeIngredient(4);
        int expected = 4;
        int actual = burger.ingredients.size();
        assertEquals("Размер списка должен быть равен",expected,actual);
    }
    @Test
    public void checkMoveIngredient(){
        String expectedName = burger.ingredients.get(1).name;
        Float expectedPrice = burger.ingredients.get(3).price;
        IngredientType expectedType = burger.ingredients.get(0).type;
        burger.moveIngredient(1, 5);
        burger.moveIngredient(0, 3);
        String actualName = burger.ingredients.get(5).name;
        Float actualPrice = burger.ingredients.get(1).price;
        IngredientType actualType = burger.ingredients.get(3).type;
        assertEquals("Должно быть sour cream",expectedName,actualName);
        assertEquals("Должно быть 100",expectedPrice,actualPrice);
        assertEquals("",expectedType,actualType);
    }
    @Test
    public void checkGetPrice(){
        Mockito.when(mockBun.getPrice()).thenReturn(233.4f);
        burger.setBuns(mockBun);
        Float actual = burger.getPrice();
        Float expected = 1666.8f;
        assertEquals("Должна быть равна",expected,actual,2);
    }
    @Test
    public void checkGetReceipt(){
        burger = new Burger();
        Mockito.when(mockIngredient.getName()).thenReturn("dinosaur");
        Mockito.when(mockIngredient.getType()).thenReturn(FILLING);
        Mockito.when(mockIngredient.getPrice()).thenReturn(100f);
        burger.addIngredient(mockIngredient);
        Mockito.when(mockBun.getName()).thenReturn("black bun");
        Mockito.when(mockBun.getPrice()).thenReturn(154.8F);
        burger.setBuns(mockBun);
        StringBuilder expected = new StringBuilder();
        expected.append(String.format("(==== %s ====)%n",mockBun.getName()));
        expected.append(String.format("= %s %s =%n",burger.ingredients.get(0).getType().toString().toLowerCase(),
                burger.ingredients.get(0).getName()));
        expected.append(String.format("(==== %s ====)%n","black bun"));
        expected.append(String.format("%nPrice: %f%n", burger.getPrice()));
        String expectedReceipt = expected.toString();
        String actual =  burger.getReceipt();
        assertEquals(expectedReceipt,actual);
    }

}
