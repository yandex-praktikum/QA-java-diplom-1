package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    Bun bun;

    @Mock
    Ingredient ingredient;

    @Test
    public void addIngredientTest() {

        String expectedIngredientName = "hot sauce";
        Burger burger = new Burger();
        burger.addIngredient(new Ingredient(IngredientType.SAUCE, "hot sauce", 100));
        String actualIngredientName = String.valueOf(burger.ingredients.get(0).getName());
        assertEquals("Название элемента не совпадает", expectedIngredientName, actualIngredientName);

    }

    @Test
    public void getPriceTest() {
        Burger burger = new Burger();

        when(bun.getPrice()).thenReturn(50.0F);
        burger.setBuns(bun);
        when(ingredient.getPrice()).thenReturn(50.0F);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient);

        float expectedPrice = 200.0F;
        float actualPrice = burger.getPrice();

        assertEquals("Ожидаемая цена " + expectedPrice + ". Фактическая " + actualPrice,
                expectedPrice, actualPrice, 0.1);
    }

    @Test
    public void removeIngredientTest() {
        Burger burger = new Burger();
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "hot sauce", 100);
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);

        int actualQuantityOfIngredients = burger.ingredients.size();
        int expectedQuantityOfIngredients = 0;

        assertEquals("Ожидаемое кол-во элементов в списке " + expectedQuantityOfIngredients +
                ". Фактическое " + actualQuantityOfIngredients,
                expectedQuantityOfIngredients, actualQuantityOfIngredients);
    }

    @Test
    public void moveIngredientTest() {
        String expectedIngredientName = "chili sauce";
        // Создаем бургер, добавляем 3 ингредиента
        Burger burger = new Burger();
        burger.addIngredient(new Ingredient(IngredientType.SAUCE, "hot sauce", 100));
        burger.addIngredient(new Ingredient(IngredientType.SAUCE, "sour cream", 200));
        burger.addIngredient(new Ingredient(IngredientType.SAUCE, "chili sauce", 300));
        // Переставляем последний элемент на место первого
        burger.moveIngredient(2,0);
        // Получаем название ингредиента
        String actualIngredientName = String.valueOf(burger.ingredients.get(0).getName());
        // Сравниваем плученное название с ожидаемым
        assertEquals("Ожидаемое название ингредиента " + expectedIngredientName +
                "Фактическое " + actualIngredientName, expectedIngredientName, actualIngredientName);
    }

    @Test
    public void getReceiptTest() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        when(bun.getName()).thenReturn("Cheeky Buns");
        when(ingredient.getType()).thenReturn(IngredientType.SAUCE);
        when(ingredient.getName()).thenReturn("Meat and Greet");
        when(burger.getPrice()).thenReturn(500.0F);

        String actualReceipt  = burger.getReceipt();
        String expectedReceipt =
                String.format("(==== %s ====)%n", "Cheeky Buns") +
                String.format("= %s %s =%n", "sauce", "Meat and Greet") +
                String.format("(==== %s ====)%n", "Cheeky Buns") +
                String.format("%nPrice: %f%n", 500.0);

        assertEquals("Ожидаемый чек " + expectedReceipt + ". Фактический " + actualReceipt,
                expectedReceipt, actualReceipt);
        System.out.println(actualReceipt);
    }

}
