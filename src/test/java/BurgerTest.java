import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient;
    Burger burger = new Burger();
    Ingredient [] ingredients = new Ingredient[] {
            new Ingredient(SAUCE, "Кетчуп", 5),
            new Ingredient(SAUCE, "Майонез", 7),
            new Ingredient(SAUCE, "Соус кари", 15)
            new Ingredient(FILLING, "Зелень", 60),
            new Ingredient(FILLING, "Колбаса", 80),
            new Ingredient(FILLING, "Сыр", 100)
    };


    @Test
    public void setBunTest() {
        burger.setBuns(new Bun("Новая булочка", 50));
        assertEquals("Новая булочка", burger.bun.getName());
        assertEquals(50, burger.bun.getPrice());
    }

    @Test
    public void addIngredientTest() {
        for (int i = 0; i < ingredients.length; i++) {
            burger.addIngredient(ingredients[i]);
            assertEquals("Ингредиенты не совпадают", ingredients[i], burger.ingredients.get(i));
        }
    }

    @Test
    public void removeIngredientTest() {
        for (Ingredient i : ingredients) {
            burger.addIngredient(i);
        }
        burger.removeIngredient(3);
        assertEquals("Неверное количество ингредиентов",5, burger.ingredients.size());
    }

    @Test
    public void moveIngredientTest() {
        for (Ingredient i : ingredients) {
            burger.addIngredient(i);
        }
        burger.moveIngredient(0, 6);
        assertEquals("Неверный порядок элементов", ingredients[0], burger.ingredients.get(6));
    }

    @Test
    public void getPriceTest() {
        Mockito.when(bun.getPrice()).thenReturn(20);
        Mockito.when(ingredient.getPrice()).thenReturn(10);
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        float expected = 50;
        assertEquals("Некорректная стоимость бургера", expected, burger.getPrice());
    }

    @Test
    public void getReceiptTest () {
        burger.setBuns(bun);
        for (Ingredient i : ingredients) {
            burger.addIngredient(i);
        }

        Mockito.when(burger.getPrice()).thenReturn(500);
        String actualReceipt = burger.getReceipt();

        StringBuilder expectedReceipt = new StringBuilder(String.format("(==== %s ====)%n", bun.name));
        for (Ingredient i : ingredients) {
            expectedReceipt.append(String.format("= %s %s =%n", i.type.toString().toLowerCase(), i.name));
        }
        expectedReceipt.append(String.format("(==== %s ====)%n", bun.name));
        expectedReceipt.append(String.format("%nPrice: %f%n", burger.getPrice()));
        assertEquals("Чек отличается от ожидаемого", expectedReceipt.toString(), actualReceipt);
}