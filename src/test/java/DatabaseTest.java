import praktikum.*;
import org.junit.Test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

public class DatabaseTest {

    @Test
    public void availableIngredientsTest() {

        Database database = new Database();
        List<Ingredient> listOfExpIngredients = new ArrayList<>();
        listOfExpIngredients.add(new Ingredient(IngredientType.SAUCE, "hot sauce", 100));
        listOfExpIngredients.add(new Ingredient(IngredientType.SAUCE, "sour cream", 200));
        listOfExpIngredients.add(new Ingredient(IngredientType.SAUCE, "chili sauce", 300));
        listOfExpIngredients.add(new Ingredient(IngredientType.FILLING, "cutlet", 100));
        listOfExpIngredients.add(new Ingredient(IngredientType.FILLING, "dinosaur", 200));
        listOfExpIngredients.add(new Ingredient(IngredientType.FILLING, "sausage", 300));
        // Считаем список доступных ингредиентов из базы данных
        List<Ingredient> actIngredients = database.availableIngredients();
        for (Ingredient element : actIngredients) {
            // тело цикла
            System.out.println(element.type + " " + element.name + " " + element.price);
        }
        boolean result = true;
        //проверяем размер списков с ожидаемыми ингридиентами и актуальными
        if (actIngredients.size() == listOfExpIngredients.size()) {
            //при совпадении размеров списков сверяем элементы
            for (int i = 0; i < actIngredients.size(); i++) {
                assertEquals(listOfExpIngredients.get(i).type, actIngredients.get(i).type);
                assertEquals(listOfExpIngredients.get(i).name, actIngredients.get(i).name);
                assertEquals(listOfExpIngredients.get(i).price, actIngredients.get(i).price, 0);
            }
        } else {
            //если размеры списков не совпадают
            result = false;
        }
        assertTrue(result);
    }

    @Test
    public void availableBunsTest() {

        Database database = new Database();
        List<Bun> listOfExpBuns = new ArrayList<>();
        listOfExpBuns.add(new Bun("black bun", 100));
        listOfExpBuns.add(new Bun("white bun", 200));
        listOfExpBuns.add(new Bun("red bun", 300));
        // Считаем список доступных булок из базы данных
        List<Bun> actBuns = database.availableBuns();
        for (Bun element : actBuns) {
            // тело цикла
            System.out.println(element.name + " " + element.price);
        }
        boolean result = true;
        //проверяем размер списков с ожидаемыми булками и актуальными булками
        if (actBuns.size() == listOfExpBuns.size()) {
            //при совпадении размеров списков сверяем элементы
            for (int i = 0; i < actBuns.size(); i++) {
                assertEquals(listOfExpBuns.get(i).name, actBuns.get(i).name);
                assertEquals(listOfExpBuns.get(i).price, actBuns.get(i).price, 0);
            }
        } else {
            //если размеры списков не совпадают
            result = false;
        }
        assertTrue(result);
    }
}