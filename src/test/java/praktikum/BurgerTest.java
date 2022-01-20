package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {


    @Mock
    Ingredient ingredient;
    @Mock
    Bun bun;


    @Test
    public void addIngredientTest() {
        //Arrange
        Burger burger = new Burger();
        //Act
        for(int i = 0; i <= 2; i++) {
            burger.addIngredient(new Ingredient(IngredientType.SAUCE, "hot sauce", 100));
        }
        int actual = burger.ingredients.size();
        int expected = 2;
        String actualName = burger.ingredients.get(0).name;
        float actualPrice = burger.ingredients.get(0).price;
        IngredientType actualType = burger.ingredients.get(0).type;
        //Assert
        assertEquals("Длина списков не совпадает",expected, actual);
        assertEquals("Название элемента не совпадает", "hot sauce", actualName);
        assertEquals("Стоимость не совпадает", 100, actualPrice, 0);
        assertEquals("Соус не совпадает", IngredientType.SAUCE, actualType);


    }

    @Test
    public void removeIngredientTest() {
        //Arrange
        Burger burger = new Burger();
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "hot sauce", 100);
        for(int i = 0; i <= 3; i++) {
            burger.addIngredient(ingredient);
        }
        //Act
        burger.removeIngredient(1);
        burger.removeIngredient(1);
        int actual = burger.ingredients.size();
        int expected = 1;
        //Assert
        assertEquals("Длина списков не совпадает",expected, actual);

    }

    @Test
    public void moveIngredientTest() {
        //Arrange
        Burger burger = new Burger();
        for(int i = 0; i < 5; i++) {
            burger.addIngredient(new Ingredient(IngredientType.FILLING, "cutlet", 100));
        }
        burger.addIngredient(new Ingredient(IngredientType.FILLING, "sausage", 300));
        //Act
        burger.moveIngredient(5,0);
        String actualName = burger.ingredients.get(0).name;
        //Assert
        assertEquals("Название ингредиента котлета не совпадает", "sausage", actualName);

    }

    @Test
    public void getPriceTest() {
        //Arrange
        Burger burger = new Burger();
        when(bun.getPrice()).thenReturn(100f);
        burger.setBuns(bun);
        when(ingredient.getPrice()).thenReturn(100f);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient);
        //Act
        float expectedPrice = 400;
        float actualPrice = burger.getPrice();
        //Assert
        assertEquals("Расчитанная цена не совпадает", expectedPrice, actualPrice, 0);

    }

    @Test
    public void getReceiptTest() {
        //Arrange
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        when(bun.getName()).thenReturn("MegaBurger");
        when(ingredient.getType()).thenReturn(IngredientType.FILLING);
        when(ingredient.getName()).thenReturn("cutlet");
        when(burger.getPrice()).thenReturn(500f);
        //Act
        String actualReceipt  = burger.getReceipt();
        StringBuilder expextedReceipt = new StringBuilder(String.format("(==== %s ====)%n", "MegaBurger"));
        expextedReceipt.append(String.format("= %s %s =%n", "filling","cutlet"));
        expextedReceipt.append(String.format("(==== %s ====)%n", "MegaBurger"));
        expextedReceipt.append(String.format("%nPrice: %f%n", 500.0));
        //Assert
        assertEquals("Рецепт не совпадает!", expextedReceipt.toString(),actualReceipt);

    }


}