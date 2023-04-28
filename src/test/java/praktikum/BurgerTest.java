package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient;
    Burger burger;
    private final int TEST_INDEX = 0;
    private final int NEW_TEST_INDEX = 1;
    private final float PRICE_OF_BURGER = 300F;
    private final float PRICE_OF_BUN = 100F;
    private final float PRICE_OF_INGREDIENT = 100F;
    private final int INGREDIENT_SIZE = 1;
    @Before
    public void init(){
        burger = new Burger();
    }
    @Test
    public void setBunsAddObjectBunNotNull(){
        burger.setBuns(bun);
        Assert.assertNotNull("Метод setBuns класса Burger - не добавляется новый объект булочек", burger.bun);
    }
    @Test
    public void addIngredientAddListIngredientsSizeAboveZiro(){
        burger.addIngredient(ingredient);
        int actual = burger.ingredients.size();
        int expected = INGREDIENT_SIZE;
        Assert.assertEquals("Метод addIngredient класса Burger - не добавляется новые элемены в список ингридиентов",expected, actual);
    }
    @Test
    public void removeIngredientRemoveListElementListEmpty(){
        burger.ingredients.add(ingredient);
        burger.removeIngredient(0);
        Assert.assertEquals("Метод removeIngredient класса Burger - не удаляет элемент списка ингридиентов", true, burger.ingredients.isEmpty());
    }
    @Test
    public void moveIngredientMoveListElementPositiveResult(){
        Ingredient ingredient1 = Mockito.mock(Ingredient.class);
        Ingredient ingredient2 = Mockito.mock(Ingredient.class);
        burger.ingredients.add(ingredient1);
        burger.ingredients.add(ingredient2);
        burger.moveIngredient(TEST_INDEX, NEW_TEST_INDEX);
        Assert.assertEquals("Метод moveIngredient класса Burger - не меняет местами элементы списка ингридиентов",burger.ingredients.get(0), ingredient2);
    }
    @Test
    public void getPriceValidDataPositiveResult(){
        Mockito.when(bun.getPrice()).thenReturn(PRICE_OF_BUN);
        Mockito.when(ingredient.getPrice()).thenReturn(PRICE_OF_INGREDIENT);
        burger.ingredients.add(ingredient);
        burger.bun = bun;
        Assert.assertEquals("Метод getPrice класса Burger - не корректный подсчет стоимости", PRICE_OF_BURGER, burger.getPrice(), 0);
    }
    @Test
    public void getReceipt(){
        Mockito.when(bun.getName()).thenReturn("testBunName");
        Mockito.when(ingredient.getName()).thenReturn("testIngredientName");
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(bun.getPrice()).thenReturn(PRICE_OF_BUN);
        Mockito.when(ingredient.getPrice()).thenReturn(PRICE_OF_INGREDIENT);
        // Собрад все необходимые моки

        StringBuilder expectedReceipt = new StringBuilder(String.format("(==== %s ====)%n", "testBunName"));
        expectedReceipt.append(String.format("= %s %s =%n", "sauce", "testIngredientName"));
        expectedReceipt.append(String.format("(==== %s ====)%n", "testBunName"));
        expectedReceipt.append(String.format("%nPrice: %f%n", PRICE_OF_BURGER));
        String expectedResult = expectedReceipt.toString();
        // Сгенерировал ожидаемый результат

        burger.bun = bun;
        burger.addIngredient(ingredient);
        String actualResult = burger.getReceipt();
        // Запуск проверяемого метода и генерация актуального результата

        Assert.assertEquals("Метод getReceipt класса Burger - не корректная генерация рецепта", expectedResult, actualResult );
    }
}
