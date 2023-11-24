package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import static org.junit.Assert.*;
import java.util.List;
import java.util.ArrayList;



@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    Database database;


    public void getAvailableBuns(){
        List<Bun> buns = new ArrayList<>();
        buns.add(new Bun("black bun", 100));
        buns.add(new Bun("white bun", 200));
        buns.add(new Bun("red bun", 300));
        Mockito.when(database.availableBuns()).thenReturn(buns);
    }
    public void getAvailableIngredients(){
        List<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(new Ingredient(IngredientType.SAUCE, "hot sauce", 100));
        ingredients.add(new Ingredient(IngredientType.SAUCE, "sour cream", 200));
        ingredients.add(new Ingredient(IngredientType.SAUCE, "chili sauce", 300));
        ingredients.add(new Ingredient(IngredientType.FILLING, "cutlet", 100));
        ingredients.add(new Ingredient(IngredientType.FILLING, "dinosaur", 200));
        ingredients.add(new Ingredient(IngredientType.FILLING, "sausage", 300));
        Mockito.when(database.availableIngredients()).thenReturn(ingredients);
    }


    @Test
    public void setBunsPositiveTest() {
        getAvailableBuns();
        Bun bun  = database.availableBuns().get(0);
        Burger burger = new Burger();
        burger.setBuns(bun);

        Assert.assertEquals("У былки не то имя",database.availableBuns().get(0).getName(),burger.bun.getName() );
        Assert.assertEquals("У былки не та цена",database.availableBuns().get(0).getPrice() ,burger.bun.getPrice() ,0);
    }

    @Test
    public void addIngredientPositiveTest() {

        getAvailableIngredients();
        Burger burger = new Burger();

        Ingredient ingredient = database.availableIngredients().get(1);
        burger.addIngredient(ingredient);
        assertTrue("Элемент не добавлен", burger.ingredients.contains(ingredient));


    }

    @Test
    public void removeFirstIngredientTest() {
        getAvailableIngredients();
        Burger burger = new Burger();

        Ingredient ingredient = database.availableIngredients().get(1);
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        Assert.assertEquals("Элемент не удален",0, burger.ingredients.size());

    }

    @Test
    public void moveIngredientTest() {
        getAvailableIngredients();
        Burger burger = new Burger();

        burger.addIngredient(database.availableIngredients().get(0));
        burger.addIngredient(database.availableIngredients().get(1));
        burger.addIngredient(database.availableIngredients().get(2));

        burger.moveIngredient(1, 0);
        assertEquals("Перемешенный элемент не соответствует переданному",database.availableIngredients().get(1), burger.ingredients.get(0));
        assertEquals("Последний ингредиент изменился", database.availableIngredients().get(2), burger.ingredients.get(2));

    }

    @Test
    public void getPricePositiveTest() {

        getAvailableIngredients();
        getAvailableBuns();

        Burger burger = new Burger();

        burger.setBuns(database.availableBuns().get(0));
        burger.addIngredient(database.availableIngredients().get(4));
        assertEquals("Цена бургера не соответвует",400, burger.getPrice(),0);


    }

    @Test
    public void getReceiptTest() {

        getAvailableIngredients();
        getAvailableBuns();

        Burger burger = new Burger();

        burger.addIngredient(database.availableIngredients().get(0));
        burger.addIngredient(database.availableIngredients().get(5));
        burger.addIngredient(database.availableIngredients().get(4));
        burger.setBuns(database.availableBuns().get(0));

        StringBuilder expected = new StringBuilder(String.format("(==== %s ====)%n", "black bun"));
        expected.append(String.format("= %s =%n", "sauce hot sauce"));
        expected.append(String.format("= %s =%n", "filling sausage"));
        expected.append(String.format("= %s =%n", "filling dinosaur"));
        expected.append(String.format("(==== %s ====)%n", "black bun"));
        expected.append(String.format("%nPrice: %f%n", 800.0));

        String receipt = burger.getReceipt();

        Assert.assertEquals(expected.toString(), receipt);

    }
}