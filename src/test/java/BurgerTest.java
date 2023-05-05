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
            new Ingredient(SAUCE, "Кетчуп", 10),
            new Ingredient(FILLING, "Отбивная", 120),
            new Ingredient(FILLING, "Плавленый Сыр", 40),
            new Ingredient(FILLING, "Сочный помидор", 25),
            new Ingredient(FILLING, "Морковь по-корейски", 30),
            new Ingredient(FILLING, "Капуста белокочанная", 20),
            new Ingredient(FILLING, "Чеснок", 5),
            new Ingredient(SAUCE, "Майонез", 15),
    };


    @Test
    public void setBunTest() {
        burger.setBuns(new Bun("Половина свежей булочки", 30));
        assertEquals("Половина свежей булочки", burger.bun.getName());
        assertEquals(30, burger.bun.getPrice(), TestConstants.DELTA);
    }

    @Test
    public void addIngredientTest() {
        for (int i = 0; i < ingredients.length; i++) {
            burger.addIngredient(ingredients[i]);
            assertEquals("Ингредиент отличается от ожидаемого", ingredients[i], burger.ingredients.get(i));
        }
    }

    @Test
    public void removeIngredientIsCorrectTest() {
        for (Ingredient value : ingredients) {
            burger.addIngredient(value);
        }
        burger.removeIngredient(6);
        assertEquals("Ингредиентов больше, чем должно быть",7, burger.ingredients.size());
    }

    @Test
    public void moveIngredientTest() {
        for (Ingredient value : ingredients) {
            burger.addIngredient(value);
        }
        burger.moveIngredient(0, 7);
        burger.moveIngredient(6, 0);
        assertEquals("Порядок ингредиентов отличается от ожидаемого", ingredients[0], burger.ingredients.get(7));
        assertEquals("Порядок ингредиентов отличается от ожидаемого", ingredients[7], burger.ingredients.get(0));
    }

    @Test
    public void getPriceTest() {
        Mockito.when(bun.getPrice()).thenReturn(30F);
        Mockito.when(ingredient.getPrice()).thenReturn(10F);
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        float expected = 70;
        assertEquals("Цена бургера не соответствует ожидаемой", expected, burger.getPrice(), TestConstants.DELTA);
    }

    @Test
    public void getReceiptTest () {
        burger.setBuns(bun);
        for (Ingredient value : ingredients) {
            burger.addIngredient(value);
        }

        Mockito.when(burger.getPrice()).thenReturn(220F);
        String actualReceipt = burger.getReceipt();

        StringBuilder expectedReceipt = new StringBuilder(String.format("(==== %s ====)%n", bun.name));
        for (Ingredient value : ingredients) {
            expectedReceipt.append(String.format("= %s %s =%n", value.type.toString().toLowerCase(), value.name));
        }
        expectedReceipt.append(String.format("(==== %s ====)%n", bun.name));
        expectedReceipt.append(String.format("%nPrice: %f%n", burger.getPrice()));

        assertEquals("Чек отличается от ожидаемого", expectedReceipt.toString(), actualReceipt);
    }

}